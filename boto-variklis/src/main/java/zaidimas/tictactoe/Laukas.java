package zaidimas.tictactoe;

public class Laukas {

    private Langeliai savininkas;

    private int numeris;

    public Laukas(int numeris) {
        this.numeris = numeris;
        savininkas = Langeliai.Tuscias;
    }

    public Laukas(int numeris, Langeliai savininkas) {
        this.numeris = numeris;
        this.savininkas = savininkas;
    }

    public Laukas kopijuoti() {
        Laukas langelis = new Laukas(numeris, savininkas);
        return langelis;
    }

    public Langeliai gautiSavininka() {
        return savininkas;
    }

    public void priskirtiSavininka(Langeliai savininkas) {
        this.savininkas = savininkas;
    }

    public int gautiNumeri() {
        return numeris;
    }

    public String erdvesAtstovavimas() {
        return " (" + numeris + ") " + savininkas.gautiAtstovavima() + " ";
    }
}
