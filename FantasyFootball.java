/**
 *
 * @author CJ
 */

import java.io.*;

public class FantasyFootball {
    public static void main(String[] args) throws FileNotFoundException {
        Stats stats = new Stats();
        stats.readStats("WRs.csv");
        stats.printStats();
    }
}
