package com.niyue.coding.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_1
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();
        for(int i = 0;i < numbers.length;i++) {
            numbersMap.put(numbers[i], i);    
        }
        
        for(int i = 0;i < numbers.length;i++) {
            int targetNumber = target - numbers[i];
            if(numbersMap.containsKey(targetNumber) && 
               numbersMap.get(targetNumber) != i) {
               result[0] = i + 1;
               result[1] = numbersMap.get(targetNumber) + 1;
               break;
            }
        }
        return result;
    }
}
