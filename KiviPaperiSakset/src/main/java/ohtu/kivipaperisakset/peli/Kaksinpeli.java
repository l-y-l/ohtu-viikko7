
package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.io.IO;

public class Kaksinpeli extends Peli {

    public Kaksinpeli(IO io, Pelilogiikka pelilogiikka) {
        super(io, pelilogiikka);
    }

    @Override
    protected String tokanPelaajanVuoro(String ekanSiirto) {
        io.tulosta("Toisen pelaajan siirto: ");

        return io.pyydaSyote();
    }
}