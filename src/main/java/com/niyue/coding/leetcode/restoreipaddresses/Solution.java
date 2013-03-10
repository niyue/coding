package com.niyue.coding.leetcode.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ArrayList<String> restoreIpAddresses(String ip) {
        return restore(ip, ip.length() - 1, 4);
    }

    private ArrayList<String> restore(String ip, int index, int segment) {
        ArrayList<String> segments = new ArrayList<String>();
        if(segment == 1) {
        	if(isValidIpSegment(ip, 0, index)) {
        		segments.add(ip.substring(0, index + 1));
        	}
        } else {
            for(int i = 0; i < 3 && index - i >= 0; i++) {
                if(isValidIpSegment(ip, index - i, index)) {
                    List<String> subSegments = restore(ip, index - i - 1, segment - 1);
                    for(String subSegment : subSegments) {
                        segments.add(subSegment + "." + ip.substring(index - i, index + 1));
                    }
                }
            }
        }
        return segments;
    }

    private boolean isValidIpSegment(String ip, int start, int end) {
        boolean isValidIpSegment = false;
        if(ip.charAt(start) == '0') {
        	isValidIpSegment = start == end;
        } else {
        	if(end - start < 3 && end >= 0) {
        		int segment = Integer.parseInt(ip.substring(start, end + 1));
        		isValidIpSegment = segment >= 1 && segment < 256;
        	}
        }
        return isValidIpSegment;
    }    
}
