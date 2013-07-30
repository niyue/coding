package com.niyue.coding.misc.lrucache;

import java.util.LinkedHashMap;

// implement a very basic LRU cache based on LinkedHashMap
// http://stackoverflow.com/questions/221525/how-would-you-implement-an-lru-cache-in-java-6
// Collections.synchronizedMap is still needed to make it thread safe
public class LruCache<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 8129043197792251756L;

	private final int cacheSize;
	
	public LruCache(int cacheSize) {
		super(16, 0.75f, true);
		this.cacheSize = cacheSize;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > cacheSize;
	}
}
