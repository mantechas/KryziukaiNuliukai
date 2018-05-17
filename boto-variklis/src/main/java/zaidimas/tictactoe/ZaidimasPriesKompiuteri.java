package zaidimas.tictactoe;

import zaidimas.tictactoe.Lenta;
import zaidimas.tictactoe.Langeliai;
import org.springframework.stereotype.Component;

@Component
public class ZaidimasPriesKompiuteri {

    public ZaidimoRezultatai zaisti(ZaidimoVariklis botas, ZaidimoVariklis priesininkas, Langeliai Botas, Langeliai Priesininkas, boolean mokymasis) {

        botas.perjungtiTarpZaidimu();
        priesininkas.perjungtiTarpZaidimu();

        Lenta lenta = new Lenta();
        ZaidimoRezultatai zaidimoRezultatas = null;
        int ejimoNumeris = 0;


        while (zaidimoRezultatas == null) {

            ejimoNumeris++;
            if (ejimoNumeris > 1 || Botas == Langeliai.X) {
                int botoEjimas = botas.eiti(lenta.kopijuoti(), Botas, mokymasis);
                lenta.ejimas(botoEjimas, Botas);
                if (lenta.zaidimoPabaiga()) {
                    if (lenta.laimeta(Botas)) {
                        zaidimoRezultatas = ZaidimoRezultatai.Botas_Laimejo;
                    } else {
                        zaidimoRezultatas = ZaidimoRezultatai.Lygiosios;
                    }
                }
            }

            if (zaidimoRezultatas == null) {
                int priesininkoEjimas = priesininkas.eiti(lenta.kopijuoti(), Priesininkas, mokymasis);
                lenta.ejimas(priesininkoEjimas, Priesininkas);
                if (lenta.zaidimoPabaiga()) {
                    if (lenta.laimeta(Priesininkas)) {
                        zaidimoRezultatas = ZaidimoRezultatai.Priesininkas_Laimejo;
                    } else {
                        zaidimoRezultatas = ZaidimoRezultatai.Lygiosios;
                    }
                }
            }
        }

        return zaidimoRezultatas;
    }
}
