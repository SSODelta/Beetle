package com.ignatieff.beetle;

public class Beetle {
	
	private boolean BODY = false, HEAD = false, TAIL = false;
	private int eyes = 0, ears = 0, legs = 0;
	
	public Beetle(){
		
	}
	
	public void addBody(){
		BODY = true;
	}
	
	public void addHead(){
		if(BODY)
			HEAD = true;
	}
	
	public void addTail(){
		if(BODY)
			TAIL = true;
	}
	
	public void addLeg(){
		if(BODY && legs<6)
			legs++;
	}
	
	public void addEye(){
		if(HEAD && eyes<2)
			eyes++;
	}
	
	public void addEar(){
		if(HEAD && ears<2)
			ears++;
	}
	
	public boolean isComplete(){
		return HEAD && BODY && TAIL && (eyes==2) && (ears==2) && (legs==6);
	}
	
	private static int i(boolean b){
		return b ? 1 : 0;
	}
	
	public int getValue(){
		return 1*i(TAIL)
			 + 2*eyes
			 + 3*ears
			 + 4*legs
			 + 5*i(HEAD)
			 + 6*i(BODY);
	}
	
	
}
