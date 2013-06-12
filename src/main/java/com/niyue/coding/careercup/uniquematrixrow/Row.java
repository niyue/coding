package com.niyue.coding.careercup.uniquematrixrow;

import java.util.Arrays;

public class Row {
	public final int rowIndex;
	public final int[] values;
	public Row(int rowIndex, int[] values) {
		this.rowIndex = rowIndex;
		this.values = values;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(values);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Row other = (Row) obj;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}
}
