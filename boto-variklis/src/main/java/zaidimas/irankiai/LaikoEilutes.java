package zaidimas.irankiai;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class LaikoEilutes {

    private List<Integer> botoLaikoEilutes = new ArrayList<>();
    private List<Integer> randomLaikoEilutes = new ArrayList<>();
    private List<Integer> lygiujuLaikoEilutes = new ArrayList<>();

    public void prideti(int botoLaimejimai, int randomLaimejimai, int lygiosios) {
        botoLaikoEilutes.add(botoLaimejimai);
        randomLaikoEilutes.add(randomLaimejimai);
        lygiujuLaikoEilutes.add(lygiosios);
    }

    public void spausdintiIFaila(String failas) {
        BufferedWriter writer = null;
        try {
            File laikoEiluciuFailas = new File(failas);
            writer = new BufferedWriter(new FileWriter(laikoEiluciuFailas));

            int i = 1;
            writer.write("Zaidimai:,");
            for (Integer n : botoLaikoEilutes) {
                writer.write("M" + i++ + ",");
            }
            writer.newLine();

            writer.write("Boto laimejimai:,");
            for (Integer n : botoLaikoEilutes) {
                writer.write(n + ",");
            }
            writer.newLine();

            writer.write("Random kompiuterio laimejimai:,");
            for (Integer n : randomLaikoEilutes) {
                writer.write(n + ",");
            }
            writer.newLine();

            writer.write("Lygiosios:,");
            for (Integer n : lygiujuLaikoEilutes) {
                writer.write(n + ",");
            }
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
