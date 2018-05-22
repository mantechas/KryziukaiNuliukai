package zaidimas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lenta {

    private Map<Integer, Laukas> zaidimoLenta = new HashMap<>();

    public Lenta() {
        sudaryti();
    }
    
    //Sudaroma Žaidimo lenta
    public void sudaryti() {
        for (int eilute = 1; eilute <= 3; eilute++) {
            for (int stulpelis = 1; stulpelis <= 3; stulpelis++) {
                Laukas laukas = new Laukas(skaicius(eilute, stulpelis));
                zaidimoLenta.put(skaicius(eilute, stulpelis), laukas);
            }
        }
    }

    //Žaidimo ėjimas
    public void ejimas(int skaicius, Langeliai savininkas) {
        if (zaidimoLenta.get(skaicius).gautiSavininka() != Langeliai.Tuscias) {
            throw new RuntimeException("Negalimas ejimas, langelis jau užimtas: " + skaicius);
        }
        Laukas langelis = zaidimoLenta.get(skaicius);
        langelis.priskirtiSavininka(savininkas);
    }
    
    //Galimu ejimu sarasas
    public List<Integer> galimiEjimai() {
        List<Integer> galimiEjimai = new ArrayList<>();
        for (int eilute = 1; eilute <= 3; eilute++) {
            for (int stulpelis = 1; stulpelis <= 3; stulpelis++) {
                if (Lenta.this.yraLeistinas((skaicius(eilute, stulpelis)))) {
                    galimiEjimai.add(skaicius(eilute, stulpelis));
                }
            }
        }
        return galimiEjimai;
    }
    
    //Kopijuojama žaidimo lenta
    public Lenta kopijuoti() {
        Lenta lenta = new Lenta();
        for (int eilute = 1; eilute <= 3; eilute++) {
            for (int stulpelis = 1; stulpelis <= 3; stulpelis++) {
                Laukas langelis = this.zaidimoLenta.get(skaicius(eilute, stulpelis));
                lenta.priskirtiLangeli(langelis.gautiNumeri(), langelis.kopijuoti());
            }
        }
        return lenta;
    }


    //Tikrinama ar langelis yra leistinas ejimui
    public boolean yraLeistinas(int vieta) {

        if (vieta > 3 * 3) { //Jei skaičius viršija ribas
            return false;
        } else if (zaidimoLenta.get(vieta).gautiSavininka() == Langeliai.Tuscias) { // Jei langelis tuščias
            return true;
        } else {
            return false; 
        }
    }

    //Tikrinamas žaidimo laimėjimas
    public boolean laimeta(Langeliai zaidejas) {

        boolean laimeta = false; //Ar laimėta

        //Tikrinamas laimėjimas eilutėmis
        for (int eilute = 1; eilute <= 3; eilute++) {
            int kiekis = 0;
            for (int stulpelis = 1; stulpelis <= 3; stulpelis++) {
                if (zaidimoLenta.get(skaicius(eilute, stulpelis)).gautiSavininka() == zaidejas) {
                    kiekis++;
                } else {
                    break;
                }
            }
            if (kiekis == 3) {
                laimeta = true;
            }
        }
        
        
        //Tikrinamas laimėjimas stulpeliais
        for (int stulpelis = 1; stulpelis <= 3; stulpelis++) {
            int kiekis = 0;
            for (int eilute = 1; eilute <= 3; eilute++) {
                if (zaidimoLenta.get(skaicius(eilute, stulpelis)).gautiSavininka() == zaidejas) {
                    kiekis++;
                } else {
                    break;
                }
            }
            if (kiekis == 3) {
                laimeta = true;
            }
        }
        //Tikrinamos istrižainės laimėjimai
        if (zaidimoLenta.get(skaicius(1, 1)).gautiSavininka() == zaidejas && 
           zaidimoLenta.get(skaicius(2, 2)).gautiSavininka() == zaidejas && 
           zaidimoLenta.get(skaicius(3, 3)).gautiSavininka() == zaidejas){
            laimeta = true;
        }
        if (zaidimoLenta.get(skaicius(1, 3)).gautiSavininka() == zaidejas && 
           zaidimoLenta.get(skaicius(2, 2)).gautiSavininka() == zaidejas && 
           zaidimoLenta.get(skaicius(3, 1)).gautiSavininka() == zaidejas){
            laimeta = true;
        }

        return laimeta;
    }
    
    //Tikrinama ar žaidimas baigėsi lygiosiomis
    public boolean lygiosios() {
        if (galimiEjimai().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Nustatoma kas laimėjo žaidimą
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
    
    //Priskiriamas langelis
    private void priskirtiLangeli(int skaicius, Laukas langelis) {
        zaidimoLenta.put(skaicius, langelis);
    }

    //Gaunamas langelio skaičius
    private int skaicius(int eilute, int stulpelis) {
        return ((eilute-1) * 3) + stulpelis;
    }
        //Gaunamas žaidimo langelis
    public Laukas gautiLangeli(int skaicius) {
        return zaidimoLenta.get(skaicius);
    }
    
    //Lentelės spausdinimas
    public void spausdinti() {

        for (int eilute = 1; eilute <= 3; eilute++) {
            for (int stulpelis = 1; stulpelis <= 3; stulpelis++) {
                Laukas langelis = zaidimoLenta.get(skaicius(eilute, stulpelis));
                System.out.print(langelis.erdvesAtstovavimas());
            }
            System.out.println();
        }

    }
    



}
