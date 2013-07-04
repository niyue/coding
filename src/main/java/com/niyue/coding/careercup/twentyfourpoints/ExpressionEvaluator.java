package com.niyue.coding.careercup.twentyfourpoints;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionEvaluator {
	public int evaluate(String[] exp) {
		Deque<String> operatorStack = new ArrayDeque<String>();
		Deque<Integer> operandStack = new ArrayDeque<Integer>();
		for(int i = 0; i < exp.length; i++) {
			String e = exp[i];
			if(isOperand(i)) {
				operandStack.addFirst(Integer.valueOf(e));
			} else {
				Integer operandTwo = Integer.valueOf(exp[i + 1]);
				i++;
				if(!operatorStack.isEmpty()) {
					String prevOp = operatorStack.peekFirst();
					if(hasHigherPriority(e, prevOp)) {
						int result = calculate(e, 
								operandStack.removeFirst(), 
								operandTwo);
						operandStack.addFirst(result);
					} else {
						prevOp = operatorStack.remove();
						Integer n2 = operandStack.removeFirst();
						Integer n1 = operandStack.removeFirst();
						int result = calculate(prevOp, n1, n2);
						operatorStack.addFirst(e);
						operandStack.addFirst(result);
						operandStack.addFirst(operandTwo);
					}
				} else {
					operatorStack.addFirst(e);
					operandStack.addFirst(operandTwo);
				}
			}
		}
		int n2 = operandStack.removeFirst();
		int n1 = operandStack.removeFirst();
		int result = calculate(operatorStack.removeFirst(), n1, n2);
		return result;
	}
	
	private boolean isOperand(int i) {
		return i % 2 == 0;
	}
	
	private boolean hasHigherPriority(String op1, String op2) {
		return (op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"));
	}
	
	private int calculate(String op, int n1, int n2) {
		int result = 0;
		if(op.equals("+")) {
			result = n1 + n2;
		} else if(op.equals("-")) {
			result = n1 - n2;
		} else if(op.equals("*")) {
			result = n1 * n2;
		} else {
			result = n1 / n2;
		}
		return result;
	}
}
