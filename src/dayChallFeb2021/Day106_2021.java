package dayChallFeb2021;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SolutionDay106 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while (root != null) {
            result.add(root.val);
            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }
        return result;
    }
}

public class Day106_2021 {
    public static void main(String[] args) {
        SolutionDay106 solution = new SolutionDay106();
        TreeNode input;
        List<Integer> result;

        // Trivial 1
        input = new TreeNode();
        result = solution.rightSideView(input);
        System.out.println("[] == ");

        // Trivial 2
        input = new TreeNode(8);
        result = solution.rightSideView(input);

        // Trivial 1
        input = new TreeNode();
        result = solution.rightSideView(input);

        // Trivial 1
        input = new TreeNode();
        result = solution.rightSideView(input);
    }
}
