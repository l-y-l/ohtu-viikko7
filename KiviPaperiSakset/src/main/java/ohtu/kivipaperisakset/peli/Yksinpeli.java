
package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.peli.tekoaly.Tekoaly;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class Yksinpeli extends Peli {

    private final Tekoaly tekoaly;

    public Yksinpeli(IO io, Tekoaly tekoaly, Pelilogiikka pelilogiikka) {
        super(io, pelilogiikka);
        this.tekoaly = tekoaly;
    }

    @Override
    protected String tokanPelaajanVuoro(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();

        io.tulosta("Tietokone valitsi: " + tokanSiirto);
        tekoaly.sailytaSiirto(ekanSiirto);

        return tokanSiirto;
    }
}
