package com.niyue.coding.leetcode.lrucache;

import java.util.Map;

public class LRUCache {
	private static final float hashTableLoadFactor = 0.75f;
	
    private Map<Integer, Integer> cache;
         
    @SuppressWarnings("serial")
	public LRUCache(final int capacity) {
        this.cache = new java.util.LinkedHashMap<Integer, Integer>(capacity, hashTableLoadFactor, true) {
            @Override 
            protected boolean removeEldestEntry (Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.containsKey(key) ? cache.get(key) : -1;
    }
    
    public void set(int key, int value) {
        cache.put(key, value);
    }
}