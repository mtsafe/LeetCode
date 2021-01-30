package dailyChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
class SolutionDay029 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

/*
    // First Try
    public List<List<Integer>> buildLists(List<List<Integer>> list, TreeNode root, int depth, int column) {
        if (depth == - column)
            list.add(0, new ArrayList<>());
        else if (depth == column)
            list.add(new ArrayList<>());
        list.get(column + list.size()/2);
        return list;
    }
*/
/*
    // Second Try
    public HashMap<Integer, ArrayList<Integer>> buildLists(
            HashMap<Integer, ArrayList<Integer>> hash,
            TreeNode node, int depth, int column) {
        if (node == null)
            return hash;
        if (!hash.containsKey(column))
            hash.put(column, new ArrayList<>());
        hash.get(column).add(node.val);
        buildLists(hash, node.left, depth + 1, column - 1);
        buildLists(hash, node.right, depth + 1, column + 1);
        return hash;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> hash;
        hash = buildLists(new HashMap<>(), root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int column = -hash.size(); column < hash.size(); column++) {
            if (!hash.containsKey(column))
                continue;
            Collections.sort(hash.get(column));
            result.add(hash.get(column));
        }
        return result;
    }
*/

    int encodeColumn(int column) {
        // convert positive/negative to even/odd
        if (column >= 0)
            return 2 * column;
        return -1 - 2 * column;
    }

    int decodeColumn(int code) {
        // convert even/odd to positive/negative
        if (code % 2 == 0)
            return code / 2;
        return -(code + 1) / 2;
    }

    String encodeHash(int depth, int column) {
        return String.valueOf(depth) + "," + String.valueOf(encodeColumn(column));
    }

    int decodeDepthFromKey(String key) {
        return Integer.parseInt(key.substring(0, key.indexOf(',')));
    }

    int decodeColumnFromKey(String key) {
        return decodeColumn(Integer.parseInt(key.substring(key.indexOf(',') + 1, key.length())));
    }

    public HashMap<String, ArrayList<Integer>> buildLists(
            HashMap<String, ArrayList<Integer>> hash,
            TreeNode node, int depth, int column) {
        if (node == null)
            return hash;
        String key = encodeHash(depth, column);
        if (hash.get(key) == null)
            hash.put(key, new ArrayList<>());
        hash.get(key).add(node.val);
        buildLists(hash, node.left, depth + 1, column - 1);
        buildLists(hash, node.right, depth + 1, column + 1);
        return hash;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<String, ArrayList<Integer>> hashA;
        hashA = buildLists(new HashMap<>(), root, 0, 0);

        HashMap<String, ArrayList<Integer>> hashB;
        for (String key : Collections.sort(new ArrayList<>(hashA.keySet()))) {
            Collections.sort(hashA.get(key));
            int column = decodeColumnFromKey(key);
            if (!hashB.containsKey(column))
                hashB.put(column, new ArrayList<>());
            hashB.get(column).add()
        }
        int row = 0;
        while (row) {
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(hash.get(column));
        return result;
    }
}

public class Day029_2021 {
    public static void main(String[] args) {
        SolutionDay029 solution = new SolutionDay029();
        List<List<Integer>> result;
        SolutionDay029.TreeNode input;

        // Testcase: [3,9,20,null,null,15,7]
        input = new SolutionDay029.TreeNode(3);
        input.left = new SolutionDay029.TreeNode(9);
        input.right = new SolutionDay029.TreeNode(20);
        input.right.left = new SolutionDay029.TreeNode(15);
        input.right.right = new SolutionDay029.TreeNode(7);
        result = solution.verticalTraversal(input);
        System.out.print("[[9],[3,15],[20],[7]] == ");
        printResult(result);

        // Testcase: [1,2,3,4,5,6,7]
        input = new SolutionDay029.TreeNode(1);
        input.left = new SolutionDay029.TreeNode(2);
        input.right = new SolutionDay029.TreeNode(3);
        input.left.left = new SolutionDay029.TreeNode(4);
        input.left.right = new SolutionDay029.TreeNode(5);
        input.right.left = new SolutionDay029.TreeNode(6);
        input.right.right = new SolutionDay029.TreeNode(7);
        result = solution.verticalTraversal(input);
        System.out.print("[[4],[2],[1,5,6],[3],[7]] == ");
        printResult(result);

        // Testcase: [1,2,3,4,6,5,7]
        input = new SolutionDay029.TreeNode(1);
        input.left = new SolutionDay029.TreeNode(2);
        input.right = new SolutionDay029.TreeNode(3);
        input.left.left = new SolutionDay029.TreeNode(4);
        input.left.right = new SolutionDay029.TreeNode(6);
        input.right.left = new SolutionDay029.TreeNode(5);
        input.right.right = new SolutionDay029.TreeNode(7);
        result = solution.verticalTraversal(input);
        System.out.print("[[4],[2],[1,5,6],[3],[7]] == ");
        printResult(result);

        // Testcase: [0,1,null,null,2, ??? ]
        input = new SolutionDay029.TreeNode(0);
        input.left = new SolutionDay029.TreeNode(1);
        input.left.right = new SolutionDay029.TreeNode(2);
        input.left.right.left = new SolutionDay029.TreeNode(6);
        input.left.right.right = new SolutionDay029.TreeNode(7);
        input.left.right.right.right = new SolutionDay029.TreeNode(4);
        input.left.right.right.right.right = new SolutionDay029.TreeNode(5);
        result = solution.verticalTraversal(input);
        System.out.print("[[1,6],[0,2],[7],[4],[5]] == ");
        printResult(result);

        // Testcase: [3,1,4,0,2,2]
        input = new SolutionDay029.TreeNode(3);
        input.left = new SolutionDay029.TreeNode(1);
        input.right = new SolutionDay029.TreeNode(4);
        input.left.left = new SolutionDay029.TreeNode(0);
        input.left.right = new SolutionDay029.TreeNode(2);
        input.right.left = new SolutionDay029.TreeNode(2);
        result = solution.verticalTraversal(input);
        System.out.print("[[0],[1],[3,2,2],[4]] == ");
        printResult(result);
    }

    private static void printResult(List<List<Integer>> result) {
        System.out.print("[");
        while (result.size() > 1) {
            printList(result.remove(0));
            System.out.print(",");
        }
        printList(result.remove(0));
        System.out.println("]");
    }

    private static void printList(List<Integer> list) {
        System.out.print("[");
        while (list.size() > 1) {
            System.out.print(list.remove(0) + ",");
        }
        System.out.print(list.remove(0) + "]");
    }
}
