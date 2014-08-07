package com.niyue.coding.hackerrank.mindmaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> colors = new ArrayList<String[]>();
        
        String line = null;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            String[] colorLine = line.split(" ");
            colors.add(colorLine);
        }
        sc.close();
        
        String[] answer = colors.get(0);
        for(int i = 1; i < colors.size(); i++) {
        	String[] guess = colors.get(i);
        	colorTest(answer, guess);
        }
    }
	
	private static void colorTest(String[] answer, String[] guess) {
		int correct = 0;
		int partialCorrect = 0;
		for(int i = 0; i < guess.length; i++) {
			if(answer[i].equals(guess[i])) {
				correct++;
			}
		}
        Map<String, Integer> guessCount = countColors(guess);
        Map<String, Integer> answerCount = countColors(answer);
        for(Entry<String, Integer> colorCount : guessCount.entrySet()) {
            String color = colorCount.getKey();
            int count = colorCount.getValue();
            int expectedCount = answerCount.containsKey(color) ? answerCount.get(color) : 0;
            partialCorrect += Math.min(count, expectedCount);
        }
        partialCorrect -= correct;
        
		System.out.format("%s %s\n", correct, partialCorrect);
	}
    
    private static Map<String, Integer> countColors(String[] colors) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        for(int i = 0; i < colors.length; i++) {
            String color = colors[i];
            if(count.containsKey(color)) {
                count.put(color, count.get(color) + 1);
            } else {
                count.put(color, 1);
            }
        }    
        return count;
    }
}