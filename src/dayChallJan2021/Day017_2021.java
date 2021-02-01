package dayChallJan2021;

class SolutionDay017 {
    private int count(int n, char last_character) {
        if (n == 0) return 1;
        int theCnt = 0;
        if (n == 1)
            switch (last_character) {
                case 'u':
                    theCnt++;
                case 'o':
                    theCnt++;
                case 'i':
                    theCnt++;
                case 'e':
                    theCnt++;
                case 'a':
                    theCnt++;
            }
        else
            switch (last_character) {
                case 'u':
                    theCnt += count(n - 1, 'u');
                case 'o':
                    theCnt += count(n - 1, 'o');
                case 'i':
                    theCnt += count(n - 1, 'i');
                case 'e':
                    theCnt += count(n - 1, 'e');
                case 'a':
                    theCnt += count(n - 1, 'a');
            }
        return theCnt;
    }

    public int countVowelStrings(int n) {
        int theCnt = 0;
        for (char ch : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            theCnt += count(n-1, ch);
        }
        return theCnt;
    }
}

public class Day017_2021 {
    public static void main(String[] args) {
        SolutionDay017 solution = new SolutionDay017();
        int result = solution.countVowelStrings(1);
        System.out.println(result);
        result = solution.countVowelStrings(2);
        System.out.println(result);
        result = solution.countVowelStrings(33);
        System.out.println(result);
    }
}
