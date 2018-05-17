package neuroninisTinklas.neuronas;

import java.util.List;

public class IsvestiesNeuronai extends Neuronas {

    private int pirmoEjimoIndeksas = -1;

    private int paskutinioEjimoIndeksas;

    public int pradeti(List<Boolean> kandidatiniaiEjimai, List<Double> vietosReiksmes, List<Double> ivestiesSvoriai) {

        priskirtiIvestiesSvorius(ivestiesSvoriai);

        int ejimoIndeksas = 0;
        double paskutineReiksme = 0d;

        for (int i = 0; i < kandidatiniaiEjimai.size(); i++) {

            if (kandidatiniaiEjimai.get(i) == true) {

                double reiksme = 1 / (1 + Math.exp((vietosReiksmes.get(i) * ivestiesSvoriai.get(i)) * -1));

                if (reiksme > paskutineReiksme) {
                    ejimoIndeksas = i;
                    paskutineReiksme = reiksme;
                }
            }
        }

        paskutinioEjimoIndeksas = ejimoIndeksas;
        if (pirmoEjimoIndeksas == -1) {
            pirmoEjimoIndeksas = ejimoIndeksas;
        }

        return paskutinioEjimoIndeksas+1;
    }

    public int gautiPraeitaEjima() {
        return paskutinioEjimoIndeksas;
    }

    public int gautiPirmaEjima() {
        return pirmoEjimoIndeksas;
    }

    public void perjungtiTarpZaidimu() {
        pirmoEjimoIndeksas = -1;
    }
}
