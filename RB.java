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

    public String toString() {
        return name + ": " + team + ", " + yards + ", " + tds + ", " + gamesPlayed + ", " + carries + ", " + twentyYardRuns + ", " + carriesPerGame + ", " +
                yardsPerGame + ", " + yardsPerCarry + ", " + breakoutRunPercentage;
    }
}
