/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantasyfootball;

/**
 *
 * @author CJ
 */

public class QB extends Player{
    
    public int completions;
    public int attempts;
    public int yardsPerAttempt;
    public int completionPercentage;
    public int yardsPerGame;
    public int tdPerGame;
    
    
    public QB(String name, String team, int yards, int tds, int gamesPlayed, int completions, int attempts) {
        super(name, team, yards, tds, gamesPlayed);
        this.completions = completions;
        this.attempts = attempts;
        yardsPerAttempt=yards/attempts;
        completionPercentage=completions/attempts;
        yardsPerGame=yards/gamesPlayed;
        tdPerGame=tds/gamesPlayed;
    }
}
