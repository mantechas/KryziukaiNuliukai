package zaidimas.tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lenta {

    private static final int Eilutes = 3;

    private static final int Stulpeliai = 3;

    private Map<Integer, Laukas> zaidimoLenta = new HashMap<>();

    public Lenta() {
        sudaryti();
    }

    public void sudaryti() {
        for (int eilute = 1; eilute <= Eilutes; eilute++) {
            for (int stulpelis = 1; stulpelis <= Stulpeliai; stulpelis++) {
                Laukas laukas = new Laukas(skaicius(eilute, stulpelis));
                zaidimoLenta.put(skaicius(eilute, stulpelis), laukas);
            }
        }
    }

    public void ejimas(int skaicius, Langeliai savininkas) {
        if (zaidimoLenta.get(skaicius).gautiSavininka() != Langeliai.Tuscias) {
            throw new RuntimeException("Negalimas ejimas, langelis jau užimtas: " + skaicius);
        }

        Laukas langelis = zaidimoLenta.get(skaicius);
        langelis.priskirtiSavininka(savininkas);
    }

    public Lenta kopijuoti() {
        Lenta lenta = new Lenta();
        for (int eilute = 1; eilute <= Eilutes; eilute++) {
            for (int stulpelis = 1; stulpelis <= Stulpeliai; stulpelis++) {
                Laukas langelis = this.zaidimoLenta.get(skaicius(eilute, stulpelis));
                lenta.priskirtiLangeli(langelis.gautiNumeri(), langelis.kopijuoti());
            }
        }

        return lenta;
    }

    public List<Integer> galimiEjimai() {

        List<Integer> galimiEjimai = new ArrayList<>();
        for (int eilute = 1; eilute <= Eilutes; eilute++) {
            for (int stulpelis = 1; stulpelis <= Stulpeliai; stulpelis++) {
                if (Lenta.this.yraLeistinas(eilute, stulpelis)) {
                    galimiEjimai.add(skaicius(eilute, stulpelis));
                }
            }
        }

        return galimiEjimai;
    }

    public boolean yraLeistinas(int eilute, int stulpelis) {
        return yraLeistinas((skaicius(eilute, stulpelis)));
    }

    public boolean yraLeistinas(int vieta) {

        if (vieta > Eilutes * Stulpeliai) {
            return false;
        } else if (zaidimoLenta.get(vieta).gautiSavininka() == Langeliai.Tuscias) {
            return true;
        } else {
            return false;
        }
    }


    public boolean laimeta(Langeliai zaidejas) {

        boolean laimeta = false;

        for (int eilute = 1; eilute <= Eilutes; eilute++) {
            int kiekis = 0;
            for (int stulpelis = 1; stulpelis <= Stulpeliai; stulpelis++) {
                if (zaidimoLenta.get(skaicius(eilute, stulpelis)).gautiSavininka() == zaidejas) {
                    kiekis++;
                } else {
                    break;
                }
            }
            if (kiekis == Stulpeliai) {
                laimeta = true;
            }
        }

        for (int stulpelis = 1; stulpelis <= Stulpeliai; stulpelis++) {
            int kiekis = 0;
            for (int eilute = 1; eilute <= Eilutes; eilute++) {
                if (zaidimoLenta.get(skaicius(eilute, stulpelis)).gautiSavininka() == zaidejas) {
                    kiekis++;
                } else {
                    break;
                }
            }
            if (kiekis == Eilutes) {
                laimeta = true;
            }
        }

        int istrizai = 0;
        if (zaidimoLenta.get(skaicius(1, 1)).gautiSavininka() == zaidejas) {
            istrizai++;
        }
        if (zaidimoLenta.get(skaicius(2, 2)).gautiSavininka() == zaidejas) {
            istrizai++;
        }
        if (zaidimoLenta.get(skaicius(3, 3)).gautiSavininka() == zaidejas) {
            istrizai++;
        }

        if (istrizai == Stulpeliai) {
            laimeta = true;
        }

        istrizai = 0;
        if (zaidimoLenta.get(skaicius(1, 3)).gautiSavininka() == zaidejas) {
            istrizai++;
        }
        if (zaidimoLenta.get(skaicius(2, 2)).gautiSavininka() == zaidejas) {
            istrizai++;
        }
        if (zaidimoLenta.get(skaicius(3, 1)).gautiSavininka() == zaidejas) {
            istrizai++;
        }

        if (istrizai == Stulpeliai) {
            laimeta = true;
        }

        return laimeta;
    }

    public boolean lygiosios() {
        if (galimiEjimai().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean zaidimoPabaiga() {

        if (laimeta(Langeliai.O)) {
            spausdinti();
            System.out.println("Zaidimas laimetas: " + Langeliai.O.gautiAtstovavima() + "!");
            return true;
        }

        if (laimeta(Langeliai.X)) {
            spausdinti();
            System.out.println("Zaidimas laimetas: " + Langeliai.X.gautiAtstovavima() + "!");
            return true;
        }

        if (lygiosios()) {
            spausdinti();
            System.out.println("Zaidimas baigesi lygiosiomis");
            return true;
        }


        return false;
    }

    public void spausdinti() {

        System.out.println("==========================");
        for (int eilute = 1; eilute <= Eilutes; eilute++) {
            for (int stulpelis = 1; stulpelis <= Stulpeliai; stulpelis++) {
                Laukas langelis = zaidimoLenta.get(skaicius(eilute, stulpelis));
                System.out.print(langelis.erdvesAtstovavimas());
            }
            System.out.println();
        }
        System.out.println("==========================");

    }

    public Laukas gautiLangeli(int skaicius) {
        return zaidimoLenta.get(skaicius);
    }

    private void priskirtiLangeli(int skaicius, Laukas langelis) {
        zaidimoLenta.put(skaicius, langelis);
    }

    private int skaicius(int eilute, int stulpelis) {
        return ((eilute-1) * Stulpeliai) + stulpelis;
    }

}
