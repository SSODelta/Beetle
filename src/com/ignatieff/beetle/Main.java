package com.ignatieff.beetle;

import java.util.ArrayList;

public class Main {

	private static int games = 10000000, players = 25;
	private static ArrayList<Integer> vals;
	
	private static long t_start;
	
	public static void main(String[] args) {
		
		t_start = System.currentTimeMillis();
		
		if(args.length==2){
			games   = Integer.parseInt(args[1]);
			players = Integer.parseInt(args[0]);
		}
		
		vals = new ArrayList<Integer>();
		int[] lens = new int[games];

		println("Simulating "+String.format("%,d", games) + " games (pop. "+players+")...");
		for(int i=0; i<games; i++){
			Game g = new Game(players);
			g.play();
			
			for(int k : g.getValues())
				vals.add(k);
			
			lens[i] = g.getRounds();
		}

		println("Analyzing...");
		
		Analysis a = new Analysis(vals);
		Analysis b = new Analysis(lens);
		
		System.out.println();
		
		println  ("SCORES");
		a.print();

		System.out.println();
		println("GAME LENGTH");
		b.print();
	}

	private static String timestamp(){
		return "" + ((double)(System.currentTimeMillis() - t_start))/1000.0;
	}
	
	private static void println(String s){
		System.out.println("["+timestamp()+"]\t\t"+s);
	}

}
