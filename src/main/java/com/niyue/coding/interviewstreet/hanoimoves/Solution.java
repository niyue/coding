package com.niyue.coding.interviewstreet.hanoimoves;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private int N, K;
    private static final int MAX_MOVES = 7;
    private List<Deque<Integer>> pegs;
    private List<Deque<Integer>> endingPegs;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();
        move(pegs, new LinkedList<int[]>());
    }

    private boolean move(List<Deque<Integer>> pegs, Deque<int[]> moves) {
        boolean isSolutionFound = false;
        int[] lastMove = moves.peekFirst(); 
        if(moves.size() < MAX_MOVES) {
            for(int i = 0; i < K; i++) {
                for(int j = 0; j < K; j++) {
                    if(j != i && isNotBackMove(i, j, lastMove)) {
                        if(isMovable(pegs, i, j)) {
                            moves.addFirst(new int[] {i, j});
                            move(pegs, i, j);
                            isSolutionFound = move(pegs, moves);
                            if(isFinal(pegs)) {
                                print(moves);
                                isSolutionFound = true;
                            }
                            if(isSolutionFound) {
                                break;
                            }
                            moves.removeFirst();
                            move(pegs, j, i);
                        }
                    }
                }
            }
        }
        return isSolutionFound;
    }

    private boolean isNotBackMove(int from, int to, int[] lastMove) {
        return lastMove == null || from != lastMove[0] || to != lastMove[1];   
    }

    private boolean isFinal(List<Deque<Integer>> pegs) {
        boolean isFinal = true;
        for(int i = 0; i < endingPegs.size(); i++) {
            Deque<Integer> peg = pegs.get(i);
            Deque<Integer> endingPeg = endingPegs.get(i);
            if(peg.size() == endingPeg.size()) {
                Iterator<Integer> pegIter = peg.iterator();
                Iterator<Integer> endingPegIter = endingPeg.iterator();
                while(pegIter.hasNext()) {
                    if(pegIter.next() != endingPegIter.next()) {
                        isFinal = false;
                        break;
                    }
                }
            } else {
                isFinal = false;
                break;
            }
            if(!isFinal) {
                break;
            }
        }
        return isFinal;
    }

    private boolean isMovable(List<Deque<Integer>> pegs, int from, int to) {
        return !pegs.get(from).isEmpty() && (pegs.get(to).isEmpty() || pegs.get(from).peekFirst() < pegs.get(to).peekFirst());
    }

    private void move(List<Deque<Integer>> pegs, int from, int to) {
        pegs.get(to).addFirst(pegs.get(from).removeFirst());
    }

    private void print(Deque<int[]> moves) {
    	Deque<int[]> reverseMoves = new LinkedList<int[]>(moves);
        for(int[] move : reverseMoves) {
            System.out.println(move[0] + " " + move[1]);
        }
    }
    
    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        pegs = readPegs(N, K, scanner);
        endingPegs = readPegs(N, K, scanner);
    }

    private List<Deque<Integer>> readPegs(int N, int K, Scanner scanner) {
        List<Deque<Integer>> pegs = new ArrayList<Deque<Integer>>(K);
        for(int i = 0; i < K; i++) {
            pegs.add(new LinkedList<Integer>());
        }

        for(int i = 1; i <= N; i++) {
            int pegNo = scanner.nextInt() - 1;
            pegs.get(pegNo).addLast(i);
        }    
        return pegs;
    }
}

