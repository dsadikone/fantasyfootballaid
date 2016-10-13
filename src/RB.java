
public class RB extends Player{

    private int carries;
    private int twentyYardRuns;
    private int carriesPerGame;
    private int yardsPerCarry;
    private int yardsPerGame;
    private int breakoutRunPercentage;
    
    public RB(String name, String team, int yards, int tds, int car, int twenty, int gamesPlayed){
        super(name, team, yards, tds, gamesPlayed);
        twentyYardRuns = twenty;
        carries = car;
        carriesPerGame = carries / gamesPlayed;
        yardsPerGame = yards / gamesPlayed;
        yardsPerCarry = yards / carries;
        breakoutRunPercentage = twentyYardRuns / carries;
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

    public int getCarriesPerGame() {
        return carriesPerGame;
    }

    private void setCarriesPerGame(int carriesPerGame) {
        this.carriesPerGame = carriesPerGame;
    }

    private int getYardsPerCarry() {
        return yardsPerCarry;
    }

    private void setYardsPerCarry(int yardsPerCarry) {
        this.yardsPerCarry = yardsPerCarry;
    }

    public int getYardsPerGame() {
        return yardsPerGame;
    }

    private void setYardsPerGame(int yardsPerGame) {
        this.yardsPerGame = yardsPerGame;
    }

    public int getBreakoutRunPercentage() {
        return breakoutRunPercentage;
    }

    private void setBreakoutRunPercentage(int breakoutRunPercentage) {
        this.breakoutRunPercentage = breakoutRunPercentage;
    }

    public String toString() {
        return name + ": " + team + ", " + yards + ", " + tds + ", " + gamesPlayed + ", " + carries + ", " + twentyYardRuns + ", " + carriesPerGame + ", " +
                yardsPerGame + ", " + yardsPerCarry + ", " + breakoutRunPercentage;
    }
}
