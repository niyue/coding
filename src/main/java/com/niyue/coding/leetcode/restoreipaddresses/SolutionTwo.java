package com.niyue.coding.leetcode.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

/*
 * http://oj.leetcode.com/problems/restore-ip-addresses/
 * Use a dedicated function called isValidIpSegment to determine if s[i..j] is a valid IP segment so that it is easier to understand and solve this problem
 */
public class SolutionTwo {
    private ArrayList<String> ips;
    public ArrayList<String> restoreIpAddresses(String s) {
        ips = new ArrayList<String>();
        restore(s, 0, new ArrayList<Integer>());
        return ips;
    }
    
    private void restore(String s, int i, List<Integer> segments) {
        if(segments.size() == 4) {
            if(i == s.length()) {
                ips.add(newIP(s, segments));
            } 
        } else {
            for(int j = 1; j <= 3 && i + j <= s.length(); j++) {
                if(isValidIpSegment(s, i, i + j)) {
                    segments.add(i + j);
                    restore(s, i + j, segments);
                    segments.remove(segments.size() - 1);        
                }
            }
        }
    }
    
    private boolean isValidIpSegment(String ip, int start, int end) {
        boolean isValidIpSegment = false;
        if(ip.charAt(start) == '0') {
        	isValidIpSegment = start + 1 == end;
        } else {
    		int segment = Integer.parseInt(ip.substring(start, end));
    		isValidIpSegment = segment >= 1 && segment < 256;
        }
        return isValidIpSegment;
    }  
    
    private String newIP(String s, List<Integer> segments) {
        StringBuilder ip = new StringBuilder();
        ip.append(s.substring(0, segments.get(0))).append('.');
        ip.append(s.substring(segments.get(0), segments.get(1))).append('.');
        ip.append(s.substring(segments.get(1), segments.get(2))).append('.');
        ip.append(s.substring(segments.get(2), segments.get(3)));
        return ip.toString();
    }
}
