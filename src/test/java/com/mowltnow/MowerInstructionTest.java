package com.mowltnow;

import com.mowltnow.mower.*;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerInstructionTest {

    private final MowerControllerImpl mowerService = new MowerControllerImpl();


    @Test
    public void turnRightFromPosition_0_0_North() {
        Mower mower = new Mower(0, 0, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.EAST,
                mowerService.mapInstructionCharacterToInstructionClass(List.of('D')), new Area(5, 5)), result);
    }


    @Test
    public void turnRightFromPosition_0_0_East() {
        Mower mower = new Mower(0, 0, Direction.EAST, mowerService.mapInstructionCharacterToInstructionClass(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.SOUTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('D')), new Area(5, 5)), result);
    }

    @Test
    public void turnRightFromPosition_0_0_South() {
        Mower mower = new Mower(0, 0, Direction.SOUTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.WEST, mowerService.mapInstructionCharacterToInstructionClass(List.of('D')), new Area(5, 5)), result);
    }

    @Test
    public void turnRightFromPosition_0_0_West() {
        Mower mower = new Mower(0, 0, Direction.WEST, mowerService.mapInstructionCharacterToInstructionClass(List.of('D')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('D')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_North() {
        Mower mower = new Mower(0, 0, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.WEST, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_East() {
        Mower mower = new Mower(0, 0, Direction.EAST, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_West() {
        Mower mower = new Mower(0, 0, Direction.WEST, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.SOUTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void turnLeftFromPosition_0_0_South() {
        Mower mower = new Mower(0, 0, Direction.SOUTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.EAST, mowerService.mapInstructionCharacterToInstructionClass(List.of('G')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_0_0_North_AreaFiveByFive() {
        Mower mower = new Mower(0, 0, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 1, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_0_0_AreaZeroByZero() {
        Mower mower = new Mower(0, 0, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')),
                new Area(0, 0));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(0, 0, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')), new Area(0, 0)), result);
    }

    @Test
    public void moveForwardFromPosition_0_0_AreaFiveByFiveLimitWidthDirectionEast() {
        Mower mower = new Mower(5, 0, Direction.EAST, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(5, 0, Direction.EAST, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_2_5_AreaFiveByFiveLimitLengthDirectionNorth() {
        Mower mower = new Mower(2, 5, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(2, 5, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void moveForwardFromPosition_5_0_AreaFiveByFiveLimitLengthDirectionSouth() {
        Mower mower = new Mower(5, 0, Direction.SOUTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')),
                new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(5, 0, Direction.SOUTH, mowerService.mapInstructionCharacterToInstructionClass(List.of('A')), new Area(5, 5)), result);
    }

    @Test
    public void applyListOfInstructionsFromPosition_1_2_NORTH() {
        Mower mower = new Mower(1, 2, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(
                Arrays.asList('G', 'A', 'G', 'A', 'G', 'A', 'G', 'A', 'A')), new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(1, 3, Direction.NORTH, mowerService.mapInstructionCharacterToInstructionClass(
                Arrays.asList('G', 'A', 'G', 'A', 'G', 'A', 'G', 'A', 'A')), new Area(5, 5)), result);
    }

    @Test
    public void processInstructionsFromPosition_3_3_EAST() {
        Mower mower = new Mower(3, 3, Direction.EAST, mowerService.mapInstructionCharacterToInstructionClass(
                Arrays.asList('A', 'A', 'D', 'A', 'A', 'D', 'A', 'D', 'D', 'A')), new Area(5, 5));
        Mower result = mowerService.handelMowerInstructions(mower);
        assertEquals(new Mower(5, 1, Direction.EAST, mowerService.mapInstructionCharacterToInstructionClass(
                Arrays.asList('A', 'A', 'D', 'A', 'A', 'D', 'A', 'D', 'D', 'A')), new Area(5, 5)), result);
    }

    @Test
    public void processInstructionsFromInputDataFile() throws MowerFileProcessingException {
        List<Mower> result = mowerService.handelMowersInstructionsFromFile(Paths.get("src", "test", "resources", "data.txt"));

        assertEquals(new Mower(1, 3, Direction.NORTH, null, new Area(5, 5)), result.get(0));
        assertEquals(new Mower(5, 1, Direction.EAST, null, new Area(5, 5)), result.get(1));
    }

    @Test(expected = MowerFileProcessingException.class)
    public void processInstructionsFromInputFileFileNotFound() throws MowerFileProcessingException {

        mowerService.handelMowersInstructionsFromFile(Paths.get("data_not_found.txt"));
    }

    @Test(expected = MowerFileProcessingException.class)
    public void processFileWithInvalidInstructions() throws MowerFileProcessingException {

        mowerService.handelMowersInstructionsFromFile(Paths.get("data_invalid_instructions.txt"));

    }

    @Test(expected = MowerFileProcessingException.class)
    public void processFileWithInvalidAreaArguments() throws MowerFileProcessingException {

        mowerService
                .handelMowersInstructionsFromFile(Paths.get("data_invalid_area_arguments.txt"));

    }

    @Test(expected = MowerFileProcessingException.class)
    public void processFileWithInvalidNegativeAreaValues() throws MowerFileProcessingException {

        mowerService.handelMowersInstructionsFromFile(Paths.get("data_invalid_area_values.txt"));

    }


    @Test(expected = MowerFileProcessingException.class)
    public void processInstructionsWithInvalidNegativeMowerPositionValues() throws MowerFileProcessingException {

        mowerService.handelMowersInstructionsFromFile(Paths.get("data_ivalid_position_negative_values.txt"));

    }

}
