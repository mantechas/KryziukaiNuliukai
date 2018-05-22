package zaidimas;

//Langelių tipų enumeratoriai
public enum Langeliai {

    Tuscias("-"), //Neužpildytas langelis

    O("O"), //Užpildytas O žaidėjo langelis

    X("X"); //Užpildytas X žaidėjo langelis

    private String atstovavimas; //Langelio atstovavimas

    //Konstruktorius
    Langeliai(String atstovavimas) {
        this.atstovavimas = atstovavimas;
    }

    //Gauti langelio atstovavimą
    public String gautiAtstovavima() {
        return atstovavimas;
    }
}
