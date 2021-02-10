package dayChallFeb2021;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeMethodsTest {

    @org.junit.jupiter.api.Test
    void addNode() {
    }

    @org.junit.jupiter.api.Test
    void searchNode() {
    }

    @org.junit.jupiter.api.Test
    void searchNearestValNode() {
    }

    @org.junit.jupiter.api.Test
    void printBTree() {
        TreeNode input;

        // Part 0
        input = null;
        System.out.print("[] == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();

        // Part 1
        input = new TreeNode();
        System.out.print("[0] == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();

        // Part 2
        input = new TreeNode(1);
        System.out.print("[1] == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();

        // Part 3
        input = new TreeNode(1);
        input.left = new TreeNode(5);
        System.out.print("[1,5] == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();

        // Part 4
        input = new TreeNode(1);
        input.left = new TreeNode(5);
        input.right = new TreeNode(7);
        System.out.print("[1,5,7] == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();

        // Part 5
        input = new TreeNode(1);
        input.right = new TreeNode(7);
        System.out.print("[1,null,7] == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();

        // Part 6
        input = new TreeNode(1);
        input.right = new TreeNode(7);
        input.right.left = new TreeNode(13);
        System.out.print("[1,null,7,null,null,13] == ");
        BinarySearchTreeMethods.printBTree(input);
        System.out.println();
    }
}