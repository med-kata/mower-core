package com.mowltnow.mower;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private final int intValue;
    private final Character letterValue;
    private static final Map<Integer,Direction> directionByIntValueMap = new HashMap<>();

    private static final Map<Character,Direction> directionByLetterValueMap = new HashMap<>();

    static {
        for (Direction item : values()) {
            directionByIntValueMap.put(item.intValue, item);
            directionByLetterValueMap.put(item.letterValue, item);
        }
    }


    Direction(int value, Character letterValue)
    {
        this.intValue =value;
        this.letterValue= letterValue;
    }

    public static Direction getDirectionByIntValue(int passedValue) {
        return directionByIntValueMap.get(passedValue);
    }

    public static Direction getDirectionByLetterValue(Character passedValue) {
        return directionByLetterValueMap.get(passedValue);
    }
    public int getIntValue() {
        return this.intValue;
    }
}
