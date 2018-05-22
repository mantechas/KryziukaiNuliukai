package neuroninisTinklas;

import zaidimas.Laukas;

public class IvestiesNeuronai extends Neuronas {

    private Laukas langelis;

    private double reiksme;

    public void aktivuoti(Laukas langelis) {
        this.langelis = langelis;
        this.reiksme = 0.5d;
    }

    public Laukas gautiLauka() {
        return langelis;
    }

    public double gautiReiksme() {
        return reiksme;
    }
}
