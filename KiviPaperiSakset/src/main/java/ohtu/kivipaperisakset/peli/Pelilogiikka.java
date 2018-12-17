
package ohtu.kivipaperisakset.peli;

import java.util.Arrays;
import java.util.List;

public class Pelilogiikka {

    private final List<String> ekanVoittotilanteet;

    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;

    public Pelilogiikka() {
        this.ekanPisteet = 0;
        this.tokanPisteet = 0;
        this.tasapelit = 0;
        this.ekanVoittotilanteet = Arrays.asList(new String[] {"ks", "sp", "pk"});
    }

    public void kirjaaSiirrot(String ekanSiirto, String tokanSiirto) {
        if (tasapeli(ekanSiirto, tokanSiirto)) {
            tasapelit++;
        } else if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            ekanPisteet++;
        } else {
            tokanPisteet++;
        }
    }

    // sisäinen metodi, jolla tarkastetaan tuliko tasapeli
    private static boolean tasapeli(String ekanSiirto, String tokanSiirto) {
        return ekanSiirto.equals(tokanSiirto);
    }

    // sisäinen metodi joka tarkastaa voittaako eka pelaaja tokan
    private boolean ekaVoittaa(String ekanSiirto, String tokanSiirto) {
        return ekanVoittotilanteet.contains(ekanSiirto + tokanSiirto);
    }

    public String pelitilanne() {
        String tuloste = "Pelitilanne: " + ekanPisteet + " - " + tokanPisteet;
        return tuloste + "\nTasapelit: " + tasapelit;
    }
}