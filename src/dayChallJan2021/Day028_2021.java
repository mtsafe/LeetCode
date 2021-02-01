package dayChallJan2021;

class SolutionDay028 {
    public String getSmallestString(int n, int k) {
        int diff = k - n;
        int zs = diff / 25;
        diff %= 25;
        char[] chars = new char[n];
        for (int i = 0; i < n - zs - 1; i++) {
            chars[i] = 'a';
        }
        if (n - zs >= 1)
            chars[n - zs - 1] = (char) ((int) 'a' + diff);
        for (int i = n - zs; i < n; i++) {
            chars[i] = 'z';
        }
        return new String(chars);
    }
}

public class Day028_2021 {
    public static void main(String[] args) {
        SolutionDay028 solution = new SolutionDay028();
        String result;

        result = solution.getSmallestString(3, 27);
        System.out.println("aay == " + result);

        result = solution.getSmallestString(5, 73);
        System.out.println("aaszz == " + result);

        result = solution.getSmallestString(5, 130);
        System.out.println("zzzzz == " + result);
    }
}
