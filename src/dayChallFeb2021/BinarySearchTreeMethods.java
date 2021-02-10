package dayChallFeb2021;

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

    private static final Queue<TreeNode> printBTreeDepthQueue = new LinkedList();
    private static boolean printBTreeDepthQueueHasChildren() {
        
    }
    private static void printBTreeDepth(int depth) {
        if (depth == 0)
            System.out.print("[");

        if (printBTreeDepthQueueHasChildren){

        }
        Queue<TreeNode> tmpQueue = new LinkedList();
        for (TreeNode node1: printBTreeDepthQueue) {
            tmpQueue.add(node1.left);
            tmpQueue.add(node1.right);
        }

        if (node != null) {
            if (depth != 0)
                System.out.print(",");
            System.out.print(node.val);
            if (node.left != null)
                printBTreeDepth(node.left, depth + 1);
            if (node.right != null)
                printBTreeDepth(node.right, depth + 1);
        }


        if (depth == 0)
            System.out.print("]");
    }

    static void printBTree(TreeNode node) {
        printBTreeDepthQueue.add(node);
        printBTreeDepth(0);
    }
}
