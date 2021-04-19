package dayChall202104;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionDay401Test {
    SolutionDay401 solution;

    @BeforeEach
    void setUp() {
        solution = new SolutionDay401();
    }

    @Test
    void listNodeLen0() {
        ListNode inputHead = null;
        int actual = solution.listNodeLen(inputHead);
        assertEquals(0,actual);
    }

    @Test
    void listNodeLen1() {
        ListNode inputHead = new ListNode();
        inputHead.val = 1;
        int actual = solution.listNodeLen(inputHead);
        assertEquals(1,actual);
    }

    @Test
    void listNodeLen2() {
        ListNode inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 1;
        int actual = solution.listNodeLen(inputHead);
        assertEquals(2,actual);
    }

    @Test
    void splitPalindrome2() {
        ListNode inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        ListNode[] result = solution.splitPalindrome(inputHead, 2);
        assertEquals(1,result[0].val);
        assertEquals(2,result[1].val);
    }

    @Test
    void splitPalindrome3() {
        ListNode inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 3;
        ListNode[] result = solution.splitPalindrome(inputHead, 3);
        assertEquals(1,result[0].val);
        assertEquals(3,result[1].val);
    }

    @Test
    void splitPalindrome4() {
        ListNode inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 3;
        inputHead.next.next.next = new ListNode();
        inputHead.next.next.next.val = 4;
        ListNode[] result = solution.splitPalindrome(inputHead, 4);
        assertEquals(2,result[0].val);
        assertEquals(3,result[1].val);
        assertEquals(1,result[0].next.val);
        assertEquals(4,result[1].next.val);
    }

    @Test
    void splitPalindrome5() {
        ListNode inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 3;
        inputHead.next.next.next = new ListNode();
        inputHead.next.next.next.val = 4;
        inputHead.next.next.next.next = new ListNode();
        inputHead.next.next.next.next.val = 5;
        ListNode[] result = solution.splitPalindrome(inputHead, 4);
        assertEquals(2,result[0].val);
        assertEquals(3,result[1].val);
        assertEquals(1,result[0].next.val);
        assertEquals(4,result[1].next.val);
    }
}