import javafx.collections.ObservableList;

public class WR extends Player{
    private int receptions;
    private int targets;
    private int receptionsPerGame;
    private int yardsPerGame;
    private int yardsPerReception;
    private int yardsPerTarget;
    private ObservableList<WR> wrList;
    
    public WR(String name, String team, int gamesPlayed, int r, int tar, int yards, int tds){
        super(name, team, yards, tds, gamesPlayed);
        receptions = r;
        targets = tar;
        receptionsPerGame = receptions / gamesPlayed;
        yardsPerGame = yards / gamesPlayed;
        yardsPerReception = yards / receptions;
        yardsPerTarget = yards / targets;
    }

    public String toString() {
        return name + ": " + team + ", " + yards + ", " + tds + ", " + gamesPlayed + ", " + receptions + ", " + targets + ", " + receptionsPerGame + ", " +
                yardsPerGame + ", " + yardsPerReception + ", " + yardsPerTarget;
    }


}
