package com.niyue.coding.hackerrank.botsavesprincess;

import java.util.Scanner;
// https://www.hackerrank.com/challenges/saveprincess
public class Solution {
   private static int[] m = new int[2];

    /* Head ends here */
    static void displayPathtoPrincess(int n, String [] grid) {
        int[] p = princessCoordinates(n, grid);
        String dx = p[1] < m[1] ? "LEFT" : "RIGHT";
        String dy = p[0] < m[0] ? "UP" : "DOWN";
        for(int x = 0; x < Math.abs(p[1] - m[1]); x++) {
            System.out.println(dx);
        }      
        for(int y = 0; y < Math.abs(p[0] - m[0]); y++) {
            System.out.println(dy);
        }    
    }
    
    private static int[] princessCoordinates(int n, String [] grid) {
        int[] p = null;
        int[][] corners = new int[][]{{0, 0}, {0, n - 1}, {n - 1, 0}, {n - 1, n - 1}};
        for(int[] c : corners) {
            if(hasPrincess(grid, c[0], c[1])) {
               p = c; 
            }
        }
        return p;
    }
    
    private static boolean hasPrincess(String[] grid, int y, int x) {
        return grid[y].charAt(x) == 'p';
    }
    
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        String grid[] = new String[n];
        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
            int mx = grid[i].indexOf('m');
            if(mx != -1) {
                m[0] = i;
                m[1] = mx;
            }
        }
        in.close();
        displayPathtoPrincess(n,grid);
    }
}
