package dayChallJan2021;

import java.math.BigInteger;

class SolutionDay012 {
    protected ListNode encodeNode(BigInteger a) {
        ListNode head = new ListNode();
        ListNode curr = head;
        curr.val = 0;
        String s = a.toString();
        for (int i = 0; !s.equals(""); i++) {
            curr.val = Character.getNumericValue(s.charAt(s.length() - 1));
            s = s.substring(0, s.length() - 1);
            if (!s.equals("")) {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }
        return head;
    }
    protected BigInteger decodeNode(ListNode head) {
        ListNode curr = head;
        String result = "";
        for (int i = 0; curr != null ; i++) {
            result = curr.val + result;
            curr = curr.next;
        }
        return new BigInteger(result);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger val1 = decodeNode(l1);
        BigInteger val2 = decodeNode(l2);
        return encodeNode(val1.add(val2));
    }
}

//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]

public class Day012_2021 {
    public static void main(String[] args) {
        SolutionDay012 solution = new SolutionDay012();
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode actual;
        actual = solution.addTwoNumbers(l1, l2);
        System.out.println(actual.val);
    }
}
