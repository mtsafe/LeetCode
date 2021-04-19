package dayChall202104;

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
class SolutionDay411 {
    int depth, sum;

    void recurseDeepestLeavesSum(TreeNode root, int level) {
        if (root == null) return;
        if (root.left != null)
            recurseDeepestLeavesSum(root.left, level + 1);
        if (root.right != null)
            recurseDeepestLeavesSum(root.right, level + 1);
        if (depth < level) {
            depth = level;
            sum = 0;
        }
        if (depth == level) sum += root.val;
        System.out.println("depth == " + depth + "; level == " + level + "; root.val == " + root.val);
    }

    public int deepestLeavesSum(TreeNode root) {
        int level = 0;
        depth = 0;
        sum = 0;
        recurseDeepestLeavesSum(root, level);
        return sum;
    }
}

public class Day411_2021 {
    public static void main(String[] args) {
        SolutionDay411 solution = new SolutionDay411();
        TreeNode inputR;
        int result;
        int NULL = TreeNode.NULL;

        // Trivial 1
        inputR = new TreeNode();
        inputR.completeTree(new int[]{1});
        PrintUtils.printTreeAsArray(inputR);
        result = solution.deepestLeavesSum(inputR);
        System.out.println("1 == " + result);

        // Trivial 2
        inputR = new TreeNode();
        inputR.completeTree(new int[]{1, 2, 3});
        PrintUtils.printTreeAsArray(inputR);
        result = solution.deepestLeavesSum(inputR);
        System.out.println("5 == " + result);

        // Trivial 3
        inputR = new TreeNode();
        inputR.completeTree(new int[]{1, 2});
        PrintUtils.printTreeAsArray(inputR);
        result = solution.deepestLeavesSum(inputR);
        System.out.println("2 == " + result);

        // Trivial 4
        inputR = new TreeNode();
        inputR.completeTree(new int[]{1, NULL, 3});
        PrintUtils.printTreeAsArray(inputR);
        result = solution.deepestLeavesSum(inputR);
        System.out.println("3 == " + result);

        // Trivial 5
        inputR = new TreeNode();
        inputR.completeTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        PrintUtils.printTreeAsArray(inputR);
        result = solution.deepestLeavesSum(inputR);
        System.out.println("22 == " + result);

        // Example 1
        inputR = new TreeNode();
        inputR.completeTree(new int[]{1, 2, 3, 4, 5, NULL, 6, 7, NULL, NULL, NULL, NULL, 8});
        PrintUtils.printTreeAsArray(inputR);
        result = solution.deepestLeavesSum(inputR);
        System.out.println("15 == " + result);

        // Example 2
        inputR = new TreeNode();
        inputR.completeTree(new int[]{6, 7, 8, 2, 7, 1, 3, 9, NULL, 1, 4, NULL, NULL, NULL, 5});
        PrintUtils.printTreeAsArray(inputR);
        result = solution.deepestLeavesSum(inputR);
        System.out.println("19 == " + result);
    }
}
