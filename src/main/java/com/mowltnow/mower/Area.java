package com.mowltnow.mower;


import java.util.Objects;

public record Area(int width, int length) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area area)) return false;
        return width == area.width && length == area.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }
}
