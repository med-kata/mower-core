package com.mowltnow;

import com.mowltnow.mower.Area;
import com.mowltnow.mower.Direction;
import com.mowltnow.mower.Mower;
import com.mowltnow.mower.MowerControllerImpl;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MowerInstructionTest {

    private final static MowerControllerImpl mowerService = new MowerControllerImpl();


    @Test
    public void instructionTurnRightFromPosition_0_0_North() {
        Mower mower = new Mower(0, 0, Direction.NORTH, TestHelper.createInstructionsFromCharaterList(Arrays.asList('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.EAST, TestHelper.createInstructionsFromCharaterList(Arrays.asList('D')), new Area(5, 5)), result);
    }

}
