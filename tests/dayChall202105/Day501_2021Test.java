package dayChall202105;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day501_2021Test {
    Day501_2021 day501 = new Day501_2021();
    Day501_2021.WordFilter wf;

    @BeforeEach
    void setUp() {
    }

    @Test
    void buildHash0() {
        String[] sArr = new String[]{"dog", "#turtle", "zebra", "apple", "drone", "poodle"};
        wf = new Day501_2021.WordFilter(sArr);
        List<String> list = new ArrayList<>();
        list.add("#turtle");
        list.add("apple");
        list.add("dog");
        list.add("drone");
        list.add("poodle");
        list.add("zebra");
        HashMap<Character, Integer> hash = wf.buildDictHash(list);
        assertEquals(0, hash.get('#'));
        assertEquals(1, hash.get('a'));
        assertEquals(-1, hash.get('b'));
        assertEquals(-1, hash.get('c'));
        assertEquals(2, hash.get('d'));
        assertEquals(-1, hash.get('e'));
        assertEquals(-1, hash.get('f'));
        assertEquals(-1, hash.get('g'));
        assertEquals(-1, hash.get('h'));
        assertEquals(-1, hash.get('i'));
        assertEquals(-1, hash.get('j'));
        assertEquals(-1, hash.get('k'));
        assertEquals(-1, hash.get('l'));
        assertEquals(-1, hash.get('m'));
        assertEquals(-1, hash.get('n'));
        assertEquals(-1, hash.get('o'));
        assertEquals(4, hash.get('p'));
        assertEquals(-1, hash.get('q'));
        assertEquals(-1, hash.get('r'));
        assertEquals(-1, hash.get('s'));
        assertEquals(-1, hash.get('t'));
        assertEquals(-1, hash.get('u'));
        assertEquals(-1, hash.get('v'));
        assertEquals(-1, hash.get('w'));
        assertEquals(-1, hash.get('x'));
        assertEquals(-1, hash.get('y'));
        assertEquals(5, hash.get('z'));
    }
}