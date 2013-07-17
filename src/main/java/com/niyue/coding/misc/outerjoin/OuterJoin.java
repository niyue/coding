package com.niyue.coding.misc.outerjoin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// http://www.mitbbs.com/article_t/JobHunting/32328363.html
public class OuterJoin {
	/*
	 * Implement full outer join using naive hash join algorithm
	 * Sort-merge join seems more complicated when handling matched case for non unique columns
	 */
	public List<List<Integer>> hashJoin(List<List<Integer>> ra, List<List<Integer>> rb) {
		Map<Integer, List<List<Integer>>> relationA = rowMap(ra, 1);
		Map<Integer, List<List<Integer>>> relationB = rowMap(rb, 0);
		List<List<Integer>> joinedRelation = new ArrayList<List<Integer>>();
		for(Entry<Integer, List<List<Integer>>> tupleEntry : relationA.entrySet()) {
			int key = tupleEntry.getKey();
			List<List<Integer>> aValues = tupleEntry.getValue();
			if(relationB.containsKey(key)) {
				List<List<Integer>> bValues = relationB.get(key);
				for(List<Integer> rowA : aValues) {
					for(List<Integer> rowB : bValues) {
						List<Integer> bothMatchedRow = new ArrayList<Integer>(rowA);
						bothMatchedRow.add(rowB.get(1));
						joinedRelation.add(bothMatchedRow);
					}
				}
			} else {
				for(List<Integer> row : aValues) {
					List<Integer> leftMatchedRow = new ArrayList<Integer>(row);
					leftMatchedRow.add(null);
					joinedRelation.add(leftMatchedRow);
				}
			}
		}
		
		for(Entry<Integer, List<List<Integer>>> tupleEntry : relationB.entrySet()) {
			int key = tupleEntry.getKey();
			List<List<Integer>> bValues = tupleEntry.getValue();
			if(!relationA.containsKey(key)) {
				for(List<Integer> rowB : bValues) {
					List<Integer> rightMatchedRow = new ArrayList<Integer>();
					rightMatchedRow.add(null);
					rightMatchedRow.addAll(rowB);
					joinedRelation.add(rightMatchedRow);
				}
			}
		}
		return joinedRelation;
	}
	
	private Map<Integer, List<List<Integer>>> rowMap(List<List<Integer>> ra, int col) {
		Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
		for(List<Integer> row : ra) {
			int value = row.get(col);
			if(!map.containsKey(value)) {
				map.put(value, new ArrayList<List<Integer>>());
			}
			map.get(value).add(row);
		}
		return map;
	}
}
