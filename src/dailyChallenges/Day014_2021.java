package dailyChallenges;

class SolutionDay014 {
    class doubleLink {
        int val;
        doubleLink left = null;
        doubleLink right = null;

        doubleLink(int val) {
            this.val = val;
        }
    }

    class stackTwo {
        doubleLink farLeft;
        doubleLink farRight;
        int size;
        int total;

        stackTwo() {
            farLeft = null;
            farRight = null;
            size = 0;
            total = 0;
        }

        stackTwo(doubleLink node) {
            farLeft = node;
            farRight = node;
            size = 1;
            total = node.val;
        }

        stackTwo(int[] arr) {
            if (arr.length == 0) {
                size = 0;
                total = 0;
                return;
            }
            farLeft = new doubleLink(arr[0]);
            size = 1;
            total = arr[0];
            farRight = farLeft;
            for (int i = 1; i < arr.length; i++) {
                pushRight(new doubleLink(arr[i]));
            }
        }

        public void pushLeft(doubleLink node) {
            if (size == 0) {
                farRight = node;
            } else {
                node.right = farLeft;
                farLeft.left = node;
            }
            farLeft = node;
            size++;
            total += node.val;
        }

        public void pushRight(doubleLink node) {
            if (size == 0) {
                farLeft = node;
            } else {
                node.left = farRight;
                farRight.right = node;
            }
            farRight = node;
            size++;
            total += node.val;
        }

        public doubleLink popLeft() {
            doubleLink endNode = farLeft;
            if (farLeft == farRight) {
                farLeft = null;
                farRight = null;
            } else {
                farLeft = farLeft.right;
                farLeft.left = null;
                endNode.right = null;
            }
            if (endNode != null) {
                size--;
                total -= endNode.val;
            }
            return endNode;
        }

        public doubleLink popRight() {
            doubleLink endNode = farRight;
            if (farLeft == farRight) {
                farLeft = null;
                farRight = null;
            } else {
                farRight = farRight.left;
                farRight.right = null;
                endNode.left = null;
            }
            if (endNode != null) {
                size--;
                total -= endNode.val;
            }
            return endNode;
        }
    }

    private int BigNumber;

    public int calcSolutionSize(int x, stackTwo left, stackTwo right) {
        if (left.total == x && right.total == x)
            return Math.min(left.size, right.size);
        if (left.total == x)
            return left.size;
        if (right.total == x)
            return right.size;
        if (left.total + right.total == x)
            return left.size + right.size;
        return BigNumber;
    }


    public void printStack(stackTwo a) {
        System.out.print("[");
        doubleLink curr = a.farLeft;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.right != null) {
                System.out.print(", ");
            }
            curr = curr.right;
        }
        System.out.print("]");
    }

    public void printStacks(stackTwo a, stackTwo b, stackTwo c) {
        printStack(a);
        System.out.print(" ");
        printStack(b);
        System.out.print(" ");
        printStack(c);
        System.out.println("");
    }

    public int minOperations(int[] nums, int x) {
        System.out.println("x=" + x);
        BigNumber = nums.length + 1;
        int minOps = BigNumber;
        stackTwo leftStack = new stackTwo();
        stackTwo rightStack = new stackTwo();
        stackTwo mainStack = new stackTwo(nums);
        printStacks(leftStack, mainStack, rightStack);
        while (x > leftStack.total && mainStack.size > 0) {
            leftStack.pushRight(mainStack.popLeft());
            printStacks(leftStack, mainStack, rightStack);
        }
        printStacks(leftStack, mainStack, rightStack);
        int reducedVal = x - leftStack.total;
        if (reducedVal < 0) {
            mainStack.pushLeft(leftStack.popRight());
        } else if (reducedVal == 0) {
            minOps = Math.min(minOps, leftStack.size);
        } else
            return -1;
        printStacks(leftStack, mainStack, rightStack);
        while (x > rightStack.total) {
            if (mainStack.size == 0) {
                if (leftStack.size == 0) {
                    break;
                }
                mainStack.pushLeft((leftStack.popRight()));
            }
            rightStack.pushLeft(mainStack.popRight());
            minOps = Math.min(minOps, calcSolutionSize(x, leftStack, rightStack));
            printStacks(leftStack, mainStack, rightStack);
        }
        printStacks(leftStack, mainStack, rightStack);
        if (minOps == BigNumber)
            return -1;
        return minOps;
    }
}

public class Day014_2021 {
    public static void main(String[] args) {
        SolutionDay014 solution = new SolutionDay014();
        int minOps;

        minOps = solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5);
        System.out.println("result=" + minOps);
        minOps = solution.minOperations(new int[]{5, 6, 7, 8, 9}, 4);
        System.out.println("result=" + minOps);
        minOps = solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10);
        System.out.println("result=" + minOps);
        minOps = solution.minOperations(new int[]{1, 1, 3, 2, 5}, 5);
        System.out.println("result=" + minOps);
        minOps = solution.minOperations(new int[]{1, 1}, 3);
        System.out.println("result=" + minOps);
        minOps = solution.minOperations(new int[]{3, 1, 20, 2, 3}, 5);
        System.out.println("result=" + minOps);
    }
}
