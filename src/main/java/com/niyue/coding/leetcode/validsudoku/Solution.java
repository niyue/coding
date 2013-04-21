package com.niyue.coding.leetcode.validsudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// http://leetcode.com/onlinejudge#question_36
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isAllRowsValid(board) && 
               isAllColumnsValid(board) &&
               isAllSubMatrixesValid(board);
    }

    private boolean isAllRowsValid(char[][] board) {
        boolean isValid = true;
        for(int y = 0; y < board.length; y++) {
            if(!isValid(asList(board[y]))) {
                isValid = false;
                break;
            }
        }
        return isValid;    
    }

    private boolean isAllColumnsValid(char[][] board) {
        boolean isValid = true;
        for(int x = 0; x < board[0].length; x++) {
            List<Character> column = new LinkedList<Character>();
            for(int y = 0; y < board.length; y++) {
                column.add(board[y][x]);
            }

            if(!isValid(column)) {
                isValid = false;
                break;    
            }
        }      
        return isValid;
    }

    private boolean isAllSubMatrixesValid(char[][] board) {
        boolean isValid = true;
        for(int y = 0; y < board.length; y = y + 3) {
            for(int x = 0; x < board.length; x = x + 3) {
                if(!isValid(numbers(board, x, y))) {
                    isValid = false;
                    break;    
                }    
            }
        }    
        return isValid;
    }

    private boolean isValid(List<Character> numbers) {
        java.util.Iterator<Character> iter = numbers.iterator();
        while(iter.hasNext()) {
            char c = iter.next();
            if(isEmptyCell(c)) {
                iter.remove();
            }
        }
        return new HashSet<Character>(numbers).size() == numbers.size();
    }

    private List<Character> asList(char[] numbers) {
        List<Character> num = new LinkedList<Character>();
        for(char c : numbers) {
            num.add(c);
        }
        return num;
    }

    private boolean isEmptyCell(char c) {
        return c == '.';
    }

    private List<Character> numbers(char[][] b, int x, int y) {
        return new LinkedList<Character>(Arrays.asList(
            b[y    ][x], b[y    ][x + 1], b[y    ][x + 2],
            b[y + 1][x], b[y + 1][x + 1], b[y + 1][x + 2],
            b[y + 2][x], b[y + 2][x + 1], b[y + 2][x + 2]));
    }
}
