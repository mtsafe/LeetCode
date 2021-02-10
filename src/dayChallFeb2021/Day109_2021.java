package dayChallFeb2021;

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
class SolutionDay109 {
    public int convertBSTSum(TreeNode root, int rightSum) {
        // Trivial case
        if (root == null)
            return 0;
        System.out.println("convertBSTSum(" + root.val + ", " + rightSum + ")");
        if (root.left == null && root.right == null) {
            root.val += rightSum;
            return root.val;
        }
        root.val += convertBSTSum(root.right, rightSum);
        return convertBSTSum(root.left, root.val);
    }

    public TreeNode convertBST(TreeNode root) {
        convertBSTSum(root, 0);
        return root;
    }
}

public class Day109_2021 {
    public static void main(String[] args) {
        SolutionDay109 solution = new SolutionDay109();
        TreeNode input;
        TreeNode result;

        // Trivial 1
        input = new TreeNode(0);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[0] => [0] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Trivial 2
        input = new TreeNode(1);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[1] => [1] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Test 1
        input = new TreeNode(1);
        input.left = new TreeNode(5);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[1,5] => [1,6] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Test 2
        input = new TreeNode(1);
        input.left = new TreeNode(0);
        input.right = new TreeNode(3);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[1,0,3] => [4,4,3] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Test 3
        input = new TreeNode(2);
        input.left = new TreeNode(1);
        input.right = new TreeNode(3);
        input.left.left = new TreeNode(0);
        input.right.right = new TreeNode(4);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[2,1,3,0,null,null,4] => [9,10,7,10,null,null,4] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Example 1
        input = new TreeNode(4);
        input.left = new TreeNode(1);
        input.right = new TreeNode(6);
        input.left.left = new TreeNode(0);
        input.left.right = new TreeNode(2);
        input.right.left = new TreeNode(5);
        input.right.right = new TreeNode(7);
        input.left.right.right = new TreeNode(3);
        input.right.right.right = new TreeNode(8);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8] =>" +
                "[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Example 2
        input = new TreeNode(0);
        input.right = new TreeNode(1);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[0,null,1] => [1,null,1] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Example 3
        input = new TreeNode(1);
        input.left = new TreeNode(0);
        input.right = new TreeNode(2);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[1,0,2] => [3,3,2] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();

        // Example 4
        input = new TreeNode(3);
        input.left = new TreeNode(2);
        input.right = new TreeNode(4);
        input.left.left = new TreeNode(1);
        System.out.print("input == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
        result = solution.convertBST(input);
        System.out.print("[3,2,4,1] => [7,9,4,10] == ");
        BinarySearchTreeMethods.printBTree(result);
        System.out.println();
    }
}
