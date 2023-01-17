package com.mowltnow.mower;

import com.mowltnow.instruction.Instruction;
import com.mowltnow.instruction.MoveForwardInstruction;
import com.mowltnow.instruction.TurnLeftInstruction;
import com.mowltnow.instruction.TurnRightInstruction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MowerControllerImpl {

    public Mower handelMowerInstructions(Mower mower) {
        mower.getListOfInstructions().forEach(instruction -> instruction.processInstruction(mower));
        return mower;
    }


    public List<Mower> handelMowersInstructionsFromFile(Path dataFilePath) {
        List<Mower> mowerList = initializeData(dataFilePath);
        mowerList.forEach(this::handelMowerInstructions);
        return mowerList;
    }

    public List<Mower> initializeData(Path dataFilePath) {
        List<Mower> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath.toFile()))) {

            Area area = initializeArea(reader.readLine());

            String mowerInitialPosition;
            String mowerInstructions;

            while ((mowerInitialPosition = reader.readLine()) != null
                    && (mowerInstructions = reader.readLine()) != null) {
                Mower createdMower = createMowerFromLineData(mowerInitialPosition, mowerInstructions, area);
                result.add(createdMower);
            }
        } catch (Exception exception) {
            throw new MowerFileProcessingException("Error while handling input data file", exception);
        }
        return result;
    }

    private Mower createMowerFromLineData(String mowerInitialPosition, String mowerInstructions, Area area) {

        StringTokenizer initialMowerPositionAsTokens = new StringTokenizer(mowerInitialPosition, " ");

        int abscissaMower = Integer.parseInt(initialMowerPositionAsTokens.nextToken());
        int ordinateMower = Integer.parseInt(initialMowerPositionAsTokens.nextToken());

        if (abscissaMower < 0 || ordinateMower < 0) {
            throw new IllegalArgumentException(String.format("Invalid negative positions values : (%d , %d)", abscissaMower, ordinateMower));
        }

        String mowerDirection = initialMowerPositionAsTokens.nextToken();
        List<Instruction> instructionsList = mapInstructionCharacterToInstructionClass(mowerInstructions);

        return new Mower(abscissaMower, ordinateMower, Direction.valueOf(mowerDirection), instructionsList,
                area);
    }

    private List<Instruction> mapInstructionCharacterToInstructionClass(String mowerInstructions) {
        return mowerInstructions.chars().mapToObj(c -> (char) c).map(instruction -> {
            switch (instruction) {
                case 'D':
                    return new TurnRightInstruction();

                case 'G':
                    return new TurnLeftInstruction();

                case 'A':
                    return new MoveForwardInstruction();

                default:
                    throw new IllegalArgumentException(String.format(
                            "Invalide Instruction should be A G or D, your input was : %s", instruction));
            }
        }).toList();
    }

    private Area initializeArea(String areaDataLine) {
        StringTokenizer stringTokenizer = new StringTokenizer(areaDataLine, " ");
        if (stringTokenizer.countTokens() != 2) {
            throw new IllegalArgumentException(String.format("Invalid arguments count, should be 2, your input was %d", stringTokenizer.countTokens()));
        } else {
            int width = Integer.parseInt(stringTokenizer.nextToken());
            int length = Integer.parseInt(stringTokenizer.nextToken());
            if (width < 0 || length < 0) {
                throw new IllegalArgumentException("Area Negative Values");
            }
            return new Area(width, length);
        }
    }
}
