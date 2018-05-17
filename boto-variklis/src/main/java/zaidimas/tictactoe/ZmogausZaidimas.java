package zaidimas.tictactoe;

import zaidimas.tictactoe.Lenta;
import zaidimas.tictactoe.Langeliai;
import neuroninisTinklas.BotoVariklis;
import neuroninisTinklas.Mokymasis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ZmogausZaidimas {

    @Autowired
    private Mokymasis mokymasis;

    @Value("${mokymosi.stadija}")
    private int mokymosiStadija;

    public void Zaisti() {

        BotoVariklis botoVariklis = new BotoVariklis(mokymosiStadija);
        mokymasis.mokyti(botoVariklis);

        Lenta lenta = new Lenta();

        Scanner skaneris = new Scanner(System.in);
        int ivestiesTokenas = -1;
        while (ivestiesTokenas != 0) {

            lenta.spausdinti();
            System.out.print("Tavo Ejimas: ");

            ivestiesTokenas = Integer.parseInt(skaneris.nextLine());
            if (lenta.yraLeistinas(ivestiesTokenas)) {
                lenta.ejimas(ivestiesTokenas, Langeliai.O);
                boolean Laimeta = PatikrintiLaimejima(lenta, Langeliai.O, "Tu laimejai!");
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

    private boolean PatikrintiLaimejima(Lenta lenta, Langeliai savininkas, String zinute) {
        if (lenta.laimeta(savininkas)) {
            lenta.spausdinti();
            System.out.println(zinute);
            lenta.sudaryti();

            return true;
        }

        return  false;
    }

    private boolean PatikrintiLygiasias(Lenta lenta) {
        if (lenta.galimiEjimai().isEmpty()) {
            lenta.spausdinti();
            System.out.println("Draw!");
            lenta.sudaryti();

            return true;
        }

        return false;
    }
}
