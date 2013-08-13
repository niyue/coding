package com.niyue.coding.leetcode.setmatrixzeroes;

// http://leetcode.com/onlinejudge#question_73
public class Solution {
    public void setZeroes(int[][] matrix) {
		boolean firstColumn = isFirstColumnAllNonZero(matrix);
		boolean firstRow = isFirstRowAllNonZero(matrix);    

		recordZeroColumnsAndRows(matrix);

		setZeroForMatrix(matrix);

		setZeroForFirstRow(matrix, firstRow);

		setZeroForFirstColumn(matrix, firstColumn);
    }
    
    private boolean isFirstColumnAllNonZero(int[][] matrix) {
    	boolean firstColumn = true;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				firstColumn = false;
				break;
			}
		}
		return firstColumn;
    }
    
    private boolean isFirstRowAllNonZero(int[][] matrix) {
    	boolean firstRow = true;
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				firstRow = false;
				break;
			}
		} 
		return firstRow;
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
    
    private void setZeroForFirstRow(int[][] matrix, boolean firstRow) {
    	if(!firstRow) {
    		for(int i = 0; i < matrix[0].length; i++) {
    			matrix[0][i] = 0;
    		}	
    	}
    }
    
    private void setZeroForFirstColumn(int[][] matrix, boolean firstColumn) {
    	if(!firstColumn) {
    		for(int i = 0; i < matrix.length; i++) {
    			matrix[i][0] = 0;
    		}	
    	}
    }
}
