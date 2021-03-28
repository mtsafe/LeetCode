package contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SolutionWC234 {
    private String noLeadZeros(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == '0') i++;
        return str.substring(i, chars.length);
    }

    public int numDifferentIntegers(String word) {
        HashSet<String> hash = new HashSet<>();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("[0-9]+")
                .matcher(word);
        while (m.find()) {
            allMatches.add(m.group());
        }
        for (String str : allMatches) {
            hash.add(noLeadZeros(str));
        }
        return hash.size();
    }

    private HashMap<String, String> hashStringListList(List<List<String>> list) {
        HashMap<String, String> result = new HashMap<>();
        String key, value;
        for (List<String> kvPair : list) {
            key = kvPair.get(0);
            value = kvPair.get(1);
            result.put(key, value);
        }
        return result;
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hash = hashStringListList(knowledge);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean rep = false;
        int start = 0;
        String repStr;
        for (int i = 0; i < chars.length; i++) {
            if (!rep && chars[i] != '(') {
                sb.append(chars[i]);
                continue;
            }
            if (!rep && chars[i] == '(') {
                start = i + 1;
                rep = true;
                continue;
            }
            if (rep && chars[i] == ')') {
                repStr = s.substring(start, i);
                sb.append(hash.getOrDefault(repStr, "?"));
                rep = false;
            }
        }
        return sb.toString();
    }

    private int[] operate(int[] perm) {
        int[] arr = new int[perm.length];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) arr[i] = perm[i / 2];
            else arr[i] = perm[arr.length / 2 + (i - 1) / 2];
        }
        return arr;
    }

    private boolean diffArr(int[] arr, int[] perm) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != perm[i])
                return true;
        }
        return false;
    }

    public int reinitializePermutation(int n) {
        int opCnt = 0;
        int[] permInit = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            permInit[i] = i;
            perm[i] = i;
        }
        perm = operate(perm); opCnt++;
        while (diffArr(perm, permInit)) {
            perm = operate(perm); opCnt++;
        }
        return opCnt;
    }
}

public class WeeklyContest234 {
    public static void main(String[] args) {
        SolutionWC234 solution = new SolutionWC234();
        int inputN;
        int output;

        // Example 1
        inputN = 2;
        output = solution.reinitializePermutation(inputN);
        System.out.println(output);

        // Example 2
        inputN = 4;
        output = solution.reinitializePermutation(inputN);
        System.out.println(output);

        // Example 3
        inputN = 6;
        output = solution.reinitializePermutation(inputN);
        System.out.println(output);





        ////////////////////////////////////
        String inputS;
        List<List<String>> inputLLS;
        String evaluated;
        List<String> tmp;

        // Example 1
        inputS = "(name)is(age)yearsold";
        inputLLS = new ArrayList<>();
        tmp = new ArrayList<>();
        tmp.add("name");
        tmp.add("bob");
        inputLLS.add(tmp);
        tmp.add("age");
        tmp.add("two");
        inputLLS.add(tmp);
        System.out.println(solution.evaluate(inputS, inputLLS));

        ////////////////////////////////////
        String inputW;
        int result;

        // Example 1
        inputW = "a123bc34d8ef34";
        result = solution.numDifferentIntegers(inputW);
        System.out.println("3 == " + result);

        // Example 2
        inputW = "leet1234code234";
        result = solution.numDifferentIntegers(inputW);
        System.out.println("2 == " + result);

        // Example 3
        inputW = "a1b01c001";
        result = solution.numDifferentIntegers(inputW);
        System.out.println("1 == " + result);

        // Test 1
        inputW = "leet1234code01234";
        result = solution.numDifferentIntegers(inputW);
        System.out.println("1 == " + result);
    }
}
