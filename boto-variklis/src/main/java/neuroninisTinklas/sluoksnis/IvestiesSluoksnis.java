package neuroninisTinklas.sluoksnis;

import zaidimas.tictactoe.Lenta;
import zaidimas.tictactoe.Laukas;
import neuroninisTinklas.neuronas.IvestiesNeuronai;

import java.util.ArrayList;
import java.util.List;

public class IvestiesSluoksnis extends AbstraktusSluoksnis {

    private List<IvestiesNeuronai> ivestiesNeuronai;

    @Override
    public void subInitialize() {
        ivestiesNeuronai = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            IvestiesNeuronai neuronas = new IvestiesNeuronai();
            neuronas.priskirti(i,0, 9);
            ivestiesNeuronai.add(neuronas);
        }
    }

    public void pradeti(Lenta lenta) {

        int neuronoNumeris = 0;
        for (int i = 1; i <= 9; i++) {

            //
            // Three neurons always representing the same field to differ between empty fields,
            // own fields and fields occupied by an opponent
            //
            ivestiesNeuronai.get(neuronoNumeris).aktivuoti(lenta.gautiLangeli(i));
            neuronoNumeris++;
            ivestiesNeuronai.get(neuronoNumeris).aktivuoti(lenta.gautiLangeli(i));
            neuronoNumeris++;
            ivestiesNeuronai.get(neuronoNumeris).aktivuoti(lenta.gautiLangeli(i));
            neuronoNumeris++;
        }
    }

    @Override
    public IvestiesNeuronai gautiNeurona(int numeris) {
        return ivestiesNeuronai.get(numeris);
    }

    public List<Double> gautiIsvestiesSvorius(int numeris) {

        List<Double> svoriai = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            svoriai.add(ivestiesNeuronai.get(i).gautiIsvestiesSvorius().get(numeris));
        }

        return svoriai;
    }

    public List<Laukas> gautiLaukus() {
        List<Laukas> laukai = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            laukai.add(ivestiesNeuronai.get(i).gautiLauka());
        }

        return laukai;
    }

    public List<Double> gautiReiksmes() {
        List<Double> reiksmes = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            reiksmes.add(ivestiesNeuronai.get(i).gautiReiksme());
        }

        return reiksmes;
    }

    public void duoti(int indeksas, double reiksme, List<Integer> neuronoIndeksuSarasas) {

        for (Integer i : neuronoIndeksuSarasas) {
            ivestiesNeuronai.get(i).gautiIsvestiesSvorius().set(indeksas, ivestiesNeuronai.get(i).gautiIsvestiesSvorius().get(indeksas) + 0.01d);
        }

        int IvestiesIndeksas = indeksas * 3;
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            if (i == IvestiesIndeksas) {
                IvestiesNeuronai neuronas = ivestiesNeuronai.get(i);
                neuronas.gautiIsvestiesSvorius().set(indeksas, neuronas.gautiIsvestiesSvorius().get(indeksas) + reiksme);

                if (neuronas.gautiIsvestiesSvorius().get(indeksas) >= 1) {
                    neuronas.gautiIsvestiesSvorius().set(indeksas, 0.999d);
                }
            }
        }



    }
}
