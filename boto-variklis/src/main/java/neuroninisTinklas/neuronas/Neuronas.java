package neuroninisTinklas.neuronas;

import java.util.ArrayList;
import java.util.List;

public class Neuronas {

    private List<Double> ivestiesSvoriai;

    private List<Double> isvestiesSvoriai;

    private int ivestiesSvoriuNumeris;

    private int isvestiesSvoriuNumeris;

    private int numeris;

    public void priskirti(int numeris, int ivestiesSvoriuNumeris, int isvestiesSvoriuNumeris) {
        this.numeris = numeris;
        this.ivestiesSvoriuNumeris = ivestiesSvoriuNumeris;
        this.isvestiesSvoriuNumeris = isvestiesSvoriuNumeris;

        ivestiesSvoriai = new ArrayList<>();
        for (int i = 0; i < ivestiesSvoriuNumeris; i++) {
            ivestiesSvoriai.add(pradinisSvoris());
        }

        isvestiesSvoriai = new ArrayList<>();
        for (int j = 0; j < isvestiesSvoriuNumeris; j++) {
            isvestiesSvoriai.add(pradinisSvoris());
        }
    }

    public void spausdinti() {
        System.out.print("Ivesties neuronu svoriai " + numeris + ": ");
        for (int i = 0; i < ivestiesSvoriuNumeris; i++) {
            System.out.print("[" + ivestiesSvoriai.get(i) + "] ");
        }
        System.out.println();

        System.out.print("Isvesties neuronu svoriai " + numeris + ": ");
        for (int i = 0; i < isvestiesSvoriuNumeris; i++) {
            System.out.print("[" + isvestiesSvoriai.get(i) + "] ");
        }
        System.out.println();
    }

    public List<Double> gautiIvestiesSvorius() {
        return ivestiesSvoriai;
    }

    public void priskirtiIvestiesSvorius(List<Double> ivestiesSvoriai) {
        this.ivestiesSvoriai = ivestiesSvoriai;
    }

    public List<Double> gautiIsvestiesSvorius() {
        return isvestiesSvoriai;
    }

    public void priskirtiIsvestiesSvorius(List<Double> isvestiesSvoriai) {
        this.isvestiesSvoriai = isvestiesSvoriai;
    }

    public int gautiNumeri() {
        return numeris;
    }

    public void priskirtiNumeri(int numeris) {
        this.numeris = numeris;
    }

    private double pradinisSvoris() {
        return Math.random();
    }



}
