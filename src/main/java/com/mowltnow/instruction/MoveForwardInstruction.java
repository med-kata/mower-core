package com.mowltnow.instruction;

import com.mowltnow.mower.Mower;

public class MoveForwardInstruction implements Instruction {

    @Override
    public void processInstruction(Mower mower) {
        {
            switch (mower.getDirection()) {
                case N:
                    if (mower.getOrdinate() < mower.getArea().getLength()) {
                        mower.setOrdinate(mower.getOrdinate() + 1);
                    }
                    break;
                case S:
                    if (mower.getOrdinate() > 0) {
                        mower.setOrdinate(mower.getOrdinate() - 1);
                    }
                    break;
                case E:
                    if (mower.getAbscissa() < mower.getArea().getWidth()) {
                        mower.setAbscissa(mower.getAbscissa() + 1);
                    }
                    break;
                case W:
                    if (mower.getAbscissa() > 0) {
                        mower.setAbscissa(mower.getAbscissa() - 1);
                    }
                    break;
            }
        }
    }
}
