package zaidimas;

import org.springframework.stereotype.Component;

@Component
public class ZaidimasPriesSavePati {

    public ZaidimoRezultatai zaisti(ZaidimoVariklis botas, ZaidimoVariklis priesininkas, Langeliai Botas, Langeliai Priesininkas, boolean mokymasis) {

        botas.perjungtiTarpZaidimu(); //Perjungiamas tarp žaidimų botas
        priesininkas.perjungtiTarpZaidimu();//Perjungiamas tarp žaidimų botas

        Lenta lenta = new Lenta(); // Sukuriama nauja lenta
        ZaidimoRezultatai zaidimoRezultatas = null;
        int ejimoNumeris = 0; //Ejimo numeris
        while (zaidimoRezultatas == null) { //Vykdyti žaidimą

            ejimoNumeris++;
            if (ejimoNumeris > 1 || Botas == Langeliai.X) {
                int botoEjimas = botas.eiti(lenta.kopijuoti(), Botas, mokymasis);
                lenta.ejimas(botoEjimas, Botas);
                if (lenta.zaidimoPabaiga()) {
                    if (lenta.laimeta(Botas)) {
                        zaidimoRezultatas = ZaidimoRezultatai.Botas_Laimejo; //Priskiriama, jog laimėjo Botas
                    } else {
                        zaidimoRezultatas = ZaidimoRezultatai.Lygiosios; //Priskiriama, jog žaidimas baigėsi lygiosiomis
                    }
                }
            }

            if (zaidimoRezultatas == null) {
                int priesininkoEjimas = priesininkas.eiti(lenta.kopijuoti(), Priesininkas, mokymasis);
                lenta.ejimas(priesininkoEjimas, Priesininkas);
                if (lenta.zaidimoPabaiga()) {
                    if (lenta.laimeta(Priesininkas)) {
                        zaidimoRezultatas = ZaidimoRezultatai.Priesininkas_Laimejo; //Priskiriama, jog laimėjo boto priešininkas
                    } else {
                        zaidimoRezultatas = ZaidimoRezultatai.Lygiosios; //Priskiriama, jog laimėjo Botas
                    }
                }
            }
        }

        return zaidimoRezultatas; //Gražinamas žaidimo rezultatas
    }
}
