package com.niyue.coding.leetcode.simplifypath;

import java.util.Collections;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_71
public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        String[] segments = path.split("/");
        for(String segment : segments) {
            if(isParent(segment)) {
                if(!stack.isEmpty()) {
                    stack.removeFirst();
                }
            } else if(!isCurrentOrEmpty(segment)) {
                stack.addFirst(segment);
            }
        }        
        return getPath(stack);
    }

    private boolean isCurrentOrEmpty(String segment) {
        return ".".equals(segment) || "".equals(segment);
    }

    private boolean isParent(String segment) {
        return "..".equals(segment);
    }

    private String getPath(LinkedList<String> segments) {
        String path = "/";
        if(!segments.isEmpty()) {
            Collections.reverse(segments);
            StringBuilder builder = new StringBuilder("/");
            for(String segment : segments) {
                builder.append(segment).append("/");
            }
            path = builder.substring(0, builder.length() - 1).toString(); 
        }
        return path;
    }
}
