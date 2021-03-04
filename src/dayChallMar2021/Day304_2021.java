package dayChallMar2021;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class SolutionDay304 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> list = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if (list.contains(tmp))
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }
}

public class Day304_2021 {
    public static void main(String[] args) {
        SolutionDay304 solution = new SolutionDay304();
        ListNode inputA, inputB;
        ListNode result;

        // Example 1
        inputA = new ListNode(4);
        inputA.next = new ListNode(1);
        inputA.next.next = new ListNode(8);
        inputA.next.next.next = new ListNode(4);
        inputA.next.next.next.next = new ListNode(5);
        inputB = new ListNode(5);
        inputB.next = new ListNode(6);
        inputB.next.next = new ListNode(1);
        inputB.next.next.next = inputA.next.next;
        result = solution.getIntersectionNode(inputA, inputB);
        if (result == null)
            System.out.println("8 == null");
        else
            System.out.println("8 == "+result.val);

        // Example 2
        inputA = new ListNode(1);
        inputA.next = new ListNode(9);
        inputA.next.next = new ListNode(1);
        inputA.next.next.next = new ListNode(2);
        inputA.next.next.next.next = new ListNode(4);
        inputB = new ListNode(3);
        inputB.next = inputA.next.next.next;
        result = solution.getIntersectionNode(inputA, inputB);
        if (result == null)
            System.out.println("2 == null");
        else
            System.out.println("2 == "+result.val);

        // Example 3
        inputA = new ListNode(2);
        inputA.next = new ListNode(6);
        inputA.next.next = new ListNode(4);
        inputB = new ListNode(1);
        inputB.next = new ListNode(5);
        result = solution.getIntersectionNode(inputA, inputB);
        if (result == null)
            System.out.println("null == null");
        else
            System.out.println("null == "+result.val);
    }
}
