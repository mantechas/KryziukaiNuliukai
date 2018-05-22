package neuroninisTinklas;

import java.util.List;

public class IsvestiesNeuronai extends Neuronas {

    private int pirmoEjimoIndeksas = -1;

    private int paskutinioEjimoIndeksas;

    public int pradeti(List<Boolean> kandidatiniaiEjimai, List<Double> vietosReiksmes, List<Double> ivestiesSvoriai) {

        priskirtiIvestiesSvorius(ivestiesSvoriai);

        int ejimoIndeksas = 0;
        double paskutineReiksme = 0;

        for (int i = 0; i < kandidatiniaiEjimai.size(); i++) { //Surandamas sekantis ejimas

            if (kandidatiniaiEjimai.get(i) == true) {

                double reiksme = 1 / (1 + Math.exp((vietosReiksmes.get(i) * ivestiesSvoriai.get(i)) * -1));

                if (reiksme > paskutineReiksme) {
                    ejimoIndeksas = i;
                    paskutineReiksme = reiksme;
                }
            }
        }

        paskutinioEjimoIndeksas = ejimoIndeksas;
        if (pirmoEjimoIndeksas == -1) { //Nustatomas pirmas ejimas
            pirmoEjimoIndeksas = ejimoIndeksas;
        }

        return paskutinioEjimoIndeksas+1;
    }

    //Gaunamas praeito ejimo indeksas
    public int gautiPraeitaEjima() {
        return paskutinioEjimoIndeksas;
    }

    //Gaunamas pirmo ejimo indeksas
    public int gautiPirmaEjima() {
        return pirmoEjimoIndeksas;
    }

    //Tarp žaidimų nunulinamas pirmo ejimo indeksas
    public void perjungtiTarpZaidimu() {
        pirmoEjimoIndeksas = -1;
    }
}
