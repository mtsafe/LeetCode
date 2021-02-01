package contests;

import java.util.Arrays;

class SolutionWC223 {
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        int decodedVal = first;
        int i = 0;
        result[i++] = decodedVal;
        for (int x : encoded) {
            decodedVal = x ^ decodedVal;
            result[i++] = decodedVal;
        }
        return result;
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;
        int i = 1;
        ListNode curr = head;
        ListNode a = null;
        ListNode b = curr;
        ListNode a_1 = null;
        ListNode b_1 = null;
        while (curr != null) {
            if (i <= k) {
                a_1 = a;
                a = curr;
            }
            if (i >= k && curr.next != null) {
                b_1 = b;
                b = b.next;
            }
            i++;
            curr = curr.next;
        }
        boolean dbg = true;
        if (dbg) System.out.println("{{{");
        printListNodeValues(head, a_1, a, b_1, b);
        if (dbg) printListNode(head);
        if (a == b) return head;
        if (a_1 != null)
            a_1.next = b;
        printListNodeValues(head, a_1, a, b_1, b);
        if (dbg) printListNode(head);
        if (b_1 != null)
            b_1.next = a;
        printListNodeValues(head, a_1, a, b_1, b);
        if (dbg) printListNode(head);
        ListNode tmp = a.next;
        printListNodeValues(head, a_1, a, b_1, b);
        if (dbg) printListNode(head);
        a.next = b.next;
        printListNodeValues(head, a_1, a, b_1, b);
        if (dbg) printListNode(head);
        b.next = tmp;
        printListNodeValues(head, a_1, a, b_1, b);
        if (dbg) printListNode(head);
        if (a == head)
            head = b;
        else if (b == head)
            head = a;
        printListNodeValues(head, a_1, a, b_1, b);
        if (dbg) printListNode(head);
        if (dbg) System.out.println("}}}");
        return head;
    }

    public void printValue(String varName, ListNode l) {
        System.out.print(varName + "=");
        if (l == null) {
            System.out.print("np");
        } else {
            System.out.print(l.val);
        }
        System.out.print("->");
        if (l == null || l.next == null) {
            System.out.print("np ");
        } else {
            System.out.print(l.next.val + " ");
        }
    }

    public void printListNodeValues(ListNode head, ListNode a_1, ListNode a, ListNode b_1, ListNode b) {
        printValue("head", head);
        printValue("a_1", a_1);
        printValue("a", a);
        printValue("b_1", b_1);
        printValue("b", b);
    }

    public void printListNode(ListNode head) {
        if (head == null) {
            System.err.println("[]");
            return;
        }
        ListNode curr = head;
        System.out.print("[" + curr.val);
        curr = curr.next;
        while (curr != null) {
            System.out.print(", " + curr.val);
            if (curr == curr.next ||
                    curr.next != null && curr == curr.next.next ||
                    curr.next != null && curr.next.next != null && curr == curr.next.next.next ||
                    curr.next != null && curr.next.next != null && curr.next.next.next != null && curr == curr.next.next.next.next) {
                System.out.print(", " + curr.next.val + ", " + curr.next.next.val + ", " + curr.next.next.next.val + ", " + curr.next.next.next.next.val);
                System.out.println("...Loop]");
                return;
            }
            curr = curr.next;
        }
        System.out.println("]");
    }
}

public class WeeklyContest223 {
    public static void main(String[] args) {
        SolutionWC223 solution = new SolutionWC223();
        int[] x;
        x = solution.decode(new int[]{1, 2, 3}, 1);
        System.out.println(Arrays.toString(x));
        System.out.println("----------------");
        x = solution.decode(new int[]{6, 2, 7, 3}, 4);
        System.out.println(Arrays.toString(x));
        System.out.println("================");

        ListNode head;
        head = new ListNode(1);
        solution.printListNode(head);
        head = solution.swapNodes(head, 1);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2));
        solution.printListNode(head);
        head = solution.swapNodes(head, 1);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2));
        solution.printListNode(head);
        head = solution.swapNodes(head, 2);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        solution.printListNode(head);
        head = solution.swapNodes(head, 1);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        solution.printListNode(head);
        head = solution.swapNodes(head, 2);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        solution.printListNode(head);
        head = solution.swapNodes(head, 3);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 1);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 2);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 3);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 4);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 1);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 2);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 3);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 4);
        solution.printListNode(head);
        System.out.println("----------------");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.printListNode(head);
        head = solution.swapNodes(head, 5);
        solution.printListNode(head);
        System.out.println("================");
    }
}
