package com.platform9.diwalibulbs.services;

import com.platform9.diwalibulbs.dto.OutputBulbList;
import com.platform9.diwalibulbs.dto.TotalInputBulbs;

public interface CountPositionService {

	public OutputBulbList countSwitch(TotalInputBulbs bulbs);
	
}
