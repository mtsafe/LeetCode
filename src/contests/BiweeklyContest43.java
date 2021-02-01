package contests;

class SolutionBC43 {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int sevenDays = 1+2+3+4+5+6+7;
        int result = 0;
        System.err.println("7 days: "+sevenDays);
        System.err.println("days: "+days);
        for (int i = 1; i <= days; i++) {
            result += i + weeks;
            System.err.println(result);
        }
        System.err.println("weeks: "+weeks);
        for (int i = 0; i < weeks; i++) {
            result += i * 7 + sevenDays;
            System.err.println(result);
        }
        System.err.println("=================");
        return result;
    }

    private static class MaximumGainPair {
        String s;
        int result;
        MaximumGainPair(String s, int result) {
            this.s = s;
            this.result = result;
        }
    }

    private MaximumGainPair maximumGainRemover(String s, String pattern) {
        int result = 0;
        String sTmp;
        while (true) {
            System.err.println(s);
            sTmp = s;
            s = sTmp.replaceFirst(pattern, "");
            if (s.equals(sTmp))
                break;
            else
                result += 1;
        }
        return new MaximumGainPair(s, result);
    }

    public int maximumGain(String s, int x, int y) {
        int result = 0;
        MaximumGainPair mgp;
        if (x > y) {
            mgp = maximumGainRemover(s, "ab");
            result += x * mgp.result;
            mgp = maximumGainRemover(mgp.s, "ba");
            result += y * mgp.result;
        } else {
            mgp = maximumGainRemover(s, "ba");
            result += y * mgp.result;
            mgp = maximumGainRemover(mgp.s, "ab");
            result += x * mgp.result;
        }
        return result;
    }
}

public class BiweeklyContest43 {
    public static void main(String[] args) {
        SolutionBC43 solution = new SolutionBC43();
        System.out.println(solution.totalMoney(4));
//        System.out.println(solution.totalMoney(10));
//        System.out.println(solution.totalMoney(20));
        System.out.println(solution.maximumGain("cdbcbbaaabab",4,5));
        System.out.println(solution.maximumGain("aabbaaxybbaabb",5,4));
    }
}
