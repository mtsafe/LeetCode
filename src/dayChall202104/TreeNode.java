package dayChall202104;

public class TreeNode {
    static int NULL = Integer.MIN_VALUE;
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

    private int parentIndex(int child) {
        return (int) ((child - (child % 2 == 0 ? 2 : 1))/2.0);
    }

    private TreeNode nodeByIndex(TreeNode root, int index) {
        if (index == 0 || root == null) return root;
        TreeNode parent = nodeByIndex(root, parentIndex(index));
        System.out.println("The parent of "+index+" is "+(parent.val-1));
        if (parent == null) return root;
        if (index % 2 == 0)
            return parent.right;
        return parent.left;
    }

    void completeTree(int[] arr) {
        if (arr == null || arr.length < 1) return;
        TreeNode root = this;
        root.val = arr[0];
        int index = 1;
        TreeNode parent;
        while (index < arr.length) {
            if (arr[index] == NULL) {
                index++;
                continue;
            }
            parent = nodeByIndex(root, parentIndex(index));
            if (parent == null) {
                index++;
                continue;
            }
            if (index % 2 == 0)
                parent.right = new TreeNode(arr[index]);
            else
                parent.left = new TreeNode(arr[index]);
            index++;
        }
    }
}
