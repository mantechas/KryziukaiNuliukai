package zaidimas.tictactoe;

public enum Langeliai {

    Tuscias("-"),

    O("O"),

    X("X");

    private String atstovavimas;

    Langeliai(String atstovavimas) {
        this.atstovavimas = atstovavimas;
    }

    public String gautiAtstovavima() {
        return atstovavimas;
    }
}
