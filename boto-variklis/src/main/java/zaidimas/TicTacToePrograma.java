package zaidimas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("zaidimas")
@ComponentScan("neuroninisTinklas")
public class TicTacToePrograma implements CommandLineRunner {

    @Autowired
    private ZaidimasPriesKompiuteri zaidimasPriesSavePati;

    @Autowired
    private ZmogausZaidimas zmogausZaidimas;

    @Value("${ijungtas.zaidimasPriesSave}")
    private boolean ijungtasZaidimasPriesSave;

    @Value("${ijungtas.zaidimasPriesZmogu}")
    private boolean ijungtasZaidimasPriesZmogu;


    public static void main(String[] args) {
		SpringApplication.run(TicTacToePrograma.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        if (ijungtasZaidimasPriesSave) {
            zaidimasPriesSavePati.Zaisti();
        }

        if (ijungtasZaidimasPriesZmogu) {
            zmogausZaidimas.Zaisti();
        }
    }
}
