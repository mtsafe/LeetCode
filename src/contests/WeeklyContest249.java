package contests;

import java.util.*;

class SolutionWC249 {
    public int[] getConcatenation(int[] nums) {
        if (nums == null) return new int[0];
        int[] ans = new int[2 * nums.length];
        for (int a = 0; a < 2 * nums.length; a += nums.length) {
            for (int i = 0; i < nums.length; i++) {
                ans[a + i] = nums[i];
            }
        }
        return ans;
    }

    public int countPalindromicSubsequence_1stTry(String s) {
        if (s == null || s.length() < 3) return 0;
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        String pal;
        for (int i = 0; i < chars.length - 2; i++) {
            for (int j = i + 1; j < chars.length - 1; j++) {
                for (int k = j + 1; k < chars.length; k++) {
                    if (chars[i] == chars[k]) {
                        pal = Character.toString(chars[i]) +
                                Character.toString(chars[j]) +
                                Character.toString(chars[k]);
                        set.add(pal);
                    }
                }
            }
        }
        return set.size();
    }

    public int countPalindromicSubsequence(String s) {
        if (s == null || s.length() < 3) return 0;
        int palCnt = 0;
        int a1, a2;
        for (int a = 'a'; a <= 'z'; a++) {
            a1 = s.indexOf(a);
            a2 = s.lastIndexOf(a);
            if (a1 != a2 && a2 > a1 + 1)
                for (int b = 'a'; b <= 'z'; b++) {
                    if (s.substring(a1 + 1, a2).indexOf(b) != -1)
                        palCnt++;
                }
        }
        return palCnt;
    }

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

        public TreeNode canMerge(List<TreeNode> trees) {
            if (trees == null) return null;
            if (trees.size() == 1)
                return trees.get(0);
            HashMap<Integer, TreeNode> hashT = new HashMap<>();
            HashMap<Integer, TreeNode> hashL = new HashMap<>();
            for (TreeNode aTree : trees) {
                hashT.put(aTree.val, aTree);
                if (aTree.left != null) {
                    if (hashL.containsKey(aTree.left.val)) return null;
                    hashL.put(aTree.left.val, aTree.left);
                }
                if (aTree.right != null) {
                    if (hashL.containsKey(aTree.right.val)) return null;
                    hashL.put(aTree.right.val, aTree.right);
                }
            }
            return trees.get(1);
        }
    }
}

public class WeeklyContest249 {
    static List<SolutionWC249.TreeNode> arraysToTreeList(int[][] arrs) {
        List<SolutionWC249.TreeNode> result = new ArrayList<>();
        if (arrs == null) return result;
        SolutionWC249.TreeNode root, left, right;
        for (int[] arr : arrs) {
            if (arr.length == 3)
                root = new SolutionWC249.TreeNode(arr[0],
                        new SolutionWC249.TreeNode(arr[1]),
                        new SolutionWC249.TreeNode(arr[2]));
            else if (arr.length == 2)
                root = new SolutionWC249.TreeNode(arr[0],
                        new SolutionWC249.TreeNode(arr[1]),
                        null);
            else if (arr.length == 1)
                root = new SolutionWC249.TreeNode(arr[0]);
            else
                root = new SolutionWC249.TreeNode();
            result.add(root);
        }
        return result;
    }

    static String treeNodeToString(SolutionWC249.TreeNode tn) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(Integer.toString(tn.val));
        Queue<SolutionWC249.TreeNode> queue = new LinkedList<SolutionWC249.TreeNode>();
        queue.add(tn);
        while (!queue.isEmpty()) {
            SolutionWC249.TreeNode node = queue.remove();
            sb.append(",").append(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SolutionWC249 solution = new SolutionWC249();
        int[][] inputTs;
        SolutionWC249.TreeNode resultT = new SolutionWC249.TreeNode();

        // Example 1
        inputTs = new int[][]{{2, 1}, {3, 2, 5}, {5, 4}};
        resultT = resultT.canMerge(arraysToTreeList(inputTs));
        System.out.println("[3,2,5,1,null,4] == " + treeNodeToString(resultT));

        // Example 2
        inputTs = new int[][]{{5, 3, 8}, {3, 2, 6}};
        resultT = resultT.canMerge(arraysToTreeList(inputTs));
        System.out.println("[] == " + treeNodeToString(resultT));

        // Example 3
        inputTs = new int[][]{{5, 4}, {3}};
        resultT = resultT.canMerge(arraysToTreeList(inputTs));
        System.out.println("[] == " + treeNodeToString(resultT));

        // Example 4
        inputTs = new int[][]{{2, 1, 3}};
        resultT = resultT.canMerge(arraysToTreeList(inputTs));
        System.out.println("[2,1,3] == " + treeNodeToString(resultT));

        ///////////////////////////////////////////
        String inputS;
        int resultI;

        // Example 1
        inputS = "aabca";
        resultI = solution.countPalindromicSubsequence(inputS);
        System.out.println("3 == " + resultI);

        // Example 2
        inputS = "adc";
        resultI = solution.countPalindromicSubsequence(inputS);
        System.out.println("0 == " + resultI);

        // Example 3
        inputS = "bbcbaba";
        resultI = solution.countPalindromicSubsequence(inputS);
        System.out.println("4 == " + resultI);

        ///////////////////////////////////////////
        int[] inputN;
        int[] resultN;

        // Example 1
        inputN = new int[]{1, 2, 1};
        resultN = solution.getConcatenation(inputN);
        System.out.println("[1,2,1,1,2,1] == " + resultN);

        // Example 2
        inputN = new int[]{1, 3, 2, 1};
        resultN = solution.getConcatenation(inputN);
        System.out.println("[1,3,2,1,1,3,2,1] == " + resultN);
    }
}
