package zaidimas;

import neuroninisTinklas.BotoVariklis;
import neuroninisTinklas.Mokymasis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZaidimasPriesKompiuteri {

    @Autowired
    private RandomEjimai randomVariklis;

    @Autowired
    private ZaidimasPriesSavePati zaidimasPrieskompiuteri;

    @Autowired
    private Mokymasis mokymasis;

    @Value("${zaidimoPriesSave.zaidimai}")
    private int priesKompiuteriZaidimai;

    @Value("${zaidimoPriesSave.raundai}")
    private int priesKompiuteriRoundai;


    public void Zaisti() {

        Spausdinimas bendraSeries = new Spausdinimas();
        for (int j = 0; j < priesKompiuteriRoundai; j++) {

            BotoVariklis botoVariklis = new BotoVariklis();
            mokymasis.mokyti(botoVariklis);

            int botoLaimejimai = 0;
            int priesininkoLaimejimai = 0;
            int lygiosios = 0;
            Spausdinimas laikoEilutes = new Spausdinimas();

            ZaidejoPriskirimas zaidejoPriskirimas = new ZaidejoPriskirimas();

            for (int i = 0; i < priesKompiuteriZaidimai; i++) {

                ZaidimoRezultatai zaidimoRezultatai = zaidimasPrieskompiuteri.zaisti(botoVariklis, randomVariklis,
                        zaidejoPriskirimas.gautiBota(), zaidejoPriskirimas.gautiPriesininka(), false);

                if (zaidimoRezultatai == ZaidimoRezultatai.Lygiosios) {
                    lygiosios++;
                } else if (zaidimoRezultatai == ZaidimoRezultatai.Botas_Laimejo) {
                    botoLaimejimai++;
                } else if (zaidimoRezultatai == ZaidimoRezultatai.Priesininkas_Laimejo) {
                    priesininkoLaimejimai++;
                }

                laikoEilutes.prideti(botoLaimejimai, priesininkoLaimejimai, lygiosios);
                zaidejoPriskirimas.priskirti();
            }

            System.out.println("Mokymosi rezultatai:");
            System.out.println("Boto laimejimai: " + botoLaimejimai);
            System.out.println("Priesininko laimejimai: " + priesininkoLaimejimai);
            System.out.println("Lygiosios        : " + lygiosios);

            laikoEilutes.spausdintiIFaila("Rezultatai\\boto-" + (j+1) + "-rez.csv");
            bendraSeries.prideti(botoLaimejimai, priesininkoLaimejimai, lygiosios);
        }
        bendraSeries.spausdintiIFaila("Rezultatai\\bendri-rez.csv");
    }
}
