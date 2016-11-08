
public class QB extends Player{

    private int completions;
    private int attempts;
    private double yardsPerAttempt;
    private double completionPercentage;
    private double yardsPerGame;
    private double tdPerGame;
    
    
    public QB(String name, String team, int yards, int tds, int gamesPlayed, int completions, int attempts) {
        super(name, team, yards, tds, gamesPlayed);
        this.completions = completions;
        this.attempts = attempts;
        yardsPerAttempt = yards / attempts;
        completionPercentage = (double) completions / attempts;
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

    public double getYardsPerAttempt() {
        return yardsPerAttempt;
    }

    private void setYardsPerAttempt(double yardsPerAttempt) {
        this.yardsPerAttempt = yardsPerAttempt;
    }

    public double getCompletionPercentage() {
        return completionPercentage;
    }

    private void setCompletionPercentage(double completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public double getYardsPerGame() {
        return yardsPerGame;
    }

    private void setYardsPerGame(double yardsPerGame) {
        this.yardsPerGame = yardsPerGame;
    }

    public double getTdPerGame() {
        return tdPerGame;
    }

    private void setTdPerGame(double tdPerGame) {
        this.tdPerGame = tdPerGame;
    }

    public String toString() {
        return name + ": " + team + ", " + yards + ", " + tds + ", " + gamesPlayed + ", " + completions + ", " + attempts + ", " +
                yardsPerAttempt + ", " + completionPercentage + ", " + yardsPerGame + ", " + tdPerGame;
    }
}
