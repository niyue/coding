package com.niyue.coding.careercup.signaturepermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * You are given an array of n elements [1,2,....n]. For example {3,2,1,6,7,4,5}.
 * Now we create a signature of this array by comparing every consecutive pair of elements. 
 * If they increase, write I else write D. For example for the above array, the signature would be "DDIIDI". 
 * The signature thus has a length of N-1. 
 * Now the question is given a signature, compute the lexicographically smallest permutation of [1,2,....n]. 
 * It can be solved if n<10 easily (O(n)) with methods http://www.careercup.com/question?id=14912744
 * However, if n>=10, some numbers like 10 is lexicographically larger than 10, and here is an O(n^2) solution to this problem
 * The algorithm is:
 * 1) sort all the numbers lexicograhically, [1..12] is sorted to [10, 11, 1, 12, 2, 3, 4, 5, 6, 7, 8, 9]
 * 2) put all numbers [1..n] into a sorted set, this is done by using single tree set
 * 3) iterate the signature, find the numbers with highest indexes and lowest indexes, for example, DDID, the highest number index is 3, and the lowest number index is 2, 4
 * 4) for each signature
 * 	4.1) if this is an I signature:
 * 		the current output number should not be greater than (next possible highest number - distance to next highest number)
 * 		the next possible highest number is the max one from sorted set
 * 		and the distance to next highest number can be calculated from (next highest index - current index)
 * 		for each number in the lexicographically sorted array, find the first number that is less or equal to the (max - distance)
 * 	4.2) if this is an D signature:
 * 		the current output number should not be less than (next possible lowest number + distance to next lowest number)
 * 		the next possible lowest number is the min one from sorted set
 * 		and the distance to next lowest number can be calculated from (next lowest index - current index)
 * 		for each number in the lexicographically sorted array, find the first number that is greater or equal to the (min + distance)	
 */
public class SignaturePermutation {
	
	public List<Integer> smallestPermutation(String signatureString) {
		List<Direction> signature = parse(signatureString);
		int n = signature.size() + 1;
		List<Integer> numbers = allNumbers(n);
		
		SortedSet<Integer> sortedNumbers = new TreeSet<Integer>(numbers);
		List<Integer> lexicographicallySortedNumbers = sortLexicographically(numbers);
		
		List<Integer> highestIndexes = extremeNumberIndexes(signature, Direction.I);
		List<Integer> lowestIndexes = extremeNumberIndexes(signature, Direction.D);
		
		List<Integer> permutation = new ArrayList<Integer>(n);
		int hi = 0;
		int li = 0;
		for(int si=0;si<signature.size();si++) {
			Direction direction = signature.get(si);
			int nextElement = 0;
			if(direction == Direction.I) {
				int nextHighestIndex = highestIndexes.get(hi);
				int distanceToHighest = nextHighestIndex - si;
				if(distanceToHighest == 1) { // climb over the highest
					hi++;
				}
				int max = sortedNumbers.last();
				int maxAllowed = max - distanceToHighest;
				nextElement = findLexicographicallyMax(lexicographicallySortedNumbers, maxAllowed);
			} else {
				int nextLowestIndex = lowestIndexes.get(li);
				int distanceToLowest = nextLowestIndex - si;
				if(distanceToLowest == 1) { // move to the lowest
					li++;
				}
				int min = sortedNumbers.first();
				int minAllowed = min + distanceToLowest;
				nextElement = findLexicographicallyMin(lexicographicallySortedNumbers, minAllowed);
			}
			sortedNumbers.remove(nextElement);
			permutation.add(nextElement);
		}
		permutation.add(sortedNumbers.first());
		return permutation;
	}
	
	int findLexicographicallyMax(List<Integer> lexicographicallySortedNumbers, int maxAllowed) {
		int result = 0;
		for(int i=0;i<lexicographicallySortedNumbers.size();i++) {
			if(lexicographicallySortedNumbers.get(i) <= maxAllowed) {
				result = lexicographicallySortedNumbers.get(i);
				lexicographicallySortedNumbers.remove(i);
				break;
			}
		}
		return result;
	}
	
	int findLexicographicallyMin(List<Integer> lexicographicallySortedNumbers, int minAllowed) {
		int result = 0;
		for(int i=0;i<lexicographicallySortedNumbers.size();i++) {
			if(lexicographicallySortedNumbers.get(i) >= minAllowed) {
				result = lexicographicallySortedNumbers.get(i);
				lexicographicallySortedNumbers.remove(i);
				break;
			}
		}
		return result;
	}
	
	List<Integer> extremeNumberIndexes(List<Direction> signature, Direction extreme) {
		List<Integer> indexes = new ArrayList<Integer>();
		for(int si=0;si<signature.size();si++) {
			Direction direction = signature.get(si);
			if(direction == extreme) {
				Direction nextDirection = si == signature.size() - 1 ? null : signature.get(si + 1);
				if(nextDirection == null || (nextDirection != null && nextDirection != direction)) {
					indexes.add(si + 1);
				}
			}
		}
		return indexes;
	}
	
	List<Integer> allNumbers(int n) {
		List<Integer> allNumbers = new ArrayList<Integer>(n);
		for(int i = 0; i < n;i++) {
			allNumbers.add(i+1);
		}
		return allNumbers;
	}
	
	List<Direction> parse(String signature) {
		List<Direction> parsedSignature = new ArrayList<Direction>();
		for(int i = 0; i < signature.length(); i++) {
			parsedSignature.add(Direction.valueOf(signature.charAt(i)));
		}
		return parsedSignature;
	}
	
	List<Integer> sortLexicographically(List<Integer> numbers) {
		List<Integer> lexicographicallySortedNumbers = new ArrayList<Integer>(numbers);
		Collections.sort(lexicographicallySortedNumbers, new LexicographicalComparator());
		return lexicographicallySortedNumbers;
	}
	
	private static class LexicographicalComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer one, Integer two) {
			String s1 = one.toString();
			String s2 = two.toString();
			int result = s1.compareTo(s2);
			if(s1.length() != s2.length()) {
				if(s1.length() > s2.length()) {
					if(s1.startsWith(s2)) {
						result = compare(s1, s2);
					}
				} else {
					if(s2.startsWith(s1)) {
						result = -1 * compare(s2, s1);
					}
				}
			}
			return result;
		}
		
		private int compare(String longString, String shortString) {
			int result = longString.charAt(longString.length()-1) - shortString.charAt(0); // 123 is considered larger than 12
			result = result == 0 ? -1 : result; // 11 is smaller than 1
			return result;
		}
	}
	
	static enum Direction {
		I, D;
		public static Direction valueOf(char c) {
			return c == 'I' ? I : D;
		}
	};
}
