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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MowerControllerImpl {

    private static Logger logger = Logger.getLogger("com.mowltnow.mower.MowerControllerImpl");
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

            String mowerInitialPosition, mowerInstructions;

            while ((mowerInitialPosition = reader.readLine()) != null
                    && (mowerInstructions = reader.readLine()) != null) {
                Mower createdMower = createMowerFromLineData(mowerInitialPosition, mowerInstructions, area);
                result.add(createdMower);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Problem occured while handling mower data file" + e.getMessage());
            throw new RuntimeException("Problem occured while handling mower data file" + e.getMessage());
        }
        return result;
    }

    private Mower createMowerFromLineData(String mowerInitialPosition, String mowerInstructions, Area area) {

        StringTokenizer initialMowerPositionAsTokens = new StringTokenizer(mowerInitialPosition, " ");

        int abscissaMower = Integer.parseInt(initialMowerPositionAsTokens.nextToken());
        int ordinateMower = Integer.parseInt(initialMowerPositionAsTokens.nextToken());

        if (abscissaMower < 0 || ordinateMower<0) {
            throw new RuntimeException("Invalide negative positions values");
        }

        String mowerDirection = initialMowerPositionAsTokens.nextToken();
        List<Instruction> instructionsList = mapInstructionCharacterToInstructionClass(mowerInstructions);

        Mower mower = new Mower(abscissaMower, ordinateMower, Direction.valueOf(mowerDirection), instructionsList ,
                area);

        return mower;
    }

    private List<Instruction> mapInstructionCharacterToInstructionClass(String mowerInstructions) {
        List<Instruction> instructionsList = mowerInstructions.chars().mapToObj(c -> (char) c).map(instruction -> {
            switch (instruction) {
                case 'D':
                    return new TurnRightInstruction();

                case 'G':
                    return new TurnLeftInstruction();

                case 'A':
                    return new MoveForwardInstruction();

                default:
                    throw new RuntimeException("Invalide Instruction should be A G or D");
            }
        }).collect(Collectors.toList());
        return instructionsList;
    }

    private Area initializeArea(String areaDataLine) {
        StringTokenizer stringTokenizer = new StringTokenizer(areaDataLine, " ");
        if (stringTokenizer.countTokens() != 2) {
            throw new RuntimeException("Error initializing Area Data, should be 2 integers");
        } else {
            try {
                int width = Integer.parseInt(stringTokenizer.nextToken());
                int length = Integer.parseInt(stringTokenizer.nextToken());
                if (width<0 || length <0) {
                    throw new RuntimeException("Area Negative Values");
                }
                return new Area(width,length);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Invalid area data : parsing integer fails" + e.getMessage());
                throw new RuntimeException("Invalid area data : parsing integer fails\"+e.getMessage()");
            }
        }
    }
}
