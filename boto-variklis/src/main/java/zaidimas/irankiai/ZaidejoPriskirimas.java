package zaidimas.irankiai;

import zaidimas.tictactoe.Langeliai;

public class ZaidejoPriskirimas {

    private Langeliai botas = Langeliai.X;

    private Langeliai priesininkas = Langeliai.O;

    public Langeliai gautiBota() {
        return botas;
    }

    public Langeliai gautiPriesininka() {
        return priesininkas;
    }

    public void priskirti() {
        if (botas == Langeliai.X) {
            botas = Langeliai.O;
            priesininkas = Langeliai.X;
        } else {
            botas = Langeliai.X;
            priesininkas = Langeliai.O;
        }
    }
}
