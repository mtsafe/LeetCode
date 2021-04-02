package dayChallApr2021;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SolutionDay401 {
    int listNodeLen(ListNode head) {
        if (head == null) return 0;
        ListNode tmp = head;
        int cnt = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            cnt++;
        }
        return cnt;
    }

    ListNode[] splitPalindrome(ListNode head, int listLen) {
        int half = listLen / 2;
        ListNode tmp1 = null, tmp2 = head, tmp3 = tmp2.next;
        for (int i = 0; i < half; i++) {
            tmp2.next = tmp1;
            tmp1 = tmp2;
            tmp2 = tmp3;
            tmp3 = tmp3.next;
        }
        ListNode[] halves = new ListNode[2];
        halves[0] = tmp1;
        if (listLen % 2 == 0)
            halves[1] = tmp2;
        else
            halves[1] = tmp3;
        return halves;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int listLen = listNodeLen(head);
        if (listLen <= 1) return true;
        ListNode[] parts = splitPalindrome(head, listLen);
        while (parts[0] != null) {
            if (parts[0].val != parts[1].val)
                return false;
            parts[0] = parts[0].next;
            parts[1] = parts[1].next;
        }
        return true;
    }
}

public class Day401_2021 {
    public static void main(String[] args) {
        SolutionDay401 solution = new SolutionDay401();
        ListNode inputHead;
        boolean result;

        // Example 1
        inputHead = null;
        result = solution.isPalindrome(inputHead);
        System.out.println("1 true == "+result);

        // Example 2
        inputHead = new ListNode();
        inputHead.val = 1;
        result = solution.isPalindrome(inputHead);
        System.out.println("2 true == "+result);

        // Example 3
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 1;
        result = solution.isPalindrome(inputHead);
        System.out.println("3 true == "+result);

        // Example 4
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 1;
        result = solution.isPalindrome(inputHead);
        System.out.println("4 true == "+result);

        // Example 5
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 2;
        inputHead.next.next.next = new ListNode();
        inputHead.next.next.next.val = 1;
        result = solution.isPalindrome(inputHead);
        System.out.println("5 true == "+result);

        // Example 6
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 3;
        inputHead.next.next.next = new ListNode();
        inputHead.next.next.next.val = 2;
        inputHead.next.next.next.next = new ListNode();
        inputHead.next.next.next.next.val = 1;
        result = solution.isPalindrome(inputHead);
        System.out.println("6 true == "+result);

        // Example 7
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        result = solution.isPalindrome(inputHead);
        System.out.println("7 false == "+result);

        // Example 8
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 2;
        result = solution.isPalindrome(inputHead);
        System.out.println("8 false == "+result);

        // Example 9
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 3;
        inputHead.next.next.next = new ListNode();
        inputHead.next.next.next.val = 1;
        result = solution.isPalindrome(inputHead);
        System.out.println("9 false == "+result);

        // Example 10
        inputHead = new ListNode();
        inputHead.val = 1;
        inputHead.next = new ListNode();
        inputHead.next.val = 2;
        inputHead.next.next = new ListNode();
        inputHead.next.next.val = 2;
        inputHead.next.next.next = new ListNode();
        inputHead.next.next.next.val = 3;
        inputHead.next.next.next.next = new ListNode();
        inputHead.next.next.next.next.val = 1;
        result = solution.isPalindrome(inputHead);
        System.out.println("10 false == "+result);
    }
}
