package com.niyue.coding.leetcode.setmatrixzeroes;

// http://leetcode.com/onlinejudge#question_73
public class Solution {
    public void setZeroes(int[][] matrix) {
		boolean firstColumnZero = isFirstColumnZero(matrix);
		boolean firstRowZero = isFirstRowZero(matrix);    

		recordZeroColumnsAndRows(matrix);

		setZeroForMatrix(matrix);

		setZeroForFirstRow(matrix, firstRowZero);

		setZeroForFirstColumn(matrix, firstColumnZero);
    }
    
    private boolean isFirstColumnZero(int[][] matrix) {
    	boolean firstColumnZero = false;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				firstColumnZero = true;
				break;
			}
		}
		return firstColumnZero;
    }
    
    private boolean isFirstRowZero(int[][] matrix) {
    	boolean firstRowZero = false;
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		} 
		return firstRowZero;
    }
    
    private void recordZeroColumnsAndRows(int[][] matrix) {
    	for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
    }
    
    private void setZeroForMatrix(int[][] matrix) {
    	for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[i][0] != 0 && matrix[0][j] != 0 ? matrix[i][j] : 0;
			}
		}
    }
    
    private void setZeroForFirstRow(int[][] matrix, boolean firstRowZero) {
    	if(firstRowZero) {
    		for(int i = 0; i < matrix[0].length; i++) {
    			matrix[0][i] = 0;
    		}	
    	}
    }
    
    private void setZeroForFirstColumn(int[][] matrix, boolean firstColumnZero) {
    	if(firstColumnZero) {
    		for(int i = 0; i < matrix.length; i++) {
    			matrix[i][0] = 0;
    		}	
    	}
    }
}
