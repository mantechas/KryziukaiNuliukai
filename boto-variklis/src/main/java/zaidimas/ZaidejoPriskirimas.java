package zaidimas;

public class ZaidejoPriskirimas {

    private Langeliai botas = Langeliai.X; //Priskiriami botui X langeliai

    private Langeliai priesininkas = Langeliai.O; //Priskiriami boto priešininkui O langeliai

    public Langeliai gautiBota() { //Gaunamas botas
        return botas;
    }

    public Langeliai gautiPriesininka() { //Gaunamas priesininkas
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
