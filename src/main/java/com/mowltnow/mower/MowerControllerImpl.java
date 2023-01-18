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


    public List<Mower> handelMowersInstructionsFromFile(Path dataFilePath) throws MowerFileProcessingException {
        List<Mower> mowerList = initializeData(dataFilePath);
        mowerList.forEach(this::handelMowerInstructions);
        return mowerList;
    }

    public List<Mower> initializeData(Path dataFilePath) throws MowerFileProcessingException {
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

        Character mowerDirection = initialMowerPositionAsTokens.nextToken().charAt(0);
        List<Instruction> instructionsList = mapInstructionCharacterToInstructionClass(mowerInstructions.chars().mapToObj(c -> (char) c).toList());

        return new Mower(abscissaMower, ordinateMower, Direction.getDirectionByLetterValue(mowerDirection), instructionsList,
                area);
    }

    public List<Instruction> mapInstructionCharacterToInstructionClass(List<Character> mowerInstructions) {
        return mowerInstructions.stream().map(instructionChar -> switch (instructionChar) {
                    case 'D' -> new TurnRightInstruction();
                    case 'G' -> new TurnLeftInstruction();
                    case 'A' -> new MoveForwardInstruction();
                    default -> throw new IllegalArgumentException("Invalid Instruction should be A G or D");
                }
        ).toList();
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
