package zaidimas.tictactoe;

import zaidimas.tictactoe.ZaidimasPriesKompiuteri;
import zaidimas.tictactoe.ZaidimoRezultatai;
import zaidimas.irankiai.ZaidejoPriskirimas;
import zaidimas.irankiai.RandomEjimai;
import zaidimas.irankiai.LaikoEilutes;
import neuroninisTinklas.BotoVariklis;
import neuroninisTinklas.Mokymasis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZaidimasPriesSavePati {

    @Autowired
    private RandomEjimai randomVariklis;

    @Autowired
    private ZaidimasPriesKompiuteri zaidimasPrieskompiuteri;

    @Autowired
    private Mokymasis mokymasis;

    @Value("${zaidimoPriesSave.zaidimai}")
    private int priesSavePatiZaidimai;

    @Value("${zaidimoPriesSave.raundai}")
    private int priesSavePatiRoundai;

    @Value("${mokymosi.stadija}")
    private int mokymosiStadija;

    public void Zaisti() {

        LaikoEilutes bendraSeries = new LaikoEilutes();
        for (int j = 0; j < priesSavePatiRoundai; j++) {

            BotoVariklis botoVariklis = new BotoVariklis(mokymosiStadija);
            mokymasis.mokyti(botoVariklis);

            int botoLaimejimai = 0;
            int priesininkoLaimejimai = 0;
            int lygiosios = 0;
            LaikoEilutes laikoEilutes = new LaikoEilutes();

            ZaidejoPriskirimas zaidejoPriskirimas = new ZaidejoPriskirimas();

            for (int i = 0; i < priesSavePatiZaidimai; i++) {

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
