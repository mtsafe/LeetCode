package dayChall202103;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionDay331Test {
    SolutionDay331 solution;

    @BeforeEach
    void setUp() {
        solution = new SolutionDay331();
    }

    @Test
    void newWorkingArraya() {
        String inputStr = "a";
        char[] expected = "a".toCharArray();
        char[] actual = solution.newWorkingArray(inputStr);
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    void newWorkingArrayasdf() {
        String inputStr = "asdf";
        char[] expected = "asdf".toCharArray();
        char[] actual = solution.newWorkingArray(inputStr);
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    void newWorkingArrayempty() {
        String inputStr = "";
        char[] expected = "".toCharArray();
        char[] actual = solution.newWorkingArray(inputStr);
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    void unstampa() {
        char[] str = "a".toCharArray();
        char[] expected = "?".toCharArray();
        solution.unstamp(str, 0, 1);
        assertTrue(Arrays.equals(expected, str));
    }

    @Test
    void unstampasdf() {
        char[] str = "asdf".toCharArray();
        char[] expected = "????".toCharArray();
        solution.unstamp(str, 0, 4);
        assertTrue(Arrays.equals(expected, str));
    }


    @Test
    void unstampasxxdf() {
        char[] str = "asxxdf".toCharArray();
        char[] expected = "as??df".toCharArray();
        solution.unstamp(str, 2, 2);
        assertTrue(Arrays.equals(expected, str));
    }

    @Test
    void unstampempty() {
        char[] str = "".toCharArray();
        char[] expected = "".toCharArray();
        solution.unstamp(str, 0, 0);
        assertTrue(Arrays.equals(expected, str));
    }

    @Test
    void isStampedAt0() {
        char[] work = "a".toCharArray();
        char[] stamp = "a".toCharArray();
        int position = 0;
        boolean actual = solution.isStampedAt(work, stamp, position);
        assertTrue(actual);
    }

    @Test
    void isStampedAt1T() {
        char[] work = "ab".toCharArray();
        char[] stamp = "b".toCharArray();
        int position = 1;
        boolean actual = solution.isStampedAt(work, stamp, position);
        assertTrue(actual);
    }

    @Test
    void isStampedAt1F() {
        char[] work = "ab".toCharArray();
        char[] stamp = "a".toCharArray();
        int position = 1;
        boolean actual = solution.isStampedAt(work, stamp, position);
        assertFalse(actual);
    }

    @Test
    void isStampedAtTooBig() {
        char[] work = "ab".toCharArray();
        char[] stamp = "a".toCharArray();
        int position = 2;
        boolean actual = solution.isStampedAt(work, stamp, position);
        assertFalse(actual);
    }

    @Test
    void lastStampingsa() {
        char[] stamp = "a".toCharArray();
        char[] work = "a".toCharArray();
        int expected = 0;
        List<Integer> result = solution.lastStampings(stamp, work);
        assertEquals(expected, (int) result.get(0));
    }

    @Test
    void lastStampingsempty() {
        char[] stamp = "".toCharArray();
        char[] work = "".toCharArray();
        int expected = 0;
        List<Integer> result = solution.lastStampings(stamp, work);
        assertEquals(expected, result.size());
    }
}