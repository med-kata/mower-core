package com.mowltnow;

import com.mowltnow.mower.*;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerInstructionTest {

    private final static MowerControllerImpl mowerService = new MowerControllerImpl();


    @Test
    public void turnRightFromPosition_0_0_North() {
        Mower mower = new Mower(0, 0, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.E,
                TestHelper.createInstructionsFromCharaterList(List.of('D')), new Area(5, 5)), result);
    }


    @Test
    public void turnRightFromPosition_0_0_East() {
        Mower mower = new Mower(0, 0, Direction.E, TestHelper.createInstructionsFromCharaterList(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.S, TestHelper.createInstructionsFromCharaterList(List.of('D')), new Area(5, 5)), result);
    }

    @Test
    public void turnRightFromPosition_0_0_South() {
        Mower mower = new Mower(0, 0, Direction.S, TestHelper.createInstructionsFromCharaterList(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.W, TestHelper.createInstructionsFromCharaterList(List.of('D')), new Area(5, 5)), result);
    }

    @Test
    public void turnRightFromPosition_0_0_West() {
        Mower mower = new Mower(0, 0, Direction.W, TestHelper.createInstructionsFromCharaterList(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('D')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_North() {
        Mower mower = new Mower(0, 0, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.W, TestHelper.createInstructionsFromCharaterList(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_East() {
        Mower mower = new Mower(0, 0, Direction.E, TestHelper.createInstructionsFromCharaterList(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_West() {
        Mower mower = new Mower(0, 0, Direction.W, TestHelper.createInstructionsFromCharaterList(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.S, TestHelper.createInstructionsFromCharaterList(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_South() {
        Mower mower = new Mower(0, 0, Direction.S, TestHelper.createInstructionsFromCharaterList(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.E, TestHelper.createInstructionsFromCharaterList(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_0_0_North_AreaFiveByFive() {
        Mower mower = new Mower(0, 0, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 1, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_0_0_AreaZeroByZero() {
        Mower mower = new Mower(0, 0, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('A')),
                new Area(0, 0));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('A')), new Area(0, 0)), result);
    }

    @Test
    public void moveForwardFromPosition_0_0_AreaFiveByFiveLimitWidthDirectionEast() {
        Mower mower = new Mower(5, 0, Direction.E, TestHelper.createInstructionsFromCharaterList(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(5, 0, Direction.E, TestHelper.createInstructionsFromCharaterList(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_2_5_AreaFiveByFiveLimitLengthDirectionNorth() {
        Mower mower = new Mower(2, 5, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(2, 5, Direction.N, TestHelper.createInstructionsFromCharaterList(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_5_0_AreaFiveByFiveLimitLengthDirectionSouth() {
        Mower mower = new Mower(5, 0, Direction.S, TestHelper.createInstructionsFromCharaterList(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(5, 0, Direction.S, TestHelper.createInstructionsFromCharaterList(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void applyListOfInstructionsFromPosition_1_2_NORTH() {
        Mower mower = new Mower(1, 2, Direction.N, TestHelper.createInstructionsFromCharaterList(
                Arrays.asList('G', 'A', 'G', 'A', 'G', 'A', 'G', 'A', 'A')), new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(1, 3, Direction.N, TestHelper.createInstructionsFromCharaterList(
                Arrays.asList('G', 'A', 'G', 'A', 'G', 'A', 'G', 'A', 'A')), new Area(5, 5)), result);
    }

    @Test
    public void processInstructionsFromPosition_3_3_EAST() {
        Mower mower = new Mower(3, 3, Direction.E, TestHelper.createInstructionsFromCharaterList(
                Arrays.asList('A', 'A', 'D', 'A', 'A', 'D', 'A', 'D', 'D', 'A')), new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(5, 1, Direction.E, TestHelper.createInstructionsFromCharaterList(
                Arrays.asList('A', 'A', 'D', 'A', 'A', 'D', 'A', 'D', 'D', 'A')), new Area(5, 5)), result);
    }

    @Test
    public void processInstructionsFromInputDataFile() {
        List<Mower> result = mowerService.handelMowersInstructionsFromFile(Paths.get("src", "test", "resources", "data.txt"));

        assertEquals(new Mower(1, 3, Direction.N, null, new Area(5, 5)), result.get(0));
        assertEquals(new Mower(5, 1, Direction.E, null, new Area(5, 5)), result.get(1));
    }

    @Test(expected = MowerFileProcessingException.class)
    public void processInstructionsFromInputFileFileNotFound() {

        List<Mower> result = mowerService.handelMowersInstructionsFromFile(Paths.get("data_not_found.txt"));
    }

    @Test(expected = MowerFileProcessingException.class)
    public void processFileWithInvalidInstructions() {

        List<Mower> result = mowerService.handelMowersInstructionsFromFile(Paths.get("data_invalid_instructions.txt"));

    }

    @Test(expected = MowerFileProcessingException.class)
    public void processFileWithInvalidAreaArguments() {

        List<Mower> result = mowerService
                .handelMowersInstructionsFromFile(Paths.get("data_invalid_area_arguments.txt"));

    }

    @Test(expected = MowerFileProcessingException.class)
    public void processFileWithInvalidNegativeAreaValues() {

        List<Mower> result = mowerService.handelMowersInstructionsFromFile(Paths.get("data_invalid_area_values.txt"));

    }


    @Test(expected = MowerFileProcessingException.class)
    public void processInstructionsWithInvalidNegativeMowerPositionValues() {

        List<Mower> result = mowerService.handelMowersInstructionsFromFile(Paths.get("data_ivalid_position_negative_values.txt"));

    }

}
