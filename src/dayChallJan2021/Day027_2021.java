package dayChallJan2021;

import java.math.BigInteger;

class SolutionDay027_FIRSTTRY {
    private StringBuilder intToBinStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            if (n % 2 == 0)
                result.insert(0, "0");
            else
                result.insert(0, "1");
            n /= 2;
        }
        return result;
    }

    protected void borrow(StringBuilder bin, int index) {
        int fromThis = index - 1;
        while (bin.charAt(fromThis) == '0' && fromThis >= 0)
            fromThis--;
        if (fromThis < 0)
            return;
        bin.setCharAt(fromThis++, '0');
        while (fromThis != index)
            bin.setCharAt(fromThis++, '1');
        bin.setCharAt(fromThis, '2');
    }

    private void noLeadZero(StringBuilder sb) {
        while (sb.charAt(0) == '0')
            sb.delete(0, 1);
    }

    private String padLeftSpaces(String str, int n) {
        return String.format("%1$" + n + "s", str);
    }

    private String binMod(String dividend, String divisor) {
        while (!(dividend.length() < divisor.length() ||
                dividend.length() == divisor.length() &&
                        dividend.compareTo(divisor) < 0)) {

//        System.out.println("dividend= "+padLeftSpaces(dividend, 40));
        System.out.println("divisor=  "+"          "+divisor);
            StringBuilder bigSB = new StringBuilder(dividend);
            StringBuilder smallSB = new StringBuilder(divisor);
//        System.out.println(dividend.substring(0, divisor.length()));
//        System.out.println(dividend.substring(0, divisor.length()).compareTo(divisor));
//        System.out.println(dividend.substring(0, divisor.length()).compareTo(divisor) < 0);
            if (dividend.substring(0, divisor.length()).compareTo(divisor) < 0)
                smallSB.insert(0, "0");
//        System.out.println("divisor=  "+"   "+smallSB);
            for (int i = smallSB.length() - 1; i >= 0; i--) {
                if (smallSB.charAt(i) == '1') {
                    if (bigSB.charAt(i) == '0') {
                        borrow(bigSB, i);
                        bigSB.setCharAt(i, '1');
                    } else
                        bigSB.setCharAt(i, '0');
                }
            }
            noLeadZero(bigSB);
//        System.out.println("after=    "+padLeftSpaces(bigSB.toString(), 40));
//        System.out.println();
            dividend = bigSB.toString();
//            return binMod(bigSB.toString(), divisor);
        }
        return dividend;
    }

    private int binStringToInt(String s) {
        long val = 0;
        String wrapNum = intToBinStringBuilder(1000000007).toString();
        String remainder = binMod(s, wrapNum);
        int maxI = remainder.length() - 1;
        for (int i = maxI; i >= 0; i--) {
            if (remainder.charAt(i) == '1') {
                val += Math.pow(2, maxI - i);
            }
        }
        return (int) val;
    }

    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(intToBinStringBuilder(i));
//            System.out.println(sb.toString());
        }
        return binStringToInt(sb.toString());
    }
}

class SolutionDay027 {
    private StringBuilder intToBinStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            if (n % 2 == 0)
                result.insert(0, "0");
            else
                result.insert(0, "1");
            n /= 2;
        }
        return result;
    }

    private int binStringToInt(String s) {
        long val = 0;
        BigInteger sBI = new BigInteger(s, 2);
        String wrapNum = intToBinStringBuilder(1000000007).toString();
        BigInteger wBI = new BigInteger(wrapNum, 2);
        BigInteger remainder = sBI.mod(wBI);
        return remainder.intValue();
    }

    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(intToBinStringBuilder(i));
        }
        return binStringToInt(sb.toString());
    }
}
public class Day027_2021 {
    public static void main(String[] args) {
        SolutionDay027 solution = new SolutionDay027();
        int result;
        result = solution.concatenatedBinary(1);
        System.out.println("1 == " + result);

        result = solution.concatenatedBinary(2);
        System.out.println("1 == " + result);

        result = solution.concatenatedBinary(3);
        System.out.println("27 == " + result);

//        StringBuilder output;
//        output = new StringBuilder("100011");
//        solution.borrow(output, 3);
//        System.out.println("100011 => " + output);

        result = solution.concatenatedBinary(12);
        System.out.println("505379714 == " + result);

        result = solution.concatenatedBinary(15);
        System.out.println("35297621 == " + result);

        result = solution.concatenatedBinary(6812);
        System.out.println("??? == " + result);

        result = solution.concatenatedBinary(8933);
        System.out.println("??? == " + result);

        result = solution.concatenatedBinary(72387);
        System.out.println("??? == " + result);

        result = solution.concatenatedBinary(100000);
        System.out.println("??? == " + result);
    }
}
