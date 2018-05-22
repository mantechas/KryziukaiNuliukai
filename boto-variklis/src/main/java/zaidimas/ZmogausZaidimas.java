package zaidimas;

import neuroninisTinklas.BotoVariklis;
import neuroninisTinklas.Mokymasis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ZmogausZaidimas {

    @Autowired
    private Mokymasis mokymasis;

    //Pradėti žmogaus žaidimą prieš apsimokytą botą
    public void Zaisti() {

        BotoVariklis botoVariklis = new BotoVariklis();
        mokymasis.mokyti(botoVariklis);

        Lenta lenta = new Lenta();

        Scanner skaneris = new Scanner(System.in);
        int Ivestis = -1;
        while (Ivestis != 0) {

            lenta.spausdinti();
            System.out.print("Tavo Ejimas: ");

            Ivestis = Integer.parseInt(skaneris.nextLine());
            if (lenta.yraLeistinas(Ivestis)) {
                lenta.ejimas(Ivestis, Langeliai.O);
                boolean Laimeta = PatikrintiLaimejima(lenta, Langeliai.O, "Tu laimėjai!");
                boolean Lygiosios = PatikrintiLygiasias(lenta);

                if (!Laimeta && !Lygiosios) {
                    int botoEjimas = botoVariklis.eiti(lenta.kopijuoti(), Langeliai.X, false);
                    lenta.ejimas(botoEjimas, Langeliai.X);
                    PatikrintiLaimejima(lenta, Langeliai.X, "Botas laimejo!");

                    System.out.println("");
                } else {
                    botoVariklis.perjungtiTarpZaidimu();
                }
            } else {
                System.out.println("Neleistinas ejimas!");
            }
        }
        skaneris.close();
    }

    //Patikrinamas laimėjimas
    private boolean PatikrintiLaimejima(Lenta lenta, Langeliai savininkas, String zinute) {
        if (lenta.laimeta(savininkas)) {
            lenta.spausdinti();
            System.out.println(zinute);
            lenta.sudaryti();

            return true;
        }

        return  false;
    }

    //Patikrinamos lygiosios
    private boolean PatikrintiLygiasias(Lenta lenta) {
        if (lenta.galimiEjimai().isEmpty()) {
            lenta.spausdinti();
            System.out.println("Lygiosios!");
            lenta.sudaryti();

            return true;
        }

        return false;
    }
}
