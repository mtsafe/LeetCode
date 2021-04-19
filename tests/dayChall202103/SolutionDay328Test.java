package dayChall202103;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SolutionDay328Test {
    SolutionDay328 solution;

    @BeforeEach
    void init() {
        solution = new SolutionDay328();
    }
    @Test
    void digits2String0() {
        int[] input = new int[]{1,0,0,0,0,0,0,0,0,0};
        String result = solution.digits2String(input);
        assertEquals("0", result);
    }
    @Test
    void digits2String011222() {
        int[] input = new int[]{1,2,3,0,0,0,0,0,0,0};
        String result = solution.digits2String(input);
        assertEquals("011222", result);
    }
    @Test
    void digits2String016() {
        int[] input = new int[]{1,1,0,0,0,0,1,0,0,0};
        String result = solution.digits2String(input);
        assertEquals("016", result);
    }
    @Test
    void string2Hasha() {
        String input = "a";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, result.get('a'));
    }
    @Test
    void string2Hashzero() {
        String input = "zero";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, result.get('z'));
        assertEquals(1, result.get('e'));
        assertEquals(1, result.get('r'));
        assertEquals(1, result.get('o'));
    }
    @Test
    void string2Hashzeroone() {
        String input = "zeroone";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, result.get('z'));
        assertEquals(2, result.get('e'));
        assertEquals(1, result.get('r'));
        assertEquals(2, result.get('o'));
        assertEquals(1, result.get('n'));
    }
    @Test
    void string2Hashowoztneoer() {
        String input = "owoztneoer";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, result.get('z'));
        assertEquals(2, result.get('e'));
        assertEquals(1, result.get('r'));
        assertEquals(3, result.get('o'));
        assertEquals(1, result.get('n'));
        assertEquals(1, result.get('t'));
        assertEquals(1, result.get('w'));
    }
    @Test
    void takezero() {
        String input = "zero";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, result.get('z'));
        assertEquals(1, result.get('e'));
        assertEquals(1, result.get('r'));
        assertEquals(1, result.get('o'));
        assertEquals(1, solution.take(result, 'z', "zero"));
        assertFalse(result.containsKey('z'));
        assertFalse(result.containsKey('e'));
        assertFalse(result.containsKey('r'));
        assertFalse(result.containsKey('o'));
    }
    @Test
    void takezerotwo() {
        String input = "zerotwo";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, result.get('z'));
        assertEquals(1, result.get('e'));
        assertEquals(1, result.get('r'));
        assertEquals(2, result.get('o'));
        assertEquals(1, result.get('t'));
        assertEquals(1, result.get('w'));
        assertEquals(1, solution.take(result, 'z', "zero"));
        assertFalse(result.containsKey('z'));
        assertFalse(result.containsKey('e'));
        assertFalse(result.containsKey('r'));
        assertEquals(1, result.get('o'));
        assertEquals(1, result.get('t'));
        assertEquals(1, result.get('w'));
        assertEquals(1, solution.take(result, 'w', "two"));
        assertFalse(result.containsKey('z'));
        assertFalse(result.containsKey('e'));
        assertFalse(result.containsKey('r'));
        assertFalse(result.containsKey('o'));
        assertFalse(result.containsKey('t'));
        assertFalse(result.containsKey('w'));
    }
    @Test
    void allzero() {
        String input = "zero";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, solution.take(result, 'z', "zero"));
        assertEquals(0, solution.take(result, 'w', "two"));
        assertEquals(0, solution.take(result, 'x', "six"));
        assertEquals(0, solution.take(result, 's', "seven"));
        assertEquals(0, solution.take(result, 'v', "five"));
        assertEquals(0, solution.take(result, 'f', "four"));
        assertEquals(0, solution.take(result, 'o', "one"));
        assertEquals(0, solution.take(result, 'r', "three"));
        assertEquals(0, solution.take(result, 'g', "eight"));
        assertEquals(0, solution.take(result, 'e', "nine"));
    }
    @Test
    void allzerotwo() {
        String input = "zerotwo";
        HashMap<Character,Integer> result = solution.string2Hash(input);
        assertEquals(1, solution.take(result, 'z', "zero"));
        assertEquals(1, solution.take(result, 'w', "two"));
        assertEquals(0, solution.take(result, 'x', "six"));
        assertEquals(0, solution.take(result, 's', "seven"));
        assertEquals(0, solution.take(result, 'v', "five"));
        assertEquals(0, solution.take(result, 'f', "four"));
        assertEquals(0, solution.take(result, 'o', "one"));
        assertEquals(0, solution.take(result, 'r', "three"));
        assertEquals(0, solution.take(result, 'g', "eight"));
        assertEquals(0, solution.take(result, 'e', "nine"));
    }
}