package com.yaoxj.lambda;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;


public class TestLambda {

	public static void main(String[] args) {
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};  
			List<String> players =   Arrays.asList(atp); 
			
			for (int i = 0; i < players.size(); i++) {
				System.out.println("list test==="+players.get(i));
			}
			
			players.forEach(p -> System.out.println(p));
			System.out.println("==========="+"aac".hashCode());
			System.out.println("==========="+"aabc".hashCode());
			System.out.println("==========="+"abc".hashCode());
		
	}

}
