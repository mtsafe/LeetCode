package dayChall202103;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right)
 * {this.val = val; this.left = left; this.right = right;}
 * }
 */
class SolutionDay309 {
    public TreeNode addOneRowRecurse(TreeNode parent, TreeNode child, int v, int d, boolean left) {
        if (parent == null) return null;
        if (d != 1) {
            if (child != null) {
                addOneRowRecurse(child, child.left, v, d - 1, true);
                addOneRowRecurse(child, child.right, v, d - 1, false);
            }
            return parent;
        }
        if (left)
            parent.left = new TreeNode(v, child, null);
        else
            parent.right = new TreeNode(v, null, child);
        return parent;
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null || d < 1)
            return root;
        if (d == 1)
            return new TreeNode(v, root, null);
        addOneRowRecurse(root, root.left, v, d - 1, true);
        return addOneRowRecurse(root, root.right, v, d - 1, false);
    }
}

public class Day309_2021 {
    public static void main(String[] args) {
        SolutionDay309 solution = new SolutionDay309();
        TreeNode input;
        int v, d;
        TreeNode result;

        // Example 1
        input = new TreeNode(4);
        input.left = new TreeNode(2);
        input.right = new TreeNode(6);
        input.left.left = new TreeNode(3);
        input.left.right = new TreeNode(1);
        input.right.left = new TreeNode(5);
        v = 1;
        d = 2;
        result = solution.addOneRow(input, v, d);
        System.out.println("E1");

        // Example 2
        input = new TreeNode(4);
        input.left = new TreeNode(2);
        input.left.left = new TreeNode(3);
        input.left.right = new TreeNode(1);
        v = 1;
        d = 3;
        result = solution.addOneRow(input, v, d);
        System.out.println("E2");

        // Test Case 1
        input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        input.left.left = new TreeNode(4);
        v = 5;
        d = 4;
        result = solution.addOneRow(input, v, d);
        System.out.println("TC1");
    }
}
