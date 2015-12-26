package com.ignatieff.beetle;

public class Game {
	
	private Player[] players;
	private Player winner;
	private boolean active;
	private int rounds;
	
	public Game(int numPlayers){
		rounds = 0;
		active = true;
		players = new Player[numPlayers];
		
		for(int i=0; i<numPlayers; i++){
			players[i] = new Player();
		}
	}
	
	public void play(){
		while(active)
			iterate();
	}
	
	public double average(){
		int max = 0;
		for(Player p : players)
			max+=p.getScore();
		return (double)max / players.length;
	}
	
	public int getRounds(){
		return rounds;
	}
	
	public int[] getValues(){
		int[] ints = new int[players.length];
		for(int i=0; i<players.length; i++)
			ints[i] = players[i].getScore();
		return ints;
	}
	
	public void print(){
		if(active)return;
		System.out.println("And the winner is "+winner.getName()+"!");
		
		for(Player p : players)
			System.out.println("\t"+(p.hasWon() ? "~~~~:-" : "")+"\t"+p.getInfo());
	}
	
	public void iterate(){
		//Iterate through all the players
		for(Player p : players){
			p.roll();
			
			//Stop rolling if any player has won
			if(p.hasWon()){
				winner = p;
				active = false;
				break;
			}
		}
		
		rounds++;
	}
}
