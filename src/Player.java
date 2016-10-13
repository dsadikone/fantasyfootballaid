
public class Player {
    
    public String name;
    public String team;
    public int yards;
    public int tds;
    public int gamesPlayed;
    
    public Player(String name, String team, int yards, int tds, int gamesPlayed) {
        this.name = name;
        this.team = team;
        this.yards = yards;
        this.tds = tds;
        this.gamesPlayed = gamesPlayed;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setTeam(String team) {
        this.team = team;
    }

    private void setYards(int yards) {
        this.yards = yards;
    }

    private void tds(int tds) {
        this.tds = tds;
    }

    private void gamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getName(){
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getYards() {
        return yards;
    }

    public int getTds() {
        return tds;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }


    @Override
    public String toString(){
       return ""; 
    }
}
