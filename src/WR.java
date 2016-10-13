
public class WR extends Player{

    private int receptions;
    private int targets;
    private int receptionsPerGame;
    private int yardsPerGame;
    private int yardsPerReception;
    private int yardsPerTarget;

    public WR(String name, String team, int gamesPlayed, int r, int tar, int yards, int tds){
        super(name, team, yards, tds, gamesPlayed);
        receptions = r;
        targets = tar;
        receptionsPerGame = receptions / gamesPlayed;
        yardsPerGame = yards / gamesPlayed;
        yardsPerReception = yards / receptions;
        yardsPerTarget = yards / targets;
    }

    public int getReceptions() {
        return receptions;
    }

    private void setReceptions(int receptions) {
        this.receptions = receptions;
    }

    public int getTargets() {
        return targets;
    }

    private void setTargets(int targets) {
        this.targets = targets;
    }

    public int getReceptionsPerGame() {
        return receptionsPerGame;
    }

    private void setReceptionsPerGame(int receptionsPerGame) {
        this.receptionsPerGame = receptionsPerGame;
    }

    public int getYardsPerGame() {
        return yardsPerGame;
    }

    private void setYardsPerGame(int yardsPerGame) {
        this.yardsPerGame = yardsPerGame;
    }

    public int getYardsPerReception() {
        return yardsPerReception;
    }

    private void setYardsPerReception(int yardsPerReception) {
        this.yardsPerReception = yardsPerReception;
    }

    public int getYardsPerTarget() {
        return yardsPerTarget;
    }

    private void setYardsPerTarget(int yardsPerTarget) {
        this.yardsPerTarget = yardsPerTarget;
    }

    public String toString() {
        return name + ": " + team + ", " + yards + ", " + tds + ", " + gamesPlayed + ", " + receptions + ", " + targets + ", " + receptionsPerGame + ", " +
                yardsPerGame + ", " + yardsPerReception + ", " + yardsPerTarget;
    }


}
