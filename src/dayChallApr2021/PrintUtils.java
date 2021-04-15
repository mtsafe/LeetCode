package dayChallApr2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintUtils {
    public static void printTreeAsArray(TreeNode root) {
        if (root == null) return;
        System.out.print("[");
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<TreeNode> newList;
        boolean isGoodNode;
        boolean isFirst = true;
        while (list.size() > 0) {
            newList = new ArrayList<>();
            isGoodNode = false;
            for (TreeNode node : list) {
                if (node == null) {
                    newList.add(null);
                    newList.add(null);
                } else {
                    if (node.left != null || node.right != null) isGoodNode = true;
                    newList.add(node.left);
                    newList.add(node.right);
                }

                if (!isFirst) System.out.print(", ");
                else isFirst = false;
                if (node == null)
                    System.out.print("null");
                else
                    System.out.print(node.val);
            }
            if (!isGoodNode) break;
            list = newList;
        }
        System.out.println("]");
    }

    public static void printListListInt(List<List<Integer>> list) {
        if (list == null) return;
        System.out.print("[");
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (i == len - 1)
                System.out.print(Arrays.toString(list.get(i).toArray()));
            else
                System.out.print(Arrays.toString(list.get(i).toArray()) + ",");
        }
        System.out.print("]");
    }

    public static void printListNodeList(ListNode list) {
        if (list == null) return;
        System.out.print("[");
        ListNode curr = list;
        while (curr != null) {
            if (curr.next == null)
                System.out.print(curr.val);
            else
                System.out.print(curr.val + ",");
            curr = curr.next;
        }
        System.out.print("]");
    }
}
