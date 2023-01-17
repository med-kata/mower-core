package com.mowltnow;

import com.mowltnow.instruction.Instruction;
import com.mowltnow.instruction.MoveForwardInstruction;
import com.mowltnow.instruction.TurnLeftInstruction;
import com.mowltnow.instruction.TurnRightInstruction;

import java.util.List;
import java.util.stream.Collectors;

public class TestHelper {
    public static List<Instruction> createInstructionsFromCharaterList(List<Character> instructionAsChar) {
            return instructionAsChar.stream().map(instructionChar -> {
                switch (instructionChar) {
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
    }
}
