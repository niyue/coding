package com.niyue.coding.leetcode.addbinary;

import java.util.Deque;
import java.util.LinkedList;

/*
 * http://oj.leetcode.com/problems/add-binary/
 */
public class SolutionTwo {
    public String addBinary(String a, String b) {
        char[] na = a.toCharArray();
        char[] nb = b.toCharArray();
        int ia = na.length - 1;
        int ib = nb.length - 1;
        int carry = 0;
        Deque<Integer> sum = new LinkedList<Integer>();
        while(ia >= 0 || ib >= 0 || carry > 0) {
            int da = ia >= 0 ? na[ia] - '0' : 0;
            int db = ib >= 0 ? nb[ib] - '0' : 0;
            int d = da + db + carry;
            sum.offerFirst(d % 2);
            carry = d / 2;
            ia--;
            ib--;
        }
        StringBuilder s = new StringBuilder();
        for(int d : sum) {
            s.append(d);   
        }
        return s.toString();
    }
}
