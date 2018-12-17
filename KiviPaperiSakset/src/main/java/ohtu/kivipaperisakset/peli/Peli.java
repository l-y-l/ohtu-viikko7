
package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.peli.tekoaly.HelppoTekoaly;
import ohtu.kivipaperisakset.peli.tekoaly.VaikeaTekoaly;
import java.util.Arrays;
import java.util.List;

public abstract class Peli {

    private final List<String> sallitutSiirrot;

    protected IO io;
    protected Pelilogiikka pelilogiikka;

    public void pelaa() {
        while (true) {
            io.tulosta("Ensimmäisen pelaajan siirto: ");
            String ekanSiirto = io.pyydaSyote();

            String tokanSiirto = tokanPelaajanVuoro(ekanSiirto);

            if (!onkoOkSiirrot(ekanSiirto, tokanSiirto)) {
                break;
            }

            pelilogiikka.kirjaaSiirrot(ekanSiirto, tokanSiirto);
            io.tulosta(pelilogiikka.pelitilanne() + "\n");
        }

        io.tulosta("\nKiitos!");
        io.tulosta(pelilogiikka.pelitilanne());
    }

    private boolean onkoOkSiirrot(String ekanSiirto, String tokanSiirto) {
        return sallitutSiirrot.contains(ekanSiirto) && sallitutSiirrot.contains(tokanSiirto);
    }

    protected abstract String tokanPelaajanVuoro(String ekanSiirto);

    public static Peli uusiKaksinPeli(IO io) {
        return new Kaksinpeli(io, new Pelilogiikka());
    }

    public static Peli uusiHelppoYksinPeli(IO io) {
        return new Yksinpeli(io, new HelppoTekoaly(), new Pelilogiikka());
    }

    public static Peli uusiVaikeaYksinPeli(IO io) {
        return new Yksinpeli(io, new VaikeaTekoaly(20), new Pelilogiikka());
    }

    public static Peli uusiVaikeaYksinPeli(IO io, int muistiKoko) {
        return new Yksinpeli(io, new VaikeaTekoaly(muistiKoko), new Pelilogiikka());
    }

    protected Peli(IO io, Pelilogiikka pelilogiikka) {
        this.io = io;
        this.pelilogiikka = pelilogiikka;
        this.sallitutSiirrot = Arrays.asList(new String[] {"k", "s", "p"});
    }
}
