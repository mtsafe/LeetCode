package dayChallApr2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionDay403Test {
    SolutionDay403 solution;

    @BeforeEach
    void setUp() {
        solution = new SolutionDay403();
    }

    @Test
    void truncateLVPempty() {
        String inputS = "";
        String actual = solution.truncateLVP(inputS);
        assertEquals("", actual);
    }

    @Test
    void truncateLVPnull() {
        String inputS = null;
        String actual = solution.truncateLVP(inputS);
        assertEquals("", actual);
    }

    @Test
    void truncateLVP2() {
        String inputS = "()";
        String actual = solution.truncateLVP(inputS);
        assertEquals("()", actual);
    }

    @Test
    void truncateLVP2A() {
        String inputS = ")()";
        String actual = solution.truncateLVP(inputS);
        assertEquals("()", actual);
    }

    @Test
    void truncateLVP2B() {
        String inputS = "()(";
        String actual = solution.truncateLVP(inputS);
        assertEquals("()", actual);
    }

    @Test
    void truncateLVP3A() {
        String inputS = "(()";
        String actual = solution.truncateLVP(inputS);
        assertEquals("(()", actual);
    }

    @Test
    void truncateLVP3B() {
        String inputS = "())";
        String actual = solution.truncateLVP(inputS);
        assertEquals("())", actual);
    }

    @Test
    void truncateLVP5A() {
        String inputS = ")()())";
        String actual = solution.truncateLVP(inputS);
        assertEquals("()())", actual);
    }


    @Test
    void validLengthempty() {
        String inputS = "";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(0, actual.endsAt);
        assertEquals(0, actual.maxLength);
    }

    @Test
    void validLengthnull() {
        String inputS = null;
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(0, actual.endsAt);
        assertEquals(0, actual.maxLength);
    }

    @Test
    void validLength2() {
        String inputS = "()";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(2, actual.endsAt);
        assertEquals(2, actual.maxLength);
    }

    @Test
    void validLength3A() {
        String inputS = "(()";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(3, actual.endsAt);
        assertEquals(2, actual.maxLength);
    }

    @Test
    void validLength3B() {
        String inputS = "())";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(2, actual.endsAt);
        assertEquals(2, actual.maxLength);
    }

    @Test
    void validLength5A() {
        String inputS = "()())";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(4, actual.endsAt);
        assertEquals(4, actual.maxLength);
    }

    @Test
    void validLength5B() {
        String inputS = "()(()";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(5, actual.endsAt);
        assertEquals(2, actual.maxLength);
    }

    @Test
    void validLength6() {
        String inputS = "()(())";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(6, actual.endsAt);
        assertEquals(6, actual.maxLength);
    }

    @Test
    void validLength8B() {
        String inputS = "()(()(()";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(8, actual.endsAt);
        assertEquals(2, actual.maxLength);
    }

    @Test
    void validLength9() {
        String inputS = "()(()(())";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(9, actual.endsAt);
        assertEquals(6, actual.maxLength);
    }

    @Test
    void validLength10() {
        String inputS = "()(()(()))";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(10, actual.endsAt);
        assertEquals(10, actual.maxLength);
    }

    @Test
    void validLength11() {
        String inputS = "()()()((())";
        SolutionDay403.ValidLengthObj actual = solution.validLength(inputS);
        assertEquals(11, actual.endsAt);
        assertEquals(6, actual.maxLength);
    }
}