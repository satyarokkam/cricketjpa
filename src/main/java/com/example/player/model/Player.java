package com.example.player.model;
import javax.persistence.*;


@Entity
@Table(name="team")
public class Player{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playerid")
    private int playerId;

    @Column(name="playername")
    private  String playerName;

    @Column(name="jerseynumber")
    private	int jerseyNumber;

    @Column(name="role")
	private String role;

    public Player(){

    }

    public Player(int playerId,String playerName,int jerseyNumber,String role){
        this.playerId=playerId;
        this.playerName=playerName;
        this.jerseyNumber=jerseyNumber;
        this.role=role;
    }
    
    public void setplayerId(int playerid){
        this.playerId=playerId;
    }
    
    public int getplayerId(){
        return playerId;
    }
    public void setplayerName(String playerName){
        this.playerName=playerName;
    }
    public String getplayerName(){
        return playerName;
    }

    public void setjerseyNumber(int jerseyNumber){
        this.jerseyNumber=jerseyNumber;
    }
    public int getjerseyNumber(){
        return jerseyNumber;
    }

    public void setrole(String role){
        this.role=role;
    }
    public String getrole(){
        return role;
    }
}