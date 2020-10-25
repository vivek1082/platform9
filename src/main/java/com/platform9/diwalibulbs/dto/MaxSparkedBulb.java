package com.platform9.diwalibulbs.dto;

import java.util.List;

public class MaxSparkedBulb {

	private int maxOnBulbs;
	
	private List<Integer> bulbPosition;

	public int getMaxOnBulbs() {
		return maxOnBulbs;
	}

	public void setMaxOnBulbs(int maxOnBulbs) {
		this.maxOnBulbs = maxOnBulbs;
	}

	public List<Integer> getBulbPosition() {
		return bulbPosition;
	}

	public void setBulbPosition(List<Integer> bulbPosition) {
		this.bulbPosition = bulbPosition;
	}

	@Override
	public String toString() {
		return "MaxSparkedBulb [maxOnBulbs=" + maxOnBulbs + ", bulbPosition=" + bulbPosition + "]";
	}
	
	
	
}
