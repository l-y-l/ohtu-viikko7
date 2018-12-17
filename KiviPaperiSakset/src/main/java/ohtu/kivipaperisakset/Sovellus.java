
package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.peli.Peli;

public class Sovellus {

    private final IO io;

    public Sovellus(IO io) {
        this.io = io;
    }

    public void suorita() {
        while (true) {
            printtaaPelityypit();
            String vastaus = io.pyydaSyote();

            if (vastaus.endsWith("a")) {
                printtaaPelinAloitus();
                Peli.uusiKaksinPeli(io).pelaa();
            } else if (vastaus.endsWith("b")) {
                printtaaPelinAloitus();
                Peli.uusiHelppoYksinPeli(io).pelaa();
            } else if (vastaus.endsWith("c")) {
                printtaaPelinAloitus();
                Peli.uusiVaikeaYksinPeli(io).pelaa();
            } else {
                break;
            }
        }
    }

    private void printtaaPelinAloitus() {
        io.tulosta("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }

    private void printtaaPelityypit() {
        io.tulosta(
            "\nValitse pelataanko"
            + "\n (a) ihmistä vastaan "
            + "\n (b) tekoälyä vastaan"
            + "\n (c) parannettua tekoälyä vastaan"
            + "\nmuilla valinnoilla lopetataan"
        );
    }
}
