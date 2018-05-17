package neuroninisTinklas.neuronas;

import zaidimas.tictactoe.Laukas;

public class IvestiesNeuronai extends Neuronas {

    private Laukas langelis;

    private double reiksme;

    public void aktivuoti(Laukas langelis) {
        this.langelis = langelis;

        switch (langelis.gautiNumeri()) {

            case 1:
            case 3:
            case 7:
            case 9:
                reiksme = 0.2d;
                break;

            case 2:
            case 4:
            case 6:
            case 8:
                reiksme = 0.3d;
                break;

            case 5:
                reiksme = 0.4d;
                break;
        }
    }

    public Laukas gautiLauka() {
        return langelis;
    }

    public double gautiReiksme() {
        return reiksme;
    }
}
