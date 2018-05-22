package neuroninisTinklas;
import java.util.ArrayList;
import java.util.List;

public class IsvestiesSluoksnis extends AbstraktusSluoksnis {

    private List<IsvestiesNeuronai> isvestiesNeuronai;

    @Override
    public void nustatyti() {
        isvestiesNeuronai = new ArrayList<>();
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            IsvestiesNeuronai neuronas = new IsvestiesNeuronai();
            neuronas.priskirti(i,9, 1);
            isvestiesNeuronai.add(neuronas);
        }
    }

    @Override
    public IsvestiesNeuronai gautiNeurona(int numeris) {
        return isvestiesNeuronai.get(numeris);
    }

    public int pradeti(PasleptasSluoksnis pasleptasSluoksnis) {
        return isvestiesNeuronai.get(0).pradeti(pasleptasSluoksnis.kandidatinisEjimas(), pasleptasSluoksnis.vietosReiksmes(),
                pasleptasSluoksnis.gautiIsvestiesSvorius(0));
    }
}
