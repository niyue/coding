package com.niyue.coding.careercup.distributedmedian;

public class ComparingCount {
	public final int less;
	public final int equal;
	public final int greater;
	public final Integer nearestSmall;
	public final Integer nearestBig;
	public ComparingCount(int less, int equal, int greater, Integer nearestSmall, Integer nearestBig) {
		this.less = less;
		this.equal = equal;
		this.greater = greater;
		this.nearestSmall = nearestSmall;
		this.nearestBig = nearestBig;
	}
	@Override
	public String toString() {
		return "ComparingCount [less=" + less + ", equal=" + equal
				+ ", greater=" + greater + ", nearestSmall=" + nearestSmall
				+ ", nearestBig=" + nearestBig + "]";
	}
}
