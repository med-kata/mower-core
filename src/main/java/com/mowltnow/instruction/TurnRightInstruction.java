package com.mowltnow.instruction;

import com.mowltnow.mower.Direction;
import com.mowltnow.mower.Mower;

public class TurnRightInstruction implements Instruction {

    @Override
    public void processInstruction(Mower mower) {
        mower.setDirection(Direction.getDirectionByIntValue((mower.getDirection().getIntValue() + 1) % 4));
    }
}
