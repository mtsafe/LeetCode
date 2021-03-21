package dayChallMar2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionDay311 {
    private void combinationsRecurse(List<List<Integer>> combinations,
                                     List<Integer> denominationBuilder,
                                     List<Integer> allDenominations,
                                     int r) {
        System.out.print("combinationsRecurse(");
        PrintUtils.printListListInt(combinations);
        System.out.println(denominationBuilder+","+allDenominations+","+r+")");
        if (r <= 0) return;
        while (denominationBuilder.size() > r) {
            denominationBuilder.add(allDenominations.remove(0));
            combinationsRecurse(combinations, new ArrayList<>(denominationBuilder),
                    allDenominations, r);
        }
        if (r == denominationBuilder.size()) {
            combinations.add(new ArrayList<>(denominationBuilder));
        }
    }

    private List<List<Integer>> combinations(List<Integer> denominations, int r) {
        System.out.println("combinations("+denominations+","+r+")");
        List<List<Integer>> result = new ArrayList<>();
        combinationsRecurse(result, new ArrayList<>(), denominations, r);
        return result;
    }

    private int minCoins(List<Integer> denominations, int amount) {
        System.out.println("coinChange("+denominations+","+amount+")");
        if (denominations == null)
            return -1;
        int denomination;
        int coinCnt = 0;
        while (amount != 0) {
            if (denominations.size() == 0)
                return -1;
            denomination = denominations.remove(denominations.size() - 1);
            while (amount / denomination > 0) {
                amount -= denomination;
                coinCnt++;
            }
        }
        return coinCnt;
    }

    public int coinChange(int[] coins, int amount) {
        System.out.println("coinChange("+ Arrays.toString(coins)+","+amount+")");
        if (coins == null)
            return -1;
        List<Integer> denominations = new ArrayList<>();
        for (int i : coins)
            denominations.add(i);
        Collections.sort(denominations);

        int coinCnt, minCoins = Integer.MAX_VALUE;
        boolean isChange = false;
        for (int r = 1; r < denominations.size(); r++) {
            System.out.println("A");
            List<List<Integer>> combinationsList = combinations(denominations, r);
            System.out.println(Arrays.toString(new List[]{combinationsList}));
            for (List<Integer> d : combinationsList) {
                System.out.println("B");
                coinCnt = minCoins(d, amount);
                if (coinCnt >= 0) {
                    System.out.println("C");
                    minCoins = Math.min(minCoins, coinCnt);
                    isChange = true;
                }
            }
        }
        return isChange ? minCoins : -1;
    }
}

public class Day311_2021 {
    public static void main(String[] args) {
        SolutionDay311 solution = new SolutionDay311();
        int[] inputC;
        int inputA;
        int result;

        List<List<Integer>> lli = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(2);
        lli.add(li);
        li = new ArrayList<>();
        lli.add(li);
        PrintUtils.printListListInt(lli);
        System.out.println();

        // Example 1
        inputC = new int[]{1, 2, 5};
        inputA = 11;
        result = solution.coinChange(inputC, inputA);
        System.out.println("3 == " + result);

        // Example 2
        inputC = new int[]{2};
        inputA = 3;
        result = solution.coinChange(inputC, inputA);
        System.out.println("-1 == " + result);

        // Example 3
        inputC = new int[]{1};
        inputA = 0;
        result = solution.coinChange(inputC, inputA);
        System.out.println("0 == " + result);

        // Example 4
        inputC = new int[]{1};
        inputA = 1;
        result = solution.coinChange(inputC, inputA);
        System.out.println("1 == " + result);

        // Example 5
        inputC = new int[]{1};
        inputA = 2;
        result = solution.coinChange(inputC, inputA);
        System.out.println("2 == " + result);

        // Test Case 1
        inputC = new int[]{186, 419, 83, 408};
        inputA = 6249;
        result = solution.coinChange(inputC, inputA);
        System.out.println("20 == " + result);
    }
}
