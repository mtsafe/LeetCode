package dayChall202102;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a class of methods for working with a binary search tree.
 */

public class BinarySearchTreeMethods {
    TreeNode addNode(TreeNode root, int newVal) {
        if (root == null)
            return new TreeNode(newVal);
        if (newVal > root.val) {    // goes right
            if (root.right == null) {
                root.right = new TreeNode(newVal);
                return root;
            }
            addNode(root.right, newVal);
        } else {                    // goes left
            if (root.left == null) {
                root.left = new TreeNode(newVal);
                return root;
            }
            addNode(root.left, newVal);
        }
        return root;
    }

    TreeNode searchNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (val > root.val) {
            if (root.right == null)
                return null;
            return searchNode(root.right, val);
        } else if (val < root.val) {
            if (root.left == null)
                return null;
            return searchNode(root.left, val);
        }
        return root;
    }

    TreeNode searchNearestValNode(TreeNode root, int val) {
        TreeNode answerChild;
        if (root == null)
            return null;
        if (val > root.val) {
            if (root.right == null)
                return root;
            answerChild = searchNearestValNode(root.right, val);
        } else if (val < root.val) {
            if (root.left == null)
                return root;
            answerChild = searchNearestValNode(root.left, val);
        } else
            return root;
        if (Math.abs(root.val - val) > Math.abs(answerChild.val - val))
            return answerChild;
        return root;
    }

    private static Queue<TreeNode> printBTreeDepthQueue;

    private static boolean isPrintBTreeDepthQueueNull() {
        for (TreeNode node : printBTreeDepthQueue) {
            if (node != null)
                return false;
        }
        return true;
    }

    private static boolean printBTreeDepthQueueHasChildren() {
        for (TreeNode node : printBTreeDepthQueue) {
            if (node != null &&
                    (node.left != null || node.right != null))
                return true;
        }
        return false;
    }

    private static void printBTreeDepth() {
        System.out.print("[");
        boolean isFirstNode = true;
        int depth = 0;

//  Code to remove trailing nulls from the printed array.
//        if (!printBTreeDepthQueueHasChildren()) {
//
//        }

        while (!isPrintBTreeDepthQueueNull()) {
            for (TreeNode node : printBTreeDepthQueue) {
                if (isFirstNode)
                    isFirstNode = false;
                else
                    System.out.print(",");
                if (node == null)
                    System.out.print("null");
                else
                    System.out.print(node.val);
            }

            Queue<TreeNode> tmpQueue = new LinkedList<>();
            if (printBTreeDepthQueueHasChildren()) {
                for (TreeNode node : printBTreeDepthQueue) {
                    if (node == null) {
                        tmpQueue.add(null);
                        tmpQueue.add(null);
                    } else {
                        tmpQueue.add(node.left);
                        tmpQueue.add(node.right);
                    }
                }
            }
            printBTreeDepthQueue = tmpQueue;
            if (depth++ > 8)
                return;
        }

        System.out.print("]");
    }

    static void printBTree(TreeNode node) {
        printBTreeDepthQueue = new LinkedList<>();
        printBTreeDepthQueue.add(node);
        printBTreeDepth();
    }
}
