package com.niyue.coding.leetcode.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String ipString;

    public ArrayList<String> restoreIpAddresses(String s) {
        ipString = s;
        int[] ip = ipDigits(s);
        return restore(ip, ip.length - 1, 4);
    }

    private ArrayList<String> restore(int[] ip, int index, int segment) {
        ArrayList<String> segments = new ArrayList<String>();
        if(segment == 1) {
        	if(isValidIpSegment(ip, 0, index)) {
        		segments.add(ipString.substring(0, index + 1));
        	}
        } else {
            for(int i = 0; i < 3 && index - i >= 0; i++) {
                if(isValidIpSegment(ip, index - i, index)) {
                    List<String> subSegments = restore(ip, index - i - 1, segment - 1);
                    for(String subSegment : subSegments) {
                        segments.add(subSegment + "." + ipString.substring(index - i, index + 1));
                    }
                }
            }
        }
        return segments;
    }

    private int[] ipDigits(String ipString) {
    	char[] ipChars = ipString.toCharArray();
        int[] ip = new int[ipChars.length];
        for(int i = 0; i < ipChars.length; i++) {
            ip[i] = ipChars[i] - '0';
        }
        return ip;
    }

    private boolean isValidIpSegment(int[] ip, int start, int end) {
        boolean isValidIpSegment = false;
        int segment = 0;
        if(ip[start] == 0) {
        	isValidIpSegment = start == end;
        } else {
        	if(end - start < 3) {
        		for(int i = start; i <= end; i++) {
        			segment = segment * 10 + ip[i];
        		}
        		isValidIpSegment = segment >= 1 && segment < 256;
        	}
        }
        return isValidIpSegment;
    }    
}
