package dayChall202102;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.ArrayList;
import java.util.HashMap;

class SolutionDay110 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Integer> hash = new HashMap<>();
        ArrayList<Node> list = new ArrayList<>();
        Node head2, curr1, curr2;
        int indx;

        indx = 0;
        head2 = new Node(head.val);
        curr1 = head;
        curr2 = head2;
        hash.put(curr1, indx);
        list.add(curr2);
        while (curr1.next != null) {
            curr1 = curr1.next;
            curr2.next = new Node(curr1.val);
            curr2 = curr2.next;
            hash.put(curr1, ++indx);
            list.add(curr2);
        }

        curr1 = head;
        curr2 = head2;
        while (curr1 != null) {
            if (curr1.random == null) {
                curr2.random = null;
                curr1 = curr1.next;
                curr2 = curr2.next;
                continue;
            }
            curr2.random = list.get(hash.get(curr1.random));
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return head2;
    }
}

public class Day110_2021 {
    public static void main(String[] args) {
        SolutionDay110 solution = new SolutionDay110();
        Node input;
        Node result;

        // Example 1
        input = new Node(7);
        input.next = new Node(13);
        input.next.next = new Node(11);
        input.next.next.next = new Node(10);
        input.next.next.next.next = new Node(1);
        input.random = null;
        input.next.random = input;
        input.next.next.random = input.next.next.next.next;
        input.next.next.next.random = input.next.next;
        input.next.next.next.next.random = input;
        result = solution.copyRandomList(input);

        // Example 2
        input = new Node(1);
        input.next = new Node(2);
        input.random = input.next;
        input.next.random = input.next;
        result = solution.copyRandomList(input);
    }
}
