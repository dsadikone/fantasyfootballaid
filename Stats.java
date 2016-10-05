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
        int targets = 0;
        int yards = 0;
        int tds = 0;
        String str = "";
        switch (fileName) {
            case "WRs.csv":
                int receptions = 0;
                while (in.hasNextLine()) {
                    str = in.nextLine();
                    for (int i = 0; i < 7; i++) {
                        String value = "";
                        if (i < 6) {
                            value = str.substring(0, str.indexOf(","));
                        } else {
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
                break;
            case "QBs.csv":
                int attempts = 0;
                int completions = 0;
                while (in.hasNextLine()) {
                    str = in.nextLine();
                    for (int i = 0; i < 7; i++) {
                        String value = "";
                        if (i < 6) {
                            value = str.substring(0, str.indexOf(","));
                        } else {
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
                                completions = Integer.parseInt(value);
                                break;
                            case 4:
                                attempts = Integer.parseInt(value);
                                break;
                            case 5:
                                yards = Integer.parseInt(value);
                                break;
                            case 6:
                                tds = Integer.parseInt(value);
                        }
                        str = str.substring(str.indexOf(",") + 1);
                    }
                    QB qb = new QB(name, team, yards, tds, gamesPlayed, completions, attempts);
                    qbList.add(qb);
                }
                break;
            case "RBs.csv":
                int carries = 0;
                int twentyYardRuns = 0;
                while (in.hasNextLine()) {
                    str = in.nextLine();
                    for (int i = 0; i < 7; i++) {
                        String value = "";
                        if (i < 6) {
                            value = str.substring(0, str.indexOf(","));
                        } else {
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
                                carries = Integer.parseInt(value);
                                break;
                            case 4:
                                yards = Integer.parseInt(value);
                                break;
                            case 5:
                                twentyYardRuns = Integer.parseInt(value);
                                break;
                            case 6:
                                tds = Integer.parseInt(value);
                        }
                        str = str.substring(str.indexOf(",") + 1);
                    }
                    RB rb = new RB(name, team, yards, tds, carries, twentyYardRuns, gamesPlayed);
                    rbList.add(rb);
                }
                break;
            default:
                System.out.println("wut...");
                break;
        }
    }

    public void printStats() {
        for (int i = 0; i < wrList.size(); i++) {
            System.out.println(wrList.get(i).toString());
        }
        for (int i = 0; i < qbList.size(); i++) {
            System.out.println(qbList.get(i).toString());
        }
        for (int i = 0; i < rbList.size(); i++) {
            System.out.println(rbList.get(i).toString());
        }
    }
}
