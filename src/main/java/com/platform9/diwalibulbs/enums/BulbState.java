package com.platform9.diwalibulbs.enums;

public enum BulbState {
	ON('1'),
	OFF('0');

	private char state;
	BulbState(char c) {
		state = c;
	}
	
	public char getState() {
		return state;
	}
}
