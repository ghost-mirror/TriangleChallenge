package com.ghostmirror.TriangleChallenge;

import java.math.BigDecimal;

public class TriangleProperties {
    private TriangleProperties() {}

    public static TriangleType getTriangleType(Triangle t, int precision) {
        return getTriangleTypeApproximately(t.getA(), t.getB(), t.getC(), precision);
    }

    public static TriangleType getTriangleType(Triangle t) {
        return getTriangleType(t.getA(), t.getB(), t.getC());
    }

    private static TriangleType getTriangleType(BigDecimal a, BigDecimal b, BigDecimal c) {
        if(a.compareTo(c) == 0) return TriangleType.EQUILATERAL;
        if(a.compareTo(b) == 0) return TriangleType.ISOSCELES;
        if(b.compareTo(c) == 0) return TriangleType.ISOSCELES;
        return TriangleType.SCALEN;
    }

    private static TriangleType getTriangleTypeApproximately(BigDecimal a, BigDecimal b, BigDecimal c, int precision) {
        if(precision < 0) {precision = 0;}
        if(a.divide(c, precision, BigDecimal.ROUND_HALF_UP).compareTo(BigDecimal.ONE) == 0) return TriangleType.EQUILATERAL;
        if(a.divide(b, precision, BigDecimal.ROUND_HALF_UP).compareTo(BigDecimal.ONE) == 0) return TriangleType.ISOSCELES;
        if(b.divide(c, precision, BigDecimal.ROUND_HALF_UP).compareTo(BigDecimal.ONE) == 0) return TriangleType.ISOSCELES;
        return TriangleType.SCALEN;
    }
}
