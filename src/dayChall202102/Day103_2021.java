package dayChall202102;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class SolutionDay103 {
    public boolean hasCycle(ListNode head) {
        int i = 0;
        while(head != null) {
            head = head.next;
            if (i++ > 10000)
                return true;
        }
        return false;
    }
}

// Can you solve it using O(1) (i.e. constant) memory?
public class Day103_2021 {
    public static void main(String[] args) {
        SolutionDay103 solution = new SolutionDay103();
        ListNode input;

        //  Trivial:
        input = null;
        System.out.println("false == "+solution.hasCycle(input));

        //  Example 1:
        input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(0);
        input.next.next.next = new ListNode(-4);
        input.next.next.next.next = input.next;
        System.out.println("true == "+solution.hasCycle(input));

        //  Example 2:
        input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = input;
        System.out.println("true == "+solution.hasCycle(input));

        //  Example 3:
        input = new ListNode(1);
        System.out.println("false == "+solution.hasCycle(input));
    }
}
