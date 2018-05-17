package neuroninisTinklas;

import zaidimas.tictactoe.ZaidimasPriesKompiuteri;
import zaidimas.irankiai.ZaidejoPriskirimas;
import zaidimas.irankiai.RandomEjimai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mokymasis {

    @Autowired
    private ZaidimasPriesKompiuteri savarankiskasZaidimas;

    @Value("${mokymosi.kartai}")
    private int mokymosiKartai;

    @Value("${mokymosi.stadija}")
    private int learningStage;

    public void mokyti(BotoVariklis botoVariklis) {

        RandomEjimai priesininkoVariklis = new RandomEjimai();
        ZaidejoPriskirimas zaidejoPriskirimas = new ZaidejoPriskirimas();

        for (int i = 0; i < mokymosiKartai; i++) {
            savarankiskasZaidimas.zaisti(botoVariklis, priesininkoVariklis,
                    zaidejoPriskirimas.gautiBota(), zaidejoPriskirimas.gautiPriesininka(), true);
            zaidejoPriskirimas.priskirti();
        }
    }
}
