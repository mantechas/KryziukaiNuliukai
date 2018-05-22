package zaidimas;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomEjimai implements ZaidimoVariklis {

    //Kompiuterio ejimai naudojant random algoritmą
    @Override
    public int eiti(Lenta lenta, Langeliai zaidejas, boolean mokymasis) {

        List<Integer> galimiEjimai = lenta.galimiEjimai();
        int randomNumeris = ThreadLocalRandom.current().nextInt(0, galimiEjimai.size()); //Imamas random skaičius iš galimų

        return galimiEjimai.get(randomNumeris);
    }

    @Override
    public void perjungtiTarpZaidimu() {
    }
}
