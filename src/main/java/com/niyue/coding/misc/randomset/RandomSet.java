package com.niyue.coding.misc.randomset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// http://www.mitbbs.com/article_t/JobHunting/32186343.html
// Implement a random set (unique elements) with O(1) insertion/deletion/returning random element
public class RandomSet<E> {
	private Map<E, Integer> map = new HashMap<E, Integer>();
	private List<E> list = new ArrayList<E>();
	private Random random = new Random();
	
	public boolean contains(E v) {
		return map.containsKey(v);
	}
	
	public void add(E v) {
		if(!map.containsKey(v)) {
			list.add(v);
			map.put(v, list.size() - 1);
		}
	}
	
	public E remove(E v) {
		E removed = null;
		if(map.containsKey(v)) {
			int index = map.remove(v);
			list.set(index, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			removed = v;
		}
		return removed;
	}
	
	public E random() {
		E rand = null;
		if(!list.isEmpty()) {
			int index = random.nextInt(list.size());
			rand = list.get(index);
		} 
		return rand;
	}
	
	public int size() {
		return list.size();
	}
}
