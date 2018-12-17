
package ohtu.kivipaperisakset.io;

import java.util.Scanner;

public class KonsoliIO implements IO {

    private final Scanner lukija;

    public KonsoliIO() {
        this.lukija = new Scanner(System.in);
    }

    @Override
    public String pyydaSyote() {
        return lukija.nextLine();
    }

    @Override
    public void tulosta(String tuloste) {
        System.out.println(tuloste);
    }
}
