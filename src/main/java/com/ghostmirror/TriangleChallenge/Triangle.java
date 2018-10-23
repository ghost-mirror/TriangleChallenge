package com.ghostmirror.TriangleChallenge;

import java.math.BigDecimal;

public class Triangle {
    private final BigDecimal[] sides;

    public BigDecimal getA() {
        return sides[0];
    }

    public BigDecimal getB() {
        return sides[1];
    }

    public BigDecimal getC() {
        return sides[2];
    }

    protected Triangle(BigDecimal a, BigDecimal b, BigDecimal c) {
        sides = new BigDecimal[3];
        sides[0] = a;
        sides[1] = b;
        sides[2] = c;
        sortSides();
    }

    private void sortSides() {
        trySwapIndices(0, 1);
        trySwapIndices(0, 2);
        trySwapIndices(1, 2);
    }

    private void trySwapIndices(int idx1, int idx2) {
        if(sides[idx1].compareTo(sides[idx2]) < 0) {
            BigDecimal swp = sides[idx2];
            sides[idx2] = sides[idx1];
            sides[idx1] = swp;
        }
    }
}
