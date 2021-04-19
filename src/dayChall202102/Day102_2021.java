package dayChall202102;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class SolutionDay102 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return root;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val < low || root.val > high) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
        }
        return root;
    }
}

public class Day102_2021 {
    public static void main(String[] args) {
        SolutionDay102 solution = new SolutionDay102();
        TreeNode input;
        input = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(2));
        System.out.println();
    }
}
