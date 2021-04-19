package dayChall202101;

public class Day004_2021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail;
        if (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                result = l2;
                l2 = l2.next;
            } else {
                result = l1;
                l1 = l1.next;
            }
        } else if (l1 != null) {
            result = l1;
            l1 = l1.next;
        } else if (l2 != null) {
            result = l2;
            l2 = l2.next;
        } else {
            return result;
        }
        tail = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
            l1 = null;
        } else if (l2 != null) {
            tail.next = l2;
            l2 = null;
        }
        return result;
    }
}
