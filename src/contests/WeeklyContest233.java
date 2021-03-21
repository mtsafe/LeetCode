package contests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SolutionWC233 {
    public int maxAscendingSum(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int sum = nums[0];
        int maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    private static class OrderR {
        int price;
        int amount;

        OrderR(int price, int amount) {
            this.price = price;
            this.amount = amount;
        }
    }

    private long backLog(List<OrderR> orders) {
        if (orders == null || orders.size() == 0) return 0;
        long backCnt = 0;
        for (OrderR order : orders) {
            backCnt += order.amount;
        }
        return backCnt;
    }

    private OrderR smallest(List<OrderR> orders) {
        if (orders == null || orders.size() == 0) return null;
        return orders.get(0);
    }

    private OrderR largest(List<OrderR> orders) {
        if (orders == null || orders.size() == 0) return null;
        return orders.get(0);
    }

    private void backLogToSell(List<OrderR> sell, int[] order) {
        if (sell == null || order == null) return;
        sell.add(new OrderR(order[0], order[1]));
        sell.sort((oA, oB) -> -Integer.compare(oA.price, oB.price));
    }

    private void backLogToBuy(List<OrderR> buy, int[] order) {
        if (buy == null || order == null) return;
        buy.add(new OrderR(order[0], order[1]));
        buy.sort(Comparator.comparingInt(oA -> oA.price));
    }

    private void buySome(List<OrderR> buy, List<OrderR> sell, int[] order) {
        if (buy == null || sell == null || order == null) return;
        OrderR sellNext;
        while (order[1] > 0) {          // amount [quantity]
            sellNext = smallest(sell);
            if (sellNext != null && sellNext.price <= order[0]) {
                if (sellNext.amount == order[1]) {
                    sell.remove(sellNext);
                    return;
                } else if (sellNext.amount > order[1]) {
                    sellNext.amount -= order[1];
                    return;
                } else {
                    order[1] -= sellNext.amount;
                    sell.remove(sellNext);
                }
            } else {
                backLogToBuy(buy, order);
                return;
            }
        }
    }

    private void sellSome(List<OrderR> buy, List<OrderR> sell, int[] order) {
        if (buy == null || sell == null || order == null) return;
        OrderR buyNext;
        while (order[1] > 0) {          // amount [quantity]
            buyNext = largest(buy);
            if (buyNext != null && buyNext.price >= order[0]) {
                if (buyNext.amount == order[1]) {
                    buy.remove(buyNext);
                    return;
                } else if (buyNext.amount > order[1]) {
                    buyNext.amount -= order[1];
                    return;
                } else {
                    order[1] -= buyNext.amount;
                    buy.remove(buyNext);
                }
            } else {
                backLogToSell(sell, order);
                return;
            }
        }
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        if (orders == null) return 0;
        List<OrderR> buy = new ArrayList<>();
        List<OrderR> sell = new ArrayList<>();
        for (int[] order : orders) {
            if (order[2] == 0)
                buySome(buy, sell, order);
            else
                sellSome(buy, sell, order);
        }
//        System.out.println(backLog(buy) + " " + backLog(sell));
        return (int) ((backLog(buy) + backLog(sell)) % 1000000007);
    }
}

public class WeeklyContest233 {
    public static void main(String[] args) {
        SolutionWC233 solution = new SolutionWC233();
        int[] nums;
        int result;

        int[][] orders;

        // Trivial 1
        orders = new int[][]{{10, 5, 0}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("5 == " + result);

        // Trivial 2
        orders = new int[][]{{10, 5, 1}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("5 == " + result);

        // Trivial 3
        orders = new int[][]{{10, 5, 0}, {10, 5, 0}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("10 == " + result);

        // Trivial 4
        orders = new int[][]{{10, 5, 0}, {10, 5, 1}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("0 == " + result);

        // Test 1
        orders = new int[][]{{10, 5, 0}, {10, 3, 1}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("2 == " + result);


        // Test 2
        orders = new int[][]{{10, 5, 0}, {10, 3, 1}, {10, 3, 1}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("1 == " + result);

        // Test 3
        orders = new int[][]{{10, 11, 0}, {10, 3, 0}, {10, 6, 1}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("8 == " + result);

        // Test 4
        orders = new int[][]{{10, 11, 0}, {10, 3, 0}, {9, 6, 1}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("8 == " + result);

        // Test 5
        orders = new int[][]{{10, 5, 0}, {15, 2, 1}, {30, 4, 0}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("7 == " + result);

        // Example 1
        orders = new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("6 == " + result);

        // Example 2
        orders = new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("999999984 == " + result);

        // Failed 1
        orders = new int[][]{
                {26, 7, 0}, {16, 1, 1}, {14, 20, 0}, {23, 15, 1},
                {24, 26, 0}, {19, 4, 1}, {1, 1, 0}
        };
        result = solution.getNumberOfBacklogOrders(orders);
        System.out.println("34 == " + result);

        /////////////////////////////////////////////////
        // Trivial 1
        nums = new int[]{1};
        result = solution.maxAscendingSum(nums);
        System.out.println("1 == " + result);

        // Example 1
        nums = new int[]{10, 20, 30, 5, 10, 50};
        result = solution.maxAscendingSum(nums);
        System.out.println("65 == " + result);

        // Example 4
        nums = new int[]{100, 10, 1};
        result = solution.maxAscendingSum(nums);
        System.out.println("100 == " + result);
    }
}
