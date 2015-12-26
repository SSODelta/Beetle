package com.ignatieff.beetle;

public class Player {
	
	private static String[] NAME_LIST = new String[]{"Nikolaj","Jonatan","Michael","Kirsten","Kita","Shirley","James","Børge","Finley","Carl","Sagan","Jessica","Shaun","YOGI","Muhammed","Ahmed","Mehmet","Wang","Nguyen","Piktræet"};
	private static int NAME_LIST_ITERATOR = 0;
	
	private Beetle beetle;
	private String name;
	
	public Player(String name){
		beetle = new Beetle();
		this.name = name;
		NAME_LIST_ITERATOR %= NAME_LIST.length;
	}
	
	public Player(){
		this(NAME_LIST[NAME_LIST_ITERATOR++]);
	}
	
	public String getName(){
		return name;
	}
	
	public String getInfo(){
		return name + ": " + getScore();
	}
	
	public void roll(){
		int r = (int)Math.floor(Math.random()*6)+1;
		
		switch(r){
			case 1:
				beetle.addTail();
				break;
			case 2:
				beetle.addEye();
				break;
			case 3:
				beetle.addEar();
				break;
			case 4:
				beetle.addLeg();
				break;
			case 5:
				beetle.addHead();
				break;
			case 6:
				beetle.addBody();
				roll();
				break;
		}
	}
	
	public int getScore(){
		return beetle.getValue();
	}
	
	public boolean hasWon(){
		return beetle.isComplete();
	}
}
