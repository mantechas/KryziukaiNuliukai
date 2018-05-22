package neuroninisTinklas;

public abstract class AbstraktusSluoksnis {

    private int neoronuKiekis; // neuronų kiekis

    public void sudaryti(int neoronuKiekis) {
        this.neoronuKiekis = neoronuKiekis;
        nustatyti();
    }

    //Gauti neuronų kiekį
    public int gautiNeuronuSkaiciu() {
        return neoronuKiekis;
    }

    //Spausdinama neurono informacija
    public void spausdinti() {
        for (int i = 0; i < gautiNeuronuSkaiciu(); i++) {
            gautiNeurona(i).spausdinti();
        }
    }
    
    abstract void nustatyti();

    abstract Neuronas gautiNeurona(int numeris);

}
