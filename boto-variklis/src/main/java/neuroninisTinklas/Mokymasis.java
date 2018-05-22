package neuroninisTinklas;

import zaidimas.ZaidimasPriesSavePati;
import zaidimas.ZaidejoPriskirimas;
import zaidimas.RandomEjimai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mokymasis {

    @Autowired
    private ZaidimasPriesSavePati savarankiskasZaidimas;

    @Value("${mokymosi.kartai}")
    private int mokymosiKartai;

    //Pradedamas mokinimasis
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
