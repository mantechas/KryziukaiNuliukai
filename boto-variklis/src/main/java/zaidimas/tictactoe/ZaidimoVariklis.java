package zaidimas.tictactoe;

import zaidimas.tictactoe.Lenta;
import zaidimas.tictactoe.Langeliai;

public interface ZaidimoVariklis {

    int eiti(Lenta lenta, Langeliai zaidejas, boolean ijungtasMokymasis);

    void perjungtiTarpZaidimu();

}
