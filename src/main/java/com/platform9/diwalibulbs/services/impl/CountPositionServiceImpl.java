package com.platform9.diwalibulbs.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.platform9.diwalibulbs.dto.InputBulbString;
import com.platform9.diwalibulbs.dto.MaxSparkedBulb;
import com.platform9.diwalibulbs.dto.OutputBulbList;
import com.platform9.diwalibulbs.dto.TotalInputBulbs;
import com.platform9.diwalibulbs.services.CountPositionService;

@Service
public class CountPositionServiceImpl implements CountPositionService {

	@Override
	public OutputBulbList countSwitch(TotalInputBulbs bulbs) {
		OutputBulbList bulbList = new OutputBulbList();
		List<MaxSparkedBulb> sparkedBulbs = new ArrayList<MaxSparkedBulb>(bulbs.getBulbString().size());
		bulbList.setOutput(sparkedBulbs);

		List<InputBulbString> bulbStrings = bulbs.getBulbString();

		for (InputBulbString bulbInput : bulbStrings) {
			MaxSparkedBulb maxSparkedBulb = new MaxSparkedBulb();
			List<Integer> positions = new ArrayList<Integer>();
			maxSparkedBulb.setBulbPosition(positions);
			// set positions and max sparked bulbs
			int noOfSwitch = bulbInput.getNoOfSwitch();
			List<Integer> bulbLines = bulbInput.getBulbs();
			int size = bulbLines.size();
			setMaxSparkedBulb(maxSparkedBulb, noOfSwitch, bulbLines, size);
			sparkedBulbs.add(maxSparkedBulb);

		}

		return bulbList;
	}

	/**
	 * 
	 * @param maxSparkedBulb
	 * @param maxAllowedSwitch
	 * @param bulbLines
	 * @param bulbLength       
	 * Algo for finding switch positions and max on bulb
	 * string is based on sliding window algorithm. We just
	 * keep maintaining a window in which max on switch
	 * allowed is the given input in question. ALgo is self
	 * explanatory. Keep track of maxWIndow, lastLongIndex
	 * where maxBulb exists. To slide , use 2 counters left
	 * and right. Running time of algo will be O(n).
	 */
	private void setMaxSparkedBulb(MaxSparkedBulb maxSparkedBulb, int maxAllowedSwitch, List<Integer> bulbLines,
			int bulbLength) {
		List<Integer> positions = maxSparkedBulb.getBulbPosition();
		int leftBulb = 0, rightBulb = 0;
		int lastLongIndex = 0, maxBulbString = 0;
		int currentOffBulb = 0;
		for (; rightBulb < bulbLength;) {
			if (currentOffBulb <= maxAllowedSwitch) {
				if (bulbLines.get(rightBulb) == 0)
					currentOffBulb++;
				rightBulb++;

			}
			if (currentOffBulb > maxAllowedSwitch) {
				if (bulbLines.get(leftBulb) == 0)
					currentOffBulb--;
				leftBulb++;

			}
			if (((rightBulb - leftBulb) > maxBulbString) && currentOffBulb <= maxAllowedSwitch) {
				maxBulbString = rightBulb - leftBulb;
				lastLongIndex = leftBulb;
			}
		}
		for (int i = 0; i < maxBulbString; i++) {
			if (bulbLines.get(lastLongIndex + i) == 0) {
				positions.add(lastLongIndex + i);
			}
		}
		maxSparkedBulb.setMaxOnBulbs(maxBulbString);
		maxSparkedBulb.setBulbPosition(positions);
	}

}
