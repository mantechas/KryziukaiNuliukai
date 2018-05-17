package zaidimas.irankiai;

import zaidimas.tictactoe.Lenta;
import zaidimas.tictactoe.Langeliai;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import zaidimas.tictactoe.ZaidimoVariklis;

@Component
public class RandomEjimai implements ZaidimoVariklis {

    @Override
    public int eiti(Lenta lenta, Langeliai zaidejas, boolean mokymasis) {

        List<Integer> galimiEjimai = lenta.galimiEjimai();
        int randomNumeris = ThreadLocalRandom.current().nextInt(0, galimiEjimai.size());

        return galimiEjimai.get(randomNumeris);
    }

    @Override
    public void perjungtiTarpZaidimu() {
    }
}
