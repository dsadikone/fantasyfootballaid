public class RB extends Player{
    private int carries;
    private int receptions;
    private int carriesPerGame;
    private int yardsPerCarry;
    private int yardsPerGame;
    private int tdPerCarry;
    
    public RB(String name, String team, int yards, int tds, int car, int r, int gamesPlayed){
        super(name, team, yards, tds, gamesPlayed);
        receptions = r;
        carries = car;
        carriesPerGame = carries / gamesPlayed;
        yardsPerGame = yards / gamesPlayed;
        yardsPerCarry = yards / carries;
        tdPerCarry = tds / carries;
    }
}