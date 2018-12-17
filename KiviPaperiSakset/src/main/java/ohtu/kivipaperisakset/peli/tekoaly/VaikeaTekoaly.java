
package ohtu.kivipaperisakset.peli.tekoaly;

// "Muistava tekoäly"

import static java.util.Collections.frequency;
import java.util.*;

public class VaikeaTekoaly implements Tekoaly {

    private final LinkedList<String> muisti;
    private final int maksimiMuisti;

    public VaikeaTekoaly(int muistinKoko) {
        muisti = new LinkedList<>();
        maksimiMuisti = muistinKoko;
    }

    @Override
    public String annaSiirto() {
        if(muisti.size() <= 1) {
            return "k";
        }

        List siirrot = filtteroiSiirrot();

        int k = frequency(siirrot, "k");
        int p = frequency(siirrot, "p");
        int s = frequency(siirrot, "s");

        // Tehdään siirron valinta esimerkiksi seuraavasti;
        // - jos kiviä eniten, annetaan aina paperi
        // - jos papereita eniten, annetaan aina sakset
        // muulloin annetaan aina kivi
        if (k > p && k > s) {
            return "p";
        } else if (p > k && p > s) {
            return "s";
        } else {
            return "k";
        }
    }
    
    private List filtteroiSiirrot() {
        String viimeisinSiirto = muisti.getLast();
        List filtteroityLista = new ArrayList<>();

        for(int i = 0; i < muisti.size() - 2; i++) {
            if (muisti.get(i).equals(viimeisinSiirto)) {
                filtteroityLista.add(muisti.get(i+1));
            }
        }

        return filtteroityLista;
    }

    @Override
    public void sailytaSiirto(String siirto) {
        if(muisti.size() == maksimiMuisti) {
            muisti.removeFirst();
        }

        muisti.addLast(siirto);
    }
}