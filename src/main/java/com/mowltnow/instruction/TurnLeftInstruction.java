package com.mowltnow.instruction;

import com.mowltnow.mower.Direction;
import com.mowltnow.mower.Mower;

public class TurnLeftInstruction implements Instruction {

	@Override
	public void processInstruction(Mower mower) {
		mower.setDirection(Direction.getDirectionByValue((mower.getDirection().getValue() + 4 - 1) % 4));
	}

}
