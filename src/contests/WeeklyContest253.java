package contests;

import java.util.ArrayList;
import java.util.Collections;

class SolutionWC253 {
    public boolean isPrefixString_1stTry(String s, String[] words) {
        if (s == null || words == null) return false;
        if (s.length() == 0) return true;
        int k = -1, sum = 0, sLen = s.length();
        ArrayList<String> sA = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            sA.add(words[i]);
            sum += words[i].length();
            if (sum == sLen) {
                k = i + 1;
                break;
            } else if (sum > sLen)
                return false;
        }
        if (k == -1)
            return false;
        Collections.sort(sA);
        Collections.reverse(sA);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - i; j++) {
                if (s.startsWith(sA.get(j))) {
                    s = s.substring(sA.remove(j).length());
                    break;
                }
            }
        }
        return sA.size() == 0;
    }

    public boolean isPrefixString(String s, String[] words) {
        if (s == null || words == null) return false;
        if (s.length() == 0) return true;
        String sx = "";
        for (int i = 0; i < words.length; i++) {
            sx += words[i];
            if (sx.length()==s.length() && sx.startsWith(s)) return true;
        }
        return false;
    }
    public int minStoneSum(int[] piles, int k) {
        if (piles==null) return 0;
        ArrayList<Integer> IA = new ArrayList<>();
        for (int i:piles) IA.add(i);
        Collections.sort(IA);
        int last=IA.size()-1;
        int val;
        for (int i=0; i<k; i++) {
            val=IA.remove(last);
            IA.add(val - val/2);
            Collections.sort(IA);
        }
        int sum =0;
        for (int i:IA)
            sum+=i;
        return sum;
    }
}

public class WeeklyContest253 {
    public static void main(String[] args) {
        SolutionWC253 solution = new SolutionWC253();
        int[] inputIA;
        int inputI;
        int resultI;

        // Example 1
        inputIA=new int[]{5,4,9};
        inputI=2;
        resultI = solution.minStoneSum(inputIA,inputI);
        System.out.println("12 == " + resultI);

        // Example 2
        inputIA=new int[]{4,3,6,7};
        inputI=3;
        resultI = solution.minStoneSum(inputIA,inputI);
        System.out.println("12 == " + resultI);

        ///////////////////////////////////////////////
        String inputS;
        String[] inputSA;
        Boolean resultB;

        // Example 1
        inputS = "iloveleetcode";
        inputSA = new String[]{"i", "love", "leetcode", "apples"};
        resultB = solution.isPrefixString(inputS, inputSA);
        System.out.println("true == " + resultB);

        // Example 2
        inputS = "iloveleetcode";
        inputSA = new String[]{"apples", "i", "love", "leetcode"};
        resultB = solution.isPrefixString(inputS, inputSA);
        System.out.println("false == " + resultB);
    }
}
