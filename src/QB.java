
public class QB extends Player{

    private int completions;
    private int attempts;
    private int yardsPerAttempt;
    private int completionPercentage;
    private int yardsPerGame;
    private int tdPerGame;
    
    
    public QB(String name, String team, int yards, int tds, int gamesPlayed, int completions, int attempts) {
        super(name, team, yards, tds, gamesPlayed);
        this.completions = completions;
        this.attempts = attempts;
        yardsPerAttempt = yards / attempts;
        completionPercentage = completions / attempts;
        yardsPerGame = yards / gamesPlayed;
        tdPerGame = tds / gamesPlayed;
    }

    public int getCompletions() {
        return completions;
    }

    private void setCompletions(int completions) {
        this.completions = completions;
    }

    public int getAttempts() {
        return attempts;
    }

    private void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getYardsPerAttempt() {
        return yardsPerAttempt;
    }

    private void setYardsPerAttempt(int yardsPerAttempt) {
        this.yardsPerAttempt = yardsPerAttempt;
    }

    public int getCompletionPercentage() {
        return completionPercentage;
    }

    private void setCompletionPercentage(int completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public int getYardsPerGame() {
        return yardsPerGame;
    }

    private void setYardsPerGame(int yardsPerGame) {
        this.yardsPerGame = yardsPerGame;
    }

    public int getTdPerGame() {
        return tdPerGame;
    }

    private void setTdPerGame(int tdPerGame) {
        this.tdPerGame = tdPerGame;
    }

    public String toString() {
        return name + ": " + team + ", " + yards + ", " + tds + ", " + gamesPlayed + ", " + completions + ", " + attempts + ", " +
                yardsPerAttempt + ", " + completionPercentage + ", " + yardsPerGame + ", " + tdPerGame;
    }
}
