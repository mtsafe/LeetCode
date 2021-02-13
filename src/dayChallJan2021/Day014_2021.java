package dayChallJan2021;

class SolutionDay014_FirstTry {
    static class doubleLink {
        int val;
        doubleLink left = null;
        doubleLink right = null;

        doubleLink(int val) {
            this.val = val;
        }
    }

    static class stackTwo {
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

class SolutionDay014 {
    private int[] numsA;
    private int first, last;

    private int calcSum() {
        int sum = 0;
        for (int i = 0; i <= first; i++) {
            sum += numsA[i];
        }
        for (int i = numsA.length - 1; i >= last; i--) {
            sum += numsA[i];
        }
        return sum;
    }

    public int minOperations(int[] nums, int x) {
        System.out.println("x=" + x);
        int BigIndx = nums.length;
        int minOps = BigIndx;

        numsA = nums;
        int sumLeft = 0;
        for (first = 0; first < nums.length && x > sumLeft; first++) {
            sumLeft += nums[first];
        }
        if (x > sumLeft)
            return -1;
        else if (x == sumLeft) {
            minOps = Math.min(minOps, first--);
            sumLeft -= nums[first];
        }

        int sumRight = 0;
        for (last = nums.length - 1; last >= 0 && x > sumRight; last--) {
            sumRight += nums[last];
        }
        if (x > sumRight)
            return -1;
        else if (x == sumRight) {
            minOps = Math.min(minOps, nums.length - 1 - last);
            sumRight -= nums[last];
        }

        for (int firstLeft = first - 1; firstLeft >= 0; firstLeft--) {
            sumRight = 0;
            for (int lastRight = nums.length - 1; lastRight > last; lastRight--) {
                sumRight += nums[lastRight];
                if (x < sumLeft + sumRight)
                    break;
                else if (x == sumLeft + sumRight) {
                    /////////////////////////////////////////////////
                    minOps = Math.min(minOps, minOps);
                }
            }
            sumLeft -= nums[firstLeft];
        }
        return minOps;
    }
}

public class Day014_2021 {
    public static void main(String[] args) {
        SolutionDay014 solution = new SolutionDay014();
        int[] inputA;
        int minOps;

        // Test
        inputA = new int[]{1, 1, 1, 4, 4, 4, 4, 4, 4, 1, 1, 1};
        minOps = solution.minOperations(inputA, 6);
        System.out.println("6 == " + minOps);

        // Example 1
        minOps = solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5);
        System.out.println("2 == " + minOps);

        // Example 2
        minOps = solution.minOperations(new int[]{5, 6, 7, 8, 9}, 4);
        System.out.println("-1 == " + minOps);

        // Example 3
        minOps = solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10);
        System.out.println("5 == " + minOps);

        minOps = solution.minOperations(new int[]{1, 1, 3, 2, 5}, 5);
        System.out.println("1 == " + minOps);
        minOps = solution.minOperations(new int[]{1, 1}, 3);
        System.out.println("-1 == " + minOps);
        minOps = solution.minOperations(new int[]{3, 1, 20, 2, 3}, 5);
        System.out.println("2 == " + minOps);
        minOps = solution.minOperations(new int[]
                {3424, 5122, 4312, 1254, 1256, 1256, 2253, 2000, 2000, 5000,
                        5000, 5000, 5000, 5000, 5000}, 32000);
        System.out.println("7 == " + minOps);

        // Hidden test
        inputA = new int[]{6016, 5483, 541, 4325, 8149, 3515, 7865, 2209, 9623, 9763, 4052, 6540, 2123, 2074, 765, 7520, 4941, 5290, 5868, 6150, 6006, 6077, 2856, 7826, 9119};
        minOps = solution.minOperations(inputA, 31841);
        System.out.println("6 == " + minOps);


        SolutionDay014_FirstTry solution1st = new SolutionDay014_FirstTry();
        // Test
        inputA = new int[]{1, 1, 1, 4, 4, 4, 4, 4, 4, 1, 1, 1};
        minOps = solution1st.minOperations(inputA, 6);
        System.out.println("6 == " + minOps);

        // Example 1
        minOps = solution1st.minOperations(new int[]{1, 1, 4, 2, 3}, 5);
        System.out.println("2 == " + minOps);

        // Example 2
        minOps = solution1st.minOperations(new int[]{5, 6, 7, 8, 9}, 4);
        System.out.println("-1 == " + minOps);

        // Example 3
        minOps = solution1st.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10);
        System.out.println("5 == " + minOps);

        minOps = solution1st.minOperations(new int[]{1, 1, 3, 2, 5}, 5);
        System.out.println("1 == " + minOps);
        minOps = solution1st.minOperations(new int[]{1, 1}, 3);
        System.out.println("-1 == " + minOps);
        minOps = solution1st.minOperations(new int[]{3, 1, 20, 2, 3}, 5);
        System.out.println("2 == " + minOps);
        minOps = solution1st.minOperations(new int[]
                {3424, 5122, 4312, 1254, 1256, 1256, 2253, 2000, 2000, 5000,
                        5000, 5000, 5000, 5000, 5000}, 32000);
        System.out.println("7 == " + minOps);

        // Hidden test
        inputA = new int[]{6016, 5483, 541, 4325, 8149, 3515, 7865, 2209, 9623, 9763, 4052, 6540, 2123, 2074, 765, 7520, 4941, 5290, 5868, 6150, 6006, 6077, 2856, 7826, 9119};
        minOps = solution1st.minOperations(inputA, 31841);
        System.out.println("6 == " + minOps);
    }
}
