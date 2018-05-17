package neuroninisTinklas.neuronas;

import zaidimas.tictactoe.Laukas;
import zaidimas.tictactoe.Langeliai;

import java.util.ArrayList;
import java.util.List;


public class PasleptiNeuronai extends Neuronas {

    private boolean kandidatinisEjimas;

    private double pozicijosReiksme;

    private List<Integer> pirmasPanaudotasIvestiesNeuronas;

    private List<Integer> paskutinisPanaudotasIvestiesNeuronas = new ArrayList<>();

    public void aktyvuoti(List<Laukas> laukai, List<Double> reiksmes, List<Double> ivestiesSvoriai, Langeliai zaidejas) {

        priskirtiIvestiesSvorius(ivestiesSvoriai);

        int numatomasLangelioNumeris = gautiNumeri() * 3;

        if (laukai.get(numatomasLangelioNumeris).gautiSavininka() == Langeliai.Tuscias) {
            kandidatinisEjimas = true;
        } else {
            kandidatinisEjimas = false;
        }

        boolean pirmasEjimas = false;
        if (pirmasPanaudotasIvestiesNeuronas == null) {
            pirmasPanaudotasIvestiesNeuronas = new ArrayList<>();
            pirmasEjimas = true;
        }
        paskutinisPanaudotasIvestiesNeuronas.clear();

        //
        // Using different input weights and different field values depending on the fact if a field is
        // empty, already owned or owned by the opponent.
        //
        double ivestiesSvoriuSuma = 0d;
        int ivestiesNumeris = 0;
        for (int i = 1; i <= 9; i++) {
            if (laukai.get(ivestiesNumeris).gautiSavininka() == Langeliai.Tuscias) {
                ivestiesSvoriuSuma += (ivestiesSvoriai.get(ivestiesNumeris) * reiksmes.get(ivestiesNumeris));
                if (pirmasEjimas) {
                    pirmasPanaudotasIvestiesNeuronas.add(ivestiesNumeris);
                }
                paskutinisPanaudotasIvestiesNeuronas.add(ivestiesNumeris);
                ivestiesNumeris += 3;
            } else if (laukai.get(ivestiesNumeris + 1).gautiSavininka() == zaidejas) {
                ivestiesSvoriuSuma += (ivestiesSvoriai.get(ivestiesNumeris + 1) * (reiksmes.get(ivestiesNumeris + 1) / 2));
                if (pirmasEjimas) {
                    pirmasPanaudotasIvestiesNeuronas.add(ivestiesNumeris + 1);
                }
                paskutinisPanaudotasIvestiesNeuronas.add(ivestiesNumeris + 1);
                ivestiesNumeris += 3;
            } else {
                ivestiesSvoriuSuma += (ivestiesSvoriai.get(ivestiesNumeris + 2) * (reiksmes.get(ivestiesNumeris + 2) / 4));
                if (pirmasEjimas) {
                    pirmasPanaudotasIvestiesNeuronas.add(ivestiesNumeris + 2);
                }
                paskutinisPanaudotasIvestiesNeuronas.add(ivestiesNumeris + 2);
                ivestiesNumeris += 3;
            }
        }

        pozicijosReiksme = 1 / (1 + Math.exp(ivestiesSvoriuSuma * (-1)));
    }

    public boolean kandidatinisEjimas() {
        return kandidatinisEjimas;
    }

    public double gautiVietosReiksme() {
        return pozicijosReiksme;
    }

    public List<Integer> gautiPirmaNaudotaIvestiesNeurona() {
        return pirmasPanaudotasIvestiesNeuronas;
    }

    public List<Integer> gautiPaskutiniNaudotaIvestiesNeurona() {
        return paskutinisPanaudotasIvestiesNeuronas;
    }

    public void perjungtiTarpZaidimu() {
        pirmasPanaudotasIvestiesNeuronas = null;
        paskutinisPanaudotasIvestiesNeuronas.clear();
    }
}
