package dayChallFeb2021;

import java.util.HashMap;

class SolutionDay120 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        int maxNum = 0;
        int sum = 0, val;
        char[] roman = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            val = hash.get(roman[i]);
            if (val >= maxNum) {
                maxNum = val;
                sum += val;
            } else {
                sum -= val;
            }
        }
        return sum;
    }
}

public class Day120_2021 {
    public static void main(String[] args) {
        SolutionDay120 solution = new SolutionDay120();
        String input;
        int result;

        // Trivial 1
        input = "I";
        result = solution.romanToInt(input);
        System.out.println("1 == "+result);

        // Trivial 2
        input = "V";
        result = solution.romanToInt(input);
        System.out.println("5 == "+result);

        // Trivial 3
        input = "X";
        result = solution.romanToInt(input);
        System.out.println("10 == "+result);

        // Example 1
        input = "III";
        result = solution.romanToInt(input);
        System.out.println("3 == "+result);

        // Example 2
        input = "IV";
        result = solution.romanToInt(input);
        System.out.println("4 == "+result);

        // Example 3
        input = "IX";
        result = solution.romanToInt(input);
        System.out.println("9 == "+result);

        // Example 4
        input = "LVIII";
        result = solution.romanToInt(input);
        System.out.println("58 == "+result);

        // Example 5
        input = "MCMXCIV";
        result = solution.romanToInt(input);
        System.out.println("1994 == "+result);
    }
}
