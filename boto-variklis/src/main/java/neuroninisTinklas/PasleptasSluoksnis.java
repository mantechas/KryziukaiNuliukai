package neuroninisTinklas;

import zaidimas.Langeliai;

import java.util.ArrayList;
import java.util.List;

public class PasleptasSluoksnis extends AbstraktusSluoksnis {

    private List<PasleptiNeuronai> pasleptiNeuronai;

    @Override
    public void nustatyti() {
        pasleptiNeuronai = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            PasleptiNeuronai neuronas = new PasleptiNeuronai();
            neuronas.priskirti(i,27, 1);
            pasleptiNeuronai.add(neuronas);
        }
    }

    @Override
    public PasleptiNeuronai gautiNeurona(int numeris) {
        return pasleptiNeuronai.get(numeris);
    }

    public void pradeti(IvestiesSluoksnis ivestiesSluoksnis, Langeliai zaidejas) {

        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            pasleptiNeuronai.get(i).aktyvuoti(ivestiesSluoksnis.gautiLaukus(), ivestiesSluoksnis.gautiReiksmes(), ivestiesSluoksnis.gautiIsvestiesSvorius(i), zaidejas);
        }
    }

    public List<Double> gautiIsvestiesSvorius(int numeris) {

        List<Double> svoriai = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            svoriai.add(pasleptiNeuronai.get(i).gautiIsvestiesSvorius().get(numeris));
        }

        return svoriai;
    }

    public List<Boolean> kandidatinisEjimas() {

        List<Boolean> kandidatinisEjimas = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            kandidatinisEjimas.add(pasleptiNeuronai.get(i).kandidatinisEjimas());
        }

        return kandidatinisEjimas;
    }

    public List<Double> vietosReiksmes() {

        List<Double> vietosReiksmes = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            vietosReiksmes.add(pasleptiNeuronai.get(i).gautiVietosReiksme());
        }

        return vietosReiksmes;
    }

    public void duoti(int indeksas, double reiksme) {
        PasleptiNeuronai neuronas = gautiNeurona(indeksas);
        neuronas.gautiIsvestiesSvorius().set(0, neuronas.gautiIsvestiesSvorius().get(0) + reiksme);

        if (neuronas.gautiIsvestiesSvorius().get(0) >= 1) {
            neuronas.gautiIsvestiesSvorius().set(0, 0.99d);
        }

    }
}
