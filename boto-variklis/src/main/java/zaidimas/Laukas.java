package zaidimas;

public class Laukas {

    private Langeliai savininkas; //Langelio atstovavimas
    final private int numeris; //Langelio numeris

    //Lauko konstruktorius
    public Laukas(int numeris) {
        this.numeris = numeris;
        savininkas = Langeliai.Tuscias; //Priskiriama default tuščia langelio reikšmė
    }
    
    //Lauko konstruktorius
    public Laukas(int numeris, Langeliai savininkas) {
        this.numeris = numeris;
        this.savininkas = savininkas;   //Priskiriamas langeliui atitinkamas savininkas
    }


    //Gaunamas langelio savininkas
    public Langeliai gautiSavininka() {
        return savininkas;
    }

    //Priskiriamas langelio savininkas
    public void priskirtiSavininka(Langeliai savininkas) {
        this.savininkas = savininkas;
    }

    //Gauti langelio numeri
    public int gautiNumeri() {
        return numeris;
    }

    // Langelio vaizdavimo formavimas
    public String erdvesAtstovavimas() {
        return " [{" + numeris + "} " + savininkas.gautiAtstovavima() + " ]";
    }
    
    //Kopijuojamas lauko langelis
    public Laukas kopijuoti() {
        Laukas langelis = new Laukas(numeris, savininkas);
        return langelis;
    }
}
