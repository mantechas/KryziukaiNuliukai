package zaidimas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Spausdinimas {

    private List<Integer> botoLaikoEilutes = new ArrayList<>();
    private List<Integer> randomLaikoEilutes = new ArrayList<>();
    private List<Integer> lygiujuLaikoEilutes = new ArrayList<>();

    public void prideti(int botoLaimejimai, int randomLaimejimai, int lygiosios) {
        botoLaikoEilutes.add(botoLaimejimai); //Boto laimejimų kiekis
        randomLaikoEilutes.add(randomLaimejimai); //Random kompiuterio laimejimų kiekis
        lygiujuLaikoEilutes.add(lygiosios); //Lygiųjų kiekis
    }

    public void spausdintiIFaila(String failas) {
        BufferedWriter spausdintojas = null;
        try {
            File laikoEiluciuFailas = new File(failas);
            spausdintojas = new BufferedWriter(new FileWriter(laikoEiluciuFailas));

            spausdintojas.write("Zaidimai:,");
            for (Integer n : botoLaikoEilutes) {
                spausdintojas.write("M" + n++ + ",");
            }
            spausdintojas.newLine();

            spausdintojas.write("Boto laimejimai:,");
            for (Integer n : botoLaikoEilutes) {
                spausdintojas.write(n + ",");
            }
            spausdintojas.newLine();

            spausdintojas.write("Random kompiuterio laimejimai:,");
            for (Integer n : randomLaikoEilutes) {
                spausdintojas.write(n + ",");
            }
            spausdintojas.newLine();

            spausdintojas.write("Lygiosios:,");
            for (Integer n : lygiujuLaikoEilutes) {
                spausdintojas.write(n + ",");
            }
            spausdintojas.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
