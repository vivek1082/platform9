package com.platform9.diwalibulbs.dto;

import java.util.List;

public class InputBulbString {

	private List<Integer> bulbs;
	
	private int noOfSwitch;

	public List<Integer> getBulbs() {
		return bulbs;
	}

	public void setBulbs(List<Integer> bulbs2) {
		this.bulbs = (List<Integer>) bulbs2;
	}

	public int getNoOfSwitch() {
		return noOfSwitch;
	}

	public void setNoOfSwitch(int noOfSwitch) {
		this.noOfSwitch = noOfSwitch;
	}

	@Override
	public String toString() {
		return "InputBulbString [bulbs=" + bulbs + ", noOfSwitch=" + noOfSwitch + "]";
	}
	
	
	
	
}
