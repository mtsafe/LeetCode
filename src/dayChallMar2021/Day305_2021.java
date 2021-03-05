package dayChallMar2021;

import java.util.ArrayList;
import java.util.List;

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
class SolutionDay305 {
    private double calcAvg(List<TreeNode> list) {
        if (list == null) return 0;
        long cnt = 0, sum = 0;
        for (TreeNode node : list) {
            sum += node.val;
            cnt++;
        }
        return ((double) sum) / (double) cnt;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<TreeNode> row = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        row.add(root);
        TreeNode node;
        while (row.size() > 0) {
            result.add(calcAvg(row));
            while (row.size() > 0) {
                node = row.remove(0);
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            row = children;
            children = new ArrayList<>();
        }
        return result;
    }
}

public class Day305_2021 {
    public static void main(String[] args) {
        SolutionDay305 solution = new SolutionDay305();
        TreeNode input;
        List<Double> result;

        // Example 1
        input = new TreeNode(3);
        input.left = new TreeNode(9);
        input.right = new TreeNode(20);
        input.right.left = new TreeNode(15);
        input.right.right = new TreeNode(7);
        result = solution.averageOfLevels(input);
        System.out.println("[3.0, 14.5, 11.0] == " + result.toString());
    }
}
