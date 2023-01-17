package com.mowltnow.instruction;

import com.mowltnow.mower.Direction;
import com.mowltnow.mower.Mower;

public class TurnRightInstruction implements Instruction {

    @Override
    public void processInstruction(Mower mower) {
        mower.setDirection(Direction.getDirectionByValue((mower.getDirection().getValue() + 1) % 4));
    }
}
