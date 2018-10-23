package com.ghostmirror.TriangleChallenge;

import java.math.BigDecimal;

public class TriangleFactory {
    private TriangleFactory() {}

    public static Triangle createTriangle(int a, int b, int c) throws IllegalArgumentException {
        return createTriangle(new BigDecimal(a), new BigDecimal(b), new BigDecimal(c));
    }

    public static Triangle createTriangle(double a, double b, double c) throws IllegalArgumentException {
        return createTriangle(new BigDecimal(a), new BigDecimal(b), new BigDecimal(c));
    }

    public static Triangle createTriangle(String a, String b, String c) throws IllegalArgumentException {
        return createTriangle(new BigDecimal(a) , new BigDecimal(b), new BigDecimal(c));
    }

    public static Triangle createTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws IllegalArgumentException {
        Triangle t = new Triangle(a, b, c);
        if(t.getC().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Negative side size");
        }
        if(t.getA().compareTo(t.getB().add(t.getC())) >= 0) {
            throw new IllegalArgumentException("Not closed path");
        }
        return t;
    }
}
