package com.niyue.coding.careercup.twentyfourpoints;

import java.util.Arrays;
import java.util.List;

// http://www.careercup.com/question?id=3976694
public class TwentyFourPoints {
	
	public String[] find(int n1, int n2, int n3, int n4) {
		Permutation<Integer> operandsPermutation = new Permutation<Integer>();
		List<List<Integer>> operands = operandsPermutation.permute(Arrays.asList(n1, n2, n3, n4));
		
		Permutation<String> operatorPermutation = new Permutation<String>();
		List<List<String>> operators = operatorPermutation.permute(Arrays.asList("+", "-", "*", "/", "+", "-", "*", "/", "+", "-", "*", "/"), 3);
		
		String[] result = null;
		ExpressionEvaluator exp = new ExpressionEvaluator();
		for(List<Integer> operandList : operands) {
			for(List<String> operatorList : operators) {
				String[] expression = new String[operandList.size() + operatorList.size()];
				for(int i = 0; i < operandList.size() + operatorList.size(); i++) {
					expression[i] = i % 2 == 0 ? operandList.get((i + 1) / 2).toString() : operatorList.get(i / 2);
				}
				
				int value = exp.evaluate(expression);
				if(value == 24) {
					result = expression;
					break;
				}
			}
		}
		
		return result;
	}
}
