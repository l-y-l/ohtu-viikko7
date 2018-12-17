
package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.KonsoliIO;

public class Paaohjelma {

    public static void main(String[] args) {
        Sovellus sovellus = new Sovellus(new KonsoliIO());
        sovellus.suorita();
    }
}
