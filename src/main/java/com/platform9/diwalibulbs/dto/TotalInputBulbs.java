package com.platform9.diwalibulbs.dto;

import java.util.List;

public class TotalInputBulbs {
	
	private List<InputBulbString> bulbString;

	public List<InputBulbString> getBulbString() {
		return bulbString;
	}

	public void setBulbString(List<InputBulbString> bulbString) {
		this.bulbString = bulbString;
	}

	@Override
	public String toString() {
		return "TotalInputBulbs [bulbString=" + bulbString + "]";
	}
	
	
}
