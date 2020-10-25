package com.platform9.diwalibulbs.dto;

import java.util.List;

public class OutputBulbList {

	private List<MaxSparkedBulb> output;

	public List<MaxSparkedBulb> getOutput() {
		return output;
	}

	public void setOutput(List<MaxSparkedBulb> output) {
		this.output = output;
	}

	@Override
	public String toString() {
		return "BulbOutputList [output=" + output + "]";
	}
	
	
}
