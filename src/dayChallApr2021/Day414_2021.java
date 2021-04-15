package dayChallApr2021;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SolutionDay414 {
    class LL414 {
        ListNode head, tail;
        LL414() {head = null; tail = null;}
        void add(ListNode node) {
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            tail.next = node;
            tail = node;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        LL414 llA = new LL414();
        LL414 llB = new LL414();
        ListNode prev, curr = head;
        while (curr != null) {
            if (curr.val < x)
                llA.add(curr);
            else
                llB.add(curr);
            prev = curr;
            curr = curr.next;
            prev.next = null;
        }
        if (llA.tail == null) return llB.head;
        llA.tail.next = llB.head;
        return llA.head;
    }
}

public class Day414_2021 {
    public static void main(String[] args) {
        SolutionDay414 solution = new SolutionDay414();
        ListNode inputH;
        int inputX;
        ListNode result;

        // Example 1
        inputH = new ListNode(1);
        inputH.next = new ListNode(4);
        inputH.next.next = new ListNode(3);
        inputH.next.next.next = new ListNode(2);
        inputH.next.next.next.next = new ListNode(5);
        inputH.next.next.next.next.next = new ListNode(2);
        inputX = 3;
        result = solution.partition(inputH, inputX);
        PrintUtils.printListNodeList(result);

        // Example 2
        inputH = new ListNode(2);
        inputH.next = new ListNode(1);
        inputX = 2;
        result = solution.partition(inputH, inputX);
        PrintUtils.printListNodeList(result);
    }
}
