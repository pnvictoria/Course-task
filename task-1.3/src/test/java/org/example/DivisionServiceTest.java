package org.example;

import org.example.division.DivisionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DivisionServiceTest {
    public DivisionService divisionService;

    public DivisionServiceTest() {
        divisionService = new DivisionService();
    }

    @Test
    void divide_getExpectedIntegers_ifInputIsNumbers() {
        String testCaseDividend78Divider4 =
                "_78|4" + System.lineSeparator() +
                " 4 |--" + System.lineSeparator() +
                " - |19" + System.lineSeparator() +
                "_38" + System.lineSeparator() +
                " 36" + System.lineSeparator() +
                " --" + System.lineSeparator() +
                "  2";
        assertEquals(testCaseDividend78Divider4, divisionService.divide(78, 4));

        String testCaseDividend123Divider123 =
                "_123|123" + System.lineSeparator() +
                " 123|-" + System.lineSeparator() +
                " ---|1" + System.lineSeparator() +
                "   0";
        assertEquals(testCaseDividend123Divider123, divisionService.divide(123, 123));

        String testCaseDividend100023Divider5 =
                "_100023|5" + System.lineSeparator() +
                " 10    |-----" + System.lineSeparator() +
                " --    |20004" + System.lineSeparator() +
                "  _0" + System.lineSeparator() +
                "   0" + System.lineSeparator() +
                "   -" + System.lineSeparator() +
                "   _0" + System.lineSeparator() +
                "    0" + System.lineSeparator() +
                "    -" + System.lineSeparator() +
                "    _2" + System.lineSeparator() +
                "     0" + System.lineSeparator() +
                "     -" + System.lineSeparator() +
                "    _23" + System.lineSeparator() +
                "     20" + System.lineSeparator() +
                "     --" + System.lineSeparator() +
                "      3";
        assertEquals(testCaseDividend100023Divider5, divisionService.divide(100023, 5));

        String testCaseDividend8435Divider23 =
                "_8435|23" + System.lineSeparator() +
                " 69  |---" + System.lineSeparator() +
                " --  |366" + System.lineSeparator() +
                "_153" + System.lineSeparator() +
                " 138" + System.lineSeparator() +
                " ---" + System.lineSeparator() +
                " _155" + System.lineSeparator() +
                "  138" + System.lineSeparator() +
                "  ---" + System.lineSeparator() +
                "   17";
        assertEquals(testCaseDividend8435Divider23, divisionService.divide(8435, 23));

        String testCaseDividend1001Divider33 =
                "_1001|33" + System.lineSeparator() +
                " 99  |--" + System.lineSeparator() +
                " --  |30" + System.lineSeparator() +
                " _11" + System.lineSeparator() +
                "  0" + System.lineSeparator() +
                "  --" + System.lineSeparator() +
                "  11";
        assertEquals(testCaseDividend1001Divider33, divisionService.divide(1001, 33));
    }

    @Test
    void divide_getExpectedIntegers_ifInputIsSameNumber() {
        String testCaseDividend123Divider123 =
                "_123|123" + System.lineSeparator() +
                " 123|-" + System.lineSeparator() +
                 " ---|1" + System.lineSeparator() +
                 "   0";
        assertEquals(testCaseDividend123Divider123, divisionService.divide(123, 123));

        String testCaseDividend656Divider656 =
                "_656|656" + System.lineSeparator() +
                " 656|-" + System.lineSeparator() +
                " ---|1" + System.lineSeparator() +
                "   0";
        assertEquals(testCaseDividend656Divider656, divisionService.divide(656, 656));
    }

    @Test
    void divide_getExpectedError_ifDividerNumberIsNull() {
        int dividend = 100;
        int divider = 0;

        Exception exception = assertThrows(RuntimeException.class, () -> divisionService.divide(dividend, divider), "Division by zero is not possible");
        assertEquals("Division by zero is not possible", exception.getMessage());
    }
}
