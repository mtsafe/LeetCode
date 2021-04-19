package dayChall202102;

import java.util.ArrayList;
import java.util.List;

class SolutionDay116 {

    public List<String> letterCasePermutation(String S) {
        if (S == null)
            return null;
        List<String> downList;
        if (S.length() != 1)
            downList = letterCasePermutation(S.substring(1));
        else {
            downList = new ArrayList<>();
            downList.add("");
        }

        List<String> result = new ArrayList<>();
        Character ch;
        for (String str: downList) {
            ch = Character.toLowerCase(S.charAt(0));
            result.add(ch + str);
            if (Character.isLowerCase(ch))
                result.add(Character.toUpperCase(ch) + str);
        }
        return result;
    }
}

public class Day116_2021 {
    public static void main(String[] args) {
        SolutionDay116 solution = new SolutionDay116();
        String input;
        List<String> result;

        // Trivial 1
        input = "a";
        result = solution.letterCasePermutation(input);
        System.out.println("[\"a\",\"A\"] == "+result);

        // Trivial 2
        input = "A";
        result = solution.letterCasePermutation(input);
        System.out.println("[\"a\",\"A\"] == "+result);

        // Example 1
        input = "a1b2";
        result = solution.letterCasePermutation(input);
        System.out.println("[\"a1b2\",\"a1B2\",\"A1b2\",\"A1B2\"] == "+result);

        // Example 2
        input = "3z4";
        result = solution.letterCasePermutation(input);
        System.out.println("[\"3z4\",\"3Z4\"] == "+result);

        // Example 3
        input = "12345";
        result = solution.letterCasePermutation(input);
        System.out.println("[\"12345\"] == "+result);

        // Example 4
        input = "0";
        result = solution.letterCasePermutation(input);
        System.out.println("[\"0\"] == "+result);
    }
}
