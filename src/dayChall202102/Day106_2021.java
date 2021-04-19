package dayChall202102;

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
class SolutionDay106 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        List<TreeNode> rowList = new ArrayList<>();
        List<TreeNode> childrenList = new ArrayList<>();

        TreeNode lastNode = root;
        rowList.add(root);
        while (rowList.size() > 0) {
            for (TreeNode node : rowList) {
                lastNode = node;
                if (node.left != null)
                    childrenList.add(node.left);
                if (node.right != null)
                    childrenList.add(node.right);
            }
            result.add(lastNode.val);
            rowList = childrenList;
            childrenList = new ArrayList<>();
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
        input = null;
        result = solution.rightSideView(input);
        System.out.println("[] == "+result);

        // Trivial 2
        input = new TreeNode(8);
        result = solution.rightSideView(input);
        System.out.println("[8] == "+result);

        // Example 1
        input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        input.left.right = new TreeNode(5);
        input.right.right = new TreeNode(4);
        result = solution.rightSideView(input);
        System.out.println("[1,3,4] == "+result);

        // Test 1
        input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        input.left.right = new TreeNode(5);
        result = solution.rightSideView(input);
        System.out.println("[1,3,5] == "+result);
    }
}
