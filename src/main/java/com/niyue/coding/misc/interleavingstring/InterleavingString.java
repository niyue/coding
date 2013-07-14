package com.niyue.coding.misc.interleavingstring;

// http://www.mitbbs.com/article_t/JobHunting/32286605.html
public class InterleavingString {
	
	public String interleave(String[] A, String[] B) {
		int ai = 0, aiai = 0, bi = 0, bibi = 0;
		StringBuilder s = new StringBuilder();
		boolean fromA = true;
		while(ai < A.length && aiai < A[ai].length() && bi < B.length && bibi < B[bi].length()) {
			if(fromA) {
				s.append(A[ai].charAt(aiai));
				aiai++;
				if(aiai == A[ai].length()) {
					ai++;
					while(ai < A.length && A[ai].isEmpty()) {
						ai++;
					}
					aiai = 0;
				}
				fromA = false;
			} else {
				s.append(B[bi].charAt(bibi));
				bibi++;
				if(bibi == B[bi].length()) {
					bi++;
					while(bi < B.length && B[bi].isEmpty()) {
						bi++;
					}
					bibi = 0;
				}
				fromA = true;
			}
		}
		return s.toString();
	}
}
