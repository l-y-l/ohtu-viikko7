
package ohtu.kivipaperisakset.peli.tekoaly;

public class HelppoTekoaly implements Tekoaly {

    private static final String[] SIIRTO_MAP = {"k", "p", "s"};

    private int siirto;

    public HelppoTekoaly() {
        siirto = 0;
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        return SIIRTO_MAP[siirto];
    }

    @Override
    public void sailytaSiirto(String siirto) {
        // ei tehdä mitään 
    }
}
