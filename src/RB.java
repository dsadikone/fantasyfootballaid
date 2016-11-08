
public class RB extends Player{

    private int carries;
    private int twentyYardRuns;
    private double carriesPerGame;
    private double yardsPerCarry;
    private double yardsPerGame;
    private double breakoutRunPercentage;
    
    public RB(String name, String team, int yards, int tds, int car, int twenty, int gamesPlayed){
        super(name, team, yards, tds, gamesPlayed);
        twentyYardRuns = twenty;
        carries = car;
        carriesPerGame = (double) carries / gamesPlayed;
        yardsPerGame = (double) yards / gamesPlayed;
        yardsPerCarry = (double) yards / carries;
        breakoutRunPercentage = (double) twentyYardRuns / carries;
    }

    public int getCarries() {
        return carries;
    }

    private void setCarries(int carries) {
        this.carries = carries;
    }

    public int getTwentyYardRuns() {
        return twentyYardRuns;
    }

    private void setTwentyYardRuns(int twentyYardRuns) {
        this.twentyYardRuns = twentyYardRuns;
    }

    public double getCarriesPerGame() {
        return carriesPerGame;
    }

    private void setCarriesPerGame(double carriesPerGame) {
        this.carriesPerGame = carriesPerGame;
    }

    private double getYardsPerCarry() {
        return yardsPerCarry;
    }

    private void setYardsPerCarry(double yardsPerCarry) {
        this.yardsPerCarry = yardsPerCarry;
    }

    public double getYardsPerGame() {
        return yardsPerGame;
    }

    private void setYardsPerGame(double yardsPerGame) {
        this.yardsPerGame = yardsPerGame;
    }

    public double getBreakoutRunPercentage() {
        return breakoutRunPercentage;
    }

    private void setBreakoutRunPercentage(double breakoutRunPercentage) {
        this.breakoutRunPercentage = breakoutRunPercentage;
    }

    public String toString() {
        return name + ": " + team + ", " + yards + ", " + tds + ", " + gamesPlayed + ", " + carries + ", " + twentyYardRuns + ", " + carriesPerGame + ", " +
                yardsPerGame + ", " + yardsPerCarry + ", " + breakoutRunPercentage;
    }
}
