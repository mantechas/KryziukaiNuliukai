package neuroninisTinklas;

import zaidimas.Lenta;
import zaidimas.Langeliai;
import zaidimas.ZaidimoVariklis;

public class BotoVariklis implements ZaidimoVariklis {

    private IvestiesSluoksnis ivestiesSluoksnis;

    private PasleptasSluoksnis pasleptasSluoksnis; 

    private IsvestiesSluoksnis isvestiesSluoksnis;

    public BotoVariklis() {
        sudaryti();
    }

    public void sudaryti() {

        ivestiesSluoksnis = new IvestiesSluoksnis();
        ivestiesSluoksnis.sudaryti(27);

        pasleptasSluoksnis = new PasleptasSluoksnis();
        pasleptasSluoksnis.sudaryti(9);

        isvestiesSluoksnis = new IsvestiesSluoksnis();
        isvestiesSluoksnis.sudaryti(1);
    }

    @Override
    public int eiti(Lenta lenta, Langeliai zaidejas, boolean mokymasis) {

        ivestiesSluoksnis.pradeti(lenta);
        pasleptasSluoksnis.pradeti(ivestiesSluoksnis, zaidejas);
        int ejimas = isvestiesSluoksnis.pradeti(pasleptasSluoksnis);

        lenta.ejimas(ejimas, zaidejas);

        if (mokymasis) {
            if (lenta.laimeta(zaidejas)) {
                    pasleptasSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima(), 0.1d);
                    ivestiesSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima(), 0.2d,
                    pasleptasSluoksnis.gautiNeurona(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima()).gautiPaskutiniNaudotaIvestiesNeurona());

                    pasleptasSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPirmaEjima(), 0.1d);
                    ivestiesSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPirmaEjima(), 0.2d,
                            pasleptasSluoksnis.gautiNeurona(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima()).gautiPirmaNaudotaIvestiesNeurona());
            }
        }

        return ejimas;
    }
    
    @Override
    public void perjungtiTarpZaidimu() {
        for (int i = 0; i < pasleptasSluoksnis.gautiNeuronuSkaiciu(); i++) {
            pasleptasSluoksnis.gautiNeurona(i).perjungtiTarpZaidimu();
        }

        for (int i = 0; i < isvestiesSluoksnis.gautiNeuronuSkaiciu(); i++) {
            isvestiesSluoksnis.gautiNeurona(i).perjungtiTarpZaidimu();
        }

    }


}
