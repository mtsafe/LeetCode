package dayChall202103;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class SolutionDay312 {
    private List<String> allCodes(int k) {
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < k; i++) {
            List<String> newList = new ArrayList<>();
            for (String s : list) {
                newList.add(s + "0");
                newList.add(s + "1");
            }
            list = newList;
        }
        return list;
    }

    // 1stTry is too slow
    public boolean hasAllCodes_1stTry(String s, int k) {
        List<String> codes = allCodes(k);
        for (String code : codes) {
            if (!s.contains(code)) return false;
        }
        return true;
    }

    public boolean hasAllCodes(String s, int k) {
        if (s == null)
            return false;
        int maxCodeCnt = (int) Math.pow(2, k);
        if (s.length() < k + maxCodeCnt - 1)
            return false;
        HashSet<String> hash = new HashSet<>();
        int len = s.length();
        String code;
        for (int i = 0; i < len - k + 1; i++) {
            code = s.substring(i, i + k);
            hash.add(code);
            if (hash.size() == maxCodeCnt)
                return true;
        }
        return false;
    }
}

public class Day312_2021 {
    public static void main(String[] args) {
        SolutionDay312 solution = new SolutionDay312();
        String inputS;
        int inputK;
        boolean result;

        // Example 1
        inputS = "00110110";
        inputK = 2;
        result = solution.hasAllCodes(inputS, inputK);
        System.out.println("true == " + result);

        // Example 2
        inputS = "00110";
        inputK = 2;
        result = solution.hasAllCodes(inputS, inputK);
        System.out.println("true == " + result);

        // Example 3
        inputS = "0110";
        inputK = 1;
        result = solution.hasAllCodes(inputS, inputK);
        System.out.println("true == " + result);

        // Example 4
        inputS = "0110";
        inputK = 2;
        result = solution.hasAllCodes(inputS, inputK);
        System.out.println("false == " + result);   // Too short

        // Example 5
        inputS = "0000000001011100";
        inputK = 4;
        result = solution.hasAllCodes(inputS, inputK);
        System.out.println("false == " + result);   // Too short
    }

}
