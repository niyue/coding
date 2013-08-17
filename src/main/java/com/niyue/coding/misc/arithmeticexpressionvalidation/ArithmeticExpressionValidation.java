package com.niyue.coding.misc.arithmeticexpressionvalidation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * Write code to do arithmetic expression validation: 
 * digits: 0..9
 * operators: +, -, (, ) 
 * Examples:
 * 1 + 2 - 3 				valid 
 * 1 + ( 2 - ( 3 + 4 ) ) 	valid 
 * - 2 						not valid
 * check out careercup.twentyfourpoints for another less capable solution
 */
public class ArithmeticExpressionValidation {
	private static final Set<String> OPERATORS = new HashSet<String>(Arrays.asList(
			"(", ")", "+", "-", "*", "/"
	));
	
	public int eval(String expression) {
		String[] expr = expression.split(" ");
		Deque<Integer> operands = new ArrayDeque<Integer>();
		Deque<String> operators = new ArrayDeque<String>();
		for(String element : expr) {
			if(OPERATORS.contains(element)) {
				if(operators.isEmpty()) {
					operators.add(element);
				} else {
					String prevOp = operators.peekFirst();
					boolean isHigherOp = isHigherOperator(prevOp, element);
					if(isHigherOp) {
						operators.pollFirst();
						if(operands.size() < 2) {
							throw new IllegalArgumentException("The expression given is invalid.");
						}
						int two = operands.pollFirst();
						int one = operands.pollFirst();
						int result = eval(one, prevOp, two);
						operands.addFirst(result);
					}
					if(element.equals(")")) {
						if(operators.isEmpty() || !operators.pollFirst().equals("(")) {
							throw new IllegalArgumentException("The expression given is invalid.");
						}
					} else {
						operators.offerFirst(element);
					}
				}
			} else {
				operands.offerFirst(Integer.parseInt(element));
			}
		}
		
		int result = operands.peekFirst();
		while(!operators.isEmpty()) {
			if(operands.size() < 2) {
				throw new IllegalArgumentException("The expression given is invalid.");
			}
			int two = operands.pollFirst();
			int one = operands.pollFirst();
			String op = operators.pollFirst();
			result = eval(one, op, two);
			operands.offerFirst(result);
		}
		if(operands.size() != 1) {
			throw new IllegalArgumentException("The expression given is invalid.");
		}
		return result;
	}
	
	private int eval(int v1, String op, int v2) {
		int result = 0;
		switch(op) {
			case "+":
				result = v1 + v2;
				break;
			case "-":
				result = v1 - v2;
				break;
			case "*":
				result = v1 * v2;
				break;
			case "/":
				result = v1 / v2;
				break;
		}
		return result;
	}
	
	private boolean isHigherOperator(String op1, String op2) {
		return !op1.equals("(") && !op2.equals("(") && 
			   (op2.equals(")") || op1.equals(op2) || (op1.equals("*") || op1.equals("/")));
	}
}
