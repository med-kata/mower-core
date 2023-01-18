package com.mowltnow.mower;

import com.mowltnow.instruction.Instruction;

import java.util.List;
import java.util.Objects;

public class Mower {

    private int abscissa;
    private int ordinate;
    private Direction direction;
    private final List<Instruction> listOfInstructions;
    private final Area area;

    public Mower(int abscissa, int ordinate, Direction direction, List<Instruction> listOfInstructions, Area area) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
        this.direction = direction;
        this.listOfInstructions = listOfInstructions;
        this.area = area;
    }

    public int getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(int abscissa) {
        this.abscissa = abscissa;
    }

    public int getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(int ordinate) {
        this.ordinate = ordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Instruction> getListOfInstructions() {
        return listOfInstructions;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mower mower)) return false;
        return abscissa == mower.abscissa
                && ordinate == mower.ordinate
                && direction == mower.direction
                && area.equals(mower.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abscissa, ordinate, direction, listOfInstructions, area);
    }
}
