package neuroninisTinklas.sluoksnis;

import neuroninisTinklas.neuronas.Neuronas;

public abstract class AbstraktusSluoksnis {

    private int neoronuKiekis;

    public void sudaryti(int neoronuKiekis) {
        this.neoronuKiekis = neoronuKiekis;
        subInitialize();
    }

    public int gautiNeuronuSkaiciu() {
        return neoronuKiekis;
    }

    public void spausdinti() {
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            gautiNeurona(i).spausdinti();
        }
    }

    abstract void subInitialize();

    abstract Neuronas gautiNeurona(int numeris);

}
