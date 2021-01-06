package dailyChallenges;

public class Day005_2021 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null && cur.next != null) {
            boolean goodValue = true;
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
                goodValue = false;
            }
            if (!goodValue) {
                cur = cur.next;
                if (prev == null) {
                    head = cur;
                    if (head == null)
                        return head;
                } else {
                    prev.next = cur;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
