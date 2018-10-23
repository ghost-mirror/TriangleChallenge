import org.junit.Test;
import static org.junit.Assert.assertSame;

import com.ghostmirror.TriangleChallenge.*;

import java.math.BigDecimal;


public class TestTriangleChallenge {
    @Test(expected = IllegalArgumentException.class)
    public void int_illegal_1() {
        TriangleFactory.createTriangle(-1,3,4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void int_illegal_2() {
        TriangleFactory.createTriangle(1,2,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void int_illegal_3() {
        TriangleFactory.createTriangle(111,5,333);
    }

    @Test(expected = IllegalArgumentException.class)
    public void str_illegal_1() {
        TriangleFactory.createTriangle("5#","5","5");
    }

    @Test
    public void int_SCALEN_1() {
        Triangle t = TriangleFactory.createTriangle(2,3,4);
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.SCALEN);
    }
    @Test
    public void int_ISOSCELES_1() {
        Triangle t = TriangleFactory.createTriangle(4,3,4);
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.ISOSCELES);
    }
    @Test
    public void int_EQUILATERAL_1() {
        Triangle t = TriangleFactory.createTriangle(111111,111111,111111);
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.EQUILATERAL);
    }

    @Test
    public void double_SCALEN_1() {
        Triangle t = TriangleFactory.createTriangle(0.333333301,0.333333302,0.333333303);
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.SCALEN);
    }
    @Test
    public void double_ISOSCELES_1() {
        Triangle t = TriangleFactory.createTriangle(0.333333301,0.333333302,0.333333302);
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.ISOSCELES);
    }
    @Test
    public void double_EQUILATERAL_1() {
        Triangle t = TriangleFactory.createTriangle(1,0.9999999999,1);
        assertSame(TriangleProperties.getTriangleType(t, 9), TriangleType.EQUILATERAL);
    }

    @Test
    public void str_SCALEN_1() {
        Triangle t = TriangleFactory.createTriangle(
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973161",
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973162",
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973163"
        );
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.SCALEN);
    }

    @Test
    public void str_ISOSCELES_1() {
        Triangle t = TriangleFactory.createTriangle(
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973161",
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973162",
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973161"
        );
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.ISOSCELES);
    }

    @Test
    public void str_EQUILATERAL_1() {
        Triangle t = TriangleFactory.createTriangle(
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973168",
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973168",
                "234354569876878765767354169894948964657567657567.78780679670897680967867554545777781897843518949884945435498498465654894973168"
        );
        assertSame(TriangleProperties.getTriangleType(t), TriangleType.EQUILATERAL);
    }



    @Test
    public void str_SCALEN_2() {
        Triangle t = TriangleFactory.createTriangle(
                "12.3456789001",
                "12.3456789005",
                "12.3456789009"
        );
        assertSame(TriangleProperties.getTriangleType(t, 11), TriangleType.SCALEN);
    }

    @Test
    public void str_ISOSCELES_2() {
        Triangle t = TriangleFactory.createTriangle(
                "12.3456789001",
                "12.3456789005",
                "12.3456789009"
        );
        assertSame(TriangleProperties.getTriangleType(t, 10), TriangleType.ISOSCELES);
    }

    @Test
    public void str_EQUILATERAL_2() {
        Triangle t = TriangleFactory.createTriangle(
                "123456789.001",
                "123456789.005",
                "123456789.007"
        );
        assertSame(TriangleProperties.getTriangleType(t, 10), TriangleType.EQUILATERAL);
    }

    @Test
    public void big_EQUILATERAL_1() {
        BigDecimal a = new BigDecimal("123456789.001");
        BigDecimal b = new BigDecimal("123456789.005");
        BigDecimal c = new BigDecimal("123456789.007");
        Triangle t = TriangleFactory.createTriangle(a, b, c);
        assertSame(TriangleProperties.getTriangleType(t, 10), TriangleType.EQUILATERAL);
    }
}
