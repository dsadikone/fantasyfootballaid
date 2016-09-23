/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edi
/**
 *
 * @author CJ
 */
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
    
    @Override
    public String toString(){
       return ""; 
    }
}
