package dayChall202104;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SolutionDay407 {
    int matchCount(Pattern p, String str) {
        Matcher m = p.matcher(str);
        int cnt = 0;
        while (m.find()) {
            cnt++;
        }
        return cnt;
    }

    public boolean halvesAreAlike(String s) {
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        String regex = "[aeiouAEIOU]";
        Pattern p = Pattern.compile(regex);
        return matchCount(p, s1) == matchCount(p,s2);
    }
}

public class Day407_2021 {
    public static void main(String[] args) {
        SolutionDay407 solution = new SolutionDay407();
        String inputS;
        boolean result;

        // Example 1
        inputS = "book";
        result = solution.halvesAreAlike(inputS);
        System.out.println("true == " + result);

        // Example 2
        inputS = "textbook";
        result = solution.halvesAreAlike(inputS);
        System.out.println("false == " + result);

        // Example 3
        inputS = "MerryChristmas";
        result = solution.halvesAreAlike(inputS);
        System.out.println("false == " + result);

        // Example 4
        inputS = "AbCdEfGh";
        result = solution.halvesAreAlike(inputS);
        System.out.println("true == " + result);
    }
}
