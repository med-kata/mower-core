package com.mowltnow.mower;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    N(0),
    E(1),
    S(2),
    W(3);

    private int value;
    private static final Map<Integer,Direction> directionByValueMap = new HashMap<Integer, Direction>();

    static {
        for (Direction item : values()) {
            directionByValueMap.put(item.value, item);
        }
    }


    Direction(int value) {
        this.value=value;
    }

    public static Direction getDirectionByValue(int passedValue) {
        return directionByValueMap.get(passedValue);
    }

    public int getValue() {
        return this.value;
    }
}
