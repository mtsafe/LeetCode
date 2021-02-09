package dayChallFeb2021;

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
}
