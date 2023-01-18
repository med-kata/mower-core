package com.mowltnow.instruction;

import com.mowltnow.mower.Mower;

public class MoveForwardInstruction implements Instruction {

    @Override
    public void processInstruction(Mower mower) {
        switch (mower.getDirection()) {
            case NORTH -> {
                if (mower.getOrdinate() < mower.getArea().length()) {
                    mower.setOrdinate(mower.getOrdinate() + 1);
                }
            }
            case SOUTH -> {
                if (mower.getOrdinate() > 0) {
                    mower.setOrdinate(mower.getOrdinate() - 1);
                }
            }
            case EAST -> {
                if (mower.getAbscissa() < mower.getArea().width()) {
                    mower.setAbscissa(mower.getAbscissa() + 1);
                }
            }
            case WEST -> {
                if (mower.getAbscissa() > 0) {
                    mower.setAbscissa(mower.getAbscissa() - 1);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + mower.getDirection());
        }
    }
}
