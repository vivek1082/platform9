package com.platform9.diwalibulbs.services.impl;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.platform9.diwalibulbs.dto.InputBulbString;
import com.platform9.diwalibulbs.dto.MaxSparkedBulb;
import com.platform9.diwalibulbs.dto.OutputBulbList;
import com.platform9.diwalibulbs.dto.TotalInputBulbs;

public class TestClass {

	public static void main(String[] args) {
		CountPositionServiceImpl countPositionServiceImpl = new CountPositionServiceImpl();
		TotalInputBulbs bulbs = new TotalInputBulbs();
		InputBulbString bulbString = new InputBulbString();
		bulbString.setNoOfSwitch(3);
		List<Integer> set=new ArrayList<Integer>() {{
			add(0);
			add(0);
			add(0 );
			add(0);
			add(1);
			add(1 );
			add(1);
			add(0 );
			add(0);
			add(0 );
			add(0 );
			add(1 );
			add(1 );
			add(1 );
			add(1 );
			add(0 );
			add(1);
			add(0 );
			add(1);
			add(0 );
			add(1);
			add(1);
			add(0);
		}};
		bulbString.setBulbs(set);
		bulbString.setNoOfSwitch(3);
		List<InputBulbString> list = new ArrayList<InputBulbString>(1);
		list.add(bulbString);
		bulbs.setBulbString(list);
		OutputBulbList bulbList = countPositionServiceImpl.countSwitch(bulbs);
		List<MaxSparkedBulb> max = bulbList.getOutput();
		for(MaxSparkedBulb bulb : max ) {
			System.out.println(bulb.getMaxOnBulbs());
			for(Integer integer : bulb.getBulbPosition()) {
				System.out.println(integer);
			}
		}
		
	}

}
