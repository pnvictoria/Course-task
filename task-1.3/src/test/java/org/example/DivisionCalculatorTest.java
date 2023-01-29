package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DivisionCalculatorTest {
    DivisionCalculator calculator = new DivisionCalculator();

    @Test
    void makeDivisionShouldThrowExceptionWhenDivisorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDividendLessDivisor() {
        String expected = "5|10\n" +
                " |-\n" +
                " |0\n";
        assertEquals(expected, calculator.divide(5, 10));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDividendIsZero() {
        String expected = "0|10\n" +
                " |-\n" +
                " |0\n";
        assertEquals(expected, calculator.divide(0, 10));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDivisorIsOne() {
        String expected = "_55|1\n" +
                " 5 |--\n" +
                " - |55\n" +
                " _5\n" +
                "  5\n" +
                "  -\n" +
                "  0\n";
        assertEquals(expected, calculator.divide(55, 1));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenResidueIsZero() {
        String expected = "_125|5\n" +
                " 10 |--\n" +
                " -- |25\n" +
                " _25\n" +
                "  25\n" +
                "  --\n" +
                "   0\n";
        assertEquals(expected, calculator.divide(125, 5));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDividendIsNegative() {
        String expected = "_123|5\n" +
                " 10 |--\n" +
                " -- |24\n" +
                " _23\n" +
                "  20\n" +
                "  --\n" +
                "   3\n";
        assertEquals(expected, calculator.divide(-123, 5));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDivisorIsNegative() {
        String expected = "_123|5\n" +
                " 10 |--\n" +
                " -- |24\n" +
                " _23\n" +
                "  20\n" +
                "  --\n" +
                "   3\n";
        assertEquals(expected, calculator.divide(123, -5));
    }
    @Test
    void makeDivisionShouldCorrectOutputWhenResidueIsNotZero() {
        String expected = "_123|5\n" +
                " 10 |--\n" +
                " -- |24\n" +
                " _23\n" +
                "  20\n" +
                "  --\n" +
                "   3\n";
        assertEquals(expected, calculator.divide(123, 5));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDivisorEqualsDividend() {
        String expected = "_123|123\n" +
                " 123|-\n" +
                " ---|1\n" +
                "   0\n";
        assertEquals(expected, calculator.divide(123, 123));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDividendIsBigNumber() {
        String expected = "_78945|4\n" +
                " 4    |-----\n" +
                " -    |19736\n" +
                "_38\n" +
                " 36\n" +
                " --\n" +
                " _29\n" +
                "  28\n" +
                "  --\n" +
                "  _14\n" +
                "   12\n" +
                "   --\n" +
                "   _25\n" +
                "    24\n" +
                "    --\n" +
                "     1\n";
        assertEquals(expected, calculator.divide(78945, 4));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDividendContainsFewZeroDigitsInside() {
        String expected = "_100023|5\n" +
                " 10    |-----\n" +
                " --    |20004\n" +
                "    _23\n" +
                "     20\n" +
                "     --\n" +
                "      3\n";
        assertEquals(expected, calculator.divide(100023, 5));
    }

    @Test
    void makeDivisionShouldCorrectOutputWhenDividendContainsFewZeroDigitsAtTheEnd() {
        String expected = "_5000|10\n" +
                " 50  |---\n" +
                " --  |500\n" +
                "    0\n";
        assertEquals(expected, calculator.divide(5000, 10));
    }
}
