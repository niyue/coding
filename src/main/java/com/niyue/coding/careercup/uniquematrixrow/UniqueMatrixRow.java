package com.niyue.coding.careercup.uniquematrixrow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a binary matrix of N X N of integers , you need to return only unique rows of binary arrays
// http://www.careercup.com/question?id=9478119
public class UniqueMatrixRow {
	public int[][] findUnique(int[][] matrix) {
		Row[] rows = convert(matrix);
		RadixSort sort = new RadixSort();
		List<Row> sortedRows = sort.sort(rows);
		Row prev = null;
		List<Row> uniqueRows = new ArrayList<Row>();
		for(Row row : sortedRows) {
			if(!row.equals(prev)) {
				uniqueRows.add(row);
			}
		}
		Map<Integer, int[]> uniqueRowMap = uniqueRowMap(uniqueRows);
		int[][] uniqueMatrix = new int[uniqueRows.size()][matrix[0].length];
		int j = 0;
		for(int i = 0; i < matrix.length; i++) {
			if(uniqueRowMap.containsKey(i)) {
				uniqueMatrix[j] = uniqueRowMap.get(i);
				j++;
			}
		}
		return uniqueMatrix;
	}
	
	private Map<Integer, int[]> uniqueRowMap(List<Row> uniqueRows) {
		Map<Integer, int[]> uniqueRowMap = new HashMap<Integer, int[]>();
		for(Row row : uniqueRows) {
			uniqueRowMap.put(row.rowIndex, row.values);
		}
		return uniqueRowMap;
	}
	
	private Row[] convert(int[][] matrix) {
		Row[] rows = new Row[matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			Row row = new Row(i, matrix[i]);
			rows[i] = row;
		}
		return rows;
	}
}
