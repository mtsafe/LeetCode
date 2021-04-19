package dayChall202101;

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
class SolutionDay024 {
    private ListNode mergeLists(ListNode listA, ListNode listB) {
        if (listA == null)
            return listB;
        if (listB == null)
            return listA;
        ListNode nodeA = listA;
        ListNode nodeB = listB;
        ListNode nodeZ;
        if (nodeA.val < nodeB.val) {
            nodeZ = nodeA;
            nodeA = nodeA.next;
        } else {
            nodeZ = nodeB;
            nodeB = nodeB.next;
        }
        ListNode headZ = nodeZ;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val < nodeB.val) {
                nodeZ.next = nodeA;
                nodeA = nodeA.next;
            } else {
                nodeZ.next = nodeB;
                nodeB = nodeB.next;
            }
            nodeZ = nodeZ.next;
        }
        nodeZ.next = nodeA;
        while (nodeZ.next != null) {
            nodeZ = nodeZ.next;
        }
        nodeZ.next = nodeB;
        while (nodeZ.next != null) {
            nodeZ = nodeZ.next;
        }
        return headZ;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeLists(result, lists[i]);
        }
        return result;
    }
}

public class Day024_2021 {
    private static void printList(ListNode list) {
        ListNode curr = list;
        if (curr == null)
            System.out.print("[]");
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SolutionDay024 solution = new SolutionDay024();
        ListNode result;
        ListNode[] input;
        input = null;
        result = solution.mergeKLists(input);
        printList(result);

        input = new ListNode[0];
        result = solution.mergeKLists(input);
        printList(result);

        input = new ListNode[1];
        input[0] = new ListNode();
        result = solution.mergeKLists(input);
        printList(result);

        input = new ListNode[2];
        input[0] = new ListNode();
        input[1] = new ListNode();
        result = solution.mergeKLists(input);
        printList(result);

        input = new ListNode[3];
        input[0] = new ListNode();
        input[1] = new ListNode();
        input[2] = new ListNode();
        result = solution.mergeKLists(input);
        printList(result);

        input = new ListNode[4];
        input[0] = new ListNode();
        input[1] = new ListNode();
        input[2] = new ListNode(1);
        input[3] = new ListNode();
        result = solution.mergeKLists(input);
        printList(result);

        input = new ListNode[4];
        input[0] = new ListNode();
        input[1] = new ListNode(1);
        input[2] = new ListNode(1);
        input[2].next = new ListNode(2);
        input[3] = new ListNode(1);
        System.out.print("Example: ");
        printList(input[0]);
        System.out.print("Example: ");
        printList(input[1]);
        System.out.print("Example: ");
        printList(input[2]);
        System.out.print("Example: ");
        printList(input[3]);
        result = solution.mergeKLists(input);
        printList(result);

        input = new ListNode[3];
        input[0] = new ListNode(1);
        input[0].next = new ListNode(4);
        input[0].next.next = new ListNode(5);
        input[1] = new ListNode(1);
        input[1].next = new ListNode(3);
        input[1].next.next = new ListNode(4);
        input[2] = new ListNode(2);
        input[2].next = new ListNode(6);
        System.out.print("Example: ");
        printList(input[0]);
        System.out.print("Example: ");
        printList(input[1]);
        System.out.print("Example: ");
        printList(input[2]);
        result = solution.mergeKLists(input);
        printList(result);
    }
}
