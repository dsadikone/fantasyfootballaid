/**
 * Created by dsadi on 9/21/2016.
 */

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Stats {
    private ArrayList<WR> wrList;
    private ArrayList<RB> rbList;
    private ArrayList<QB> qbList;

    public Stats() {
        wrList = new ArrayList<WR>();
        rbList = new ArrayList<RB>();
        qbList = new ArrayList<QB>();
    }

    public void readStats(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        String name = "";
        String team = "";
        int gamesPlayed = 0;
        int receptions = 0;
        int targets = 0;
        int yards = 0;
        int tds = 0;
        String str = "";

        while (in.hasNextLine()) {
            str = in.nextLine();
            char c;
            for (int i = 0; i < 7; i++) {
                String value = "";
                if (i < 6) {
                    value = str.substring(0, str.indexOf(","));
                }
                else {
                    value = str;
                }
                switch (i) {
                    case 0:
                        name = value;
                        break;
                    case 1:
                        team = value;
                        break;
                    case 2:
                        gamesPlayed = Integer.parseInt(value);
                        break;
                    case 3:
                        receptions = Integer.parseInt(value);
                        break;
                    case 4:
                        targets = Integer.parseInt(value);
                        break;
                    case 5:
                        yards = Integer.parseInt(value);
                        break;
                    case 6:
                        tds = Integer.parseInt(value);
                }
                str = str.substring(str.indexOf(",") + 1);
            }
            WR wr = new WR(name, team, gamesPlayed, receptions, targets, yards, tds);
            wrList.add(wr);
        }
    }

    public void printStats() {
        for (int i = 0; i < wrList.size(); i++) {
            System.out.println(wrList.get(i).toString());
        }
    }
}
