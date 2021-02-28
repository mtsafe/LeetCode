package contests;

import java.util.ArrayList;
import java.util.List;

class SolutionWC230 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int sum = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    if (ruleValue.equals(item.get(0)))
                        sum++;
                    break;
                case "color":
                    if (ruleValue.equals(item.get(1)))
                        sum++;
                    break;
                case "name":
                    if (ruleValue.equals(item.get(2)))
                        sum++;
                    break;
            }
        }
        return sum;
    }

    private int chooseBest(int target, int best, int next) {
        if (Math.abs(target - best) > Math.abs(target - next))
            return next;
        if (Math.abs(target - best) < Math.abs(target - next))
            return best;
        return Math.min(best, next);
    }

    private int chooseToppings(int[] costs, int target) {
        if (costs == null || target <= 0)
            return target;
        int[][] toppingCosts = new int[costs.length][3];
        for (int i = 0; i < costs.length; i++)
        for (int j = 0; j < 3; j++)
            toppingCosts[i][j] = j * costs[i];

        int best = Integer.MAX_VALUE;
        int num;
        for (int x = 0; x<costs.length; x++)
            for (int y = 0; y<3; y++)
                num =(int) Math.pow(3, x) + y;
            // WRONG WRONG WRONG


        for (int a = 0; a < costs.length - 2; a++)
            for (int b = a+1; b < costs.length - 1; b++)
                for (int c = b+1; c < costs.length; c++) {

                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            for (int k = 0; k < 2; k++)
                                if (toppingCosts[a][i] +
                                        toppingCosts[b][j] +
                                        toppingCosts[c][k] > 0)
                                    best = toppingCosts[a][i] +
                                            toppingCosts[b][j] +
                                            toppingCosts[c][k];
                    // WRONG WRONG WRONG
                }
        return best;
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        if (baseCosts == null || toppingCosts == null)
            return 0;
        int bestCost = 0;
        int bestToppings = 0;
        for (int base : baseCosts) {
            bestToppings = chooseToppings(toppingCosts, target - base);
            bestCost = chooseBest(target, bestCost, base + bestToppings);
        }
        return 0;
    }
}

public class WeeklyContest230 {
    public static void main(String[] args) {
        SolutionWC230 solution = new SolutionWC230();
        List<List<String>> inputItems;
        String inputRuleKey;
        String inputRuleValue;
        int result;

        List<String> foo;

        inputItems = new ArrayList<>();
        foo = new ArrayList<>();
        foo.add("phone");
        foo.add("blue");
        foo.add("pixel");
        inputItems.add(foo);
        foo = new ArrayList<>();
        foo.add("computer");
        foo.add("silver");
        foo.add("lenovo");
        inputItems.add(foo);
        foo = new ArrayList<>();
        foo.add("phone");
        foo.add("gold");
        foo.add("iphone");
        inputItems.add(foo);
        inputRuleKey = "color";
        inputRuleValue = "silver";
        result = solution.countMatches(inputItems, inputRuleKey, inputRuleValue);
        System.out.println("1 == " + result);

        inputRuleKey = "type";
        inputRuleValue = "phone";
        result = solution.countMatches(inputItems, inputRuleKey, inputRuleValue);
        System.out.println("2 == " + result);

        // PROBLEM #2
        //public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] inputBaseCosts;
        int[] inputToppingCosts;
        int inputTarget;

        // Example 1
        inputBaseCosts = new int[]{1, 7};
        inputToppingCosts = new int[]{3, 4};
        inputTarget = 10;
        result = solution.closestCost(inputBaseCosts, inputToppingCosts, inputTarget);
        System.out.println("10 == " + result);

        // Example 2
        inputBaseCosts = new int[]{2, 3};
        inputToppingCosts = new int[]{4, 5, 100};
        inputTarget = 18;
        result = solution.closestCost(inputBaseCosts, inputToppingCosts, inputTarget);
        System.out.println("17 == " + result);

        // Example 3
        inputBaseCosts = new int[]{3, 10};
        inputToppingCosts = new int[]{2, 5};
        inputTarget = 9;
        result = solution.closestCost(inputBaseCosts, inputToppingCosts, inputTarget);
        System.out.println("8 == " + result);

        // Example 4
        inputBaseCosts = new int[]{10};
        inputToppingCosts = new int[]{1};
        inputTarget = 1;
        result = solution.closestCost(inputBaseCosts, inputToppingCosts, inputTarget);
        System.out.println("10 == " + result);
    }
}
