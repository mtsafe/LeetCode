package dayChall202104;

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
class SolutionDay418 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return null;
        ListNode nth, last = head;
        for (int i = 1; i < n; i++) {
            if (last.next == null) return null;
            last = last.next;
        }
        nth = head;
        ListNode n_1 = null;
        while (last.next != null) {
            n_1 = nth;
            nth = nth.next;
            last = last.next;
        }
        if (nth == head) return nth.next;
        n_1.next = nth.next;
        return head;
    }
}

public class Day418_2021 {
    public static void main(String[] args) {
        SolutionDay418 solution = new SolutionDay418();
        ListNode inputH;
        int inputN;
        ListNode result;

        // Example 1
        inputH = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5)))));
        inputN = 2;
        result = solution.removeNthFromEnd(inputH, inputN);
        System.out.print("[1,2,3,5] == ");
        PrintUtils.printListNodeList(result);
        System.out.println();

        // Example 2
        inputH = new ListNode(1);
        inputN = 1;
        result = solution.removeNthFromEnd(inputH, inputN);
        System.out.print("[] == ");
        PrintUtils.printListNodeList(result);
        System.out.println();

        // Example 3
        inputH = new ListNode(1, new ListNode(2));
        inputN = 1;
        result = solution.removeNthFromEnd(inputH, inputN);
        System.out.print("[1] == ");
        PrintUtils.printListNodeList(result);
        System.out.println();
    }
}
