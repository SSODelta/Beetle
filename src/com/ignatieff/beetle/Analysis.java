package com.ignatieff.beetle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analysis {

	private double mean, var;
	private int median, max = 0;
	
	public Analysis(int[] data){
		this(getList(data));
	}
	
	private static ArrayList<Integer> getList(int[] data){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : data)
			list.add(i);
		return list;
	}
	
	public Analysis(List<Integer> data){
		
		//First, sort the data
		Collections.sort(data);
		
		//Next extract the median
		median = data.get(data.size()/2);
		
		//Now, calculate the arithmetic mean
		for(Integer i : data){
			mean+=i;
			if(i>max)max=i;
		}
		
		mean /= data.size();
		
		//And finally, the variance
		for(Integer i : data)
			var += Math.pow(i - mean, 2);
		
		var /= data.size()-1;
	}
	
	public void print(){
		System.out.println("Median:          "+median);
		System.out.println("Max:             "+max);
		System.out.println("Arithmetic mean: "+mean);
		System.out.println("Variance:        "+var + "\t(std = "+Math.sqrt(var)+")");
	}
	
	private static String rep(char c, double len){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<len; i++)
			sb.append(c);
		
		return sb.toString();
	}
}
