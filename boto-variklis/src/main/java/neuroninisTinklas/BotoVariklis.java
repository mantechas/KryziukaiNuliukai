package neuroninisTinklas;

import zaidimas.tictactoe.Lenta;
import zaidimas.tictactoe.Langeliai;
import neuroninisTinklas.sluoksnis.PasleptasSluoksnis;
import neuroninisTinklas.sluoksnis.IvestiesSluoksnis;
import neuroninisTinklas.sluoksnis.IsvestiesSluoksnis;
import zaidimas.tictactoe.ZaidimoVariklis;

public class BotoVariklis implements ZaidimoVariklis {

    private int mokymosiStadija;

    private IvestiesSluoksnis ivestiesSluoksnis;

    private PasleptasSluoksnis pasleptasSluoksnis;

    private IsvestiesSluoksnis isvestiesSluoksnis;

    public BotoVariklis(int mokymosiStadija) {
        this.mokymosiStadija = mokymosiStadija;
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
                if (mokymosiStadija >= 1) {
                    pasleptasSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima(), 0.05d);
                    ivestiesSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima(), 0.075d,
                            pasleptasSluoksnis.gautiNeurona(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima()).gautiPaskutiniNaudotaIvestiesNeurona());

                    pasleptasSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPirmaEjima(), 0.05d);
                    ivestiesSluoksnis.duoti(isvestiesSluoksnis.gautiNeurona(0).gautiPirmaEjima(), 0.075d,
                            pasleptasSluoksnis.gautiNeurona(isvestiesSluoksnis.gautiNeurona(0).gautiPraeitaEjima()).gautiPirmaNaudotaIvestiesNeurona());
                }
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

    public void print() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("Ivesties sluoksnis");
        System.out.println("==================================================");
        ivestiesSluoksnis.spausdinti();

        System.out.println();
        System.out.println("==================================================");
        System.out.println("Pasleptas sluoksnis");
        System.out.println("==================================================");
        pasleptasSluoksnis.spausdinti();

        System.out.println();
        System.out.println("==================================================");
        System.out.println("Isvesties sluoksnis");
        System.out.println("==================================================");
        isvestiesSluoksnis.spausdinti();
    }
}
