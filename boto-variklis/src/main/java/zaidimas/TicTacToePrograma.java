package zaidimas;

import zaidimas.tictactoe.ZmogausZaidimas;
import zaidimas.tictactoe.ZaidimasPriesSavePati;
import neuroninisTinklas.Mokymasis;
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
    private ZaidimasPriesSavePati zaidimasPriesSavePati;

    @Autowired
    private ZmogausZaidimas zmogausZaidimas;

    @Autowired
    private Mokymasis mokymasis;

    @Value("${mokymosi.stadija}")
    private int mokymosiStadija;

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
