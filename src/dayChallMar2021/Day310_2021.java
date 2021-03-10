package dayChallMar2021;

class SolutionDay310 {
    // Contraint: 1 <= num <= 3999
    public String intToRoman(int num) {
        StringBuilder sB = new StringBuilder();
        while (num / 1000 > 0) {
            sB.append('M');
            num -= 1000;
        }
        if (num / 900 > 0) {
            sB.append("CM");
            num -= 900;
        }
        if (num / 500 > 0) {
            sB.append('D');
            num -= 500;
        }
        if (num / 400 > 0) {
            sB.append("CD");
            num -= 400;
        }
        while (num / 100 > 0) {
            sB.append('C');
            num -= 100;
        }
        if (num / 90 > 0) {
            sB.append("XC");
            num -= 90;
        }
        if (num / 50 > 0) {
            sB.append('L');
            num -= 50;
        }
        if (num / 40 > 0) {
            sB.append("XL");
            num -= 40;
        }
        while (num / 10 > 0) {
            sB.append('X');
            num -= 10;
        }
        if (num / 9 > 0) {
            sB.append("IX");
            num -= 9;
        }
        while (num / 5 > 0) {
            sB.append('V');
            num -= 5;
        }
        if (num / 4 > 0) {
            sB.append("IV");
            num -= 4;
        }
        while (num / 1 > 0) {
            sB.append('I');
            num -= 1;
        }
        return sB.toString();
    }
}

public class Day310_2021 {
    public static void main(String[] args) {
        SolutionDay310 solution = new SolutionDay310();
        int input;
        String result;

        // Example 1
        input = 3;
        result = solution.intToRoman(input);
        System.out.println("III == "+result);

        // Example 2
        input = 4;
        result = solution.intToRoman(input);
        System.out.println("IV == "+result);

        // Example 3
        input = 9;
        result = solution.intToRoman(input);
        System.out.println("IX == "+result);

        // Example 4
        input = 58;
        result = solution.intToRoman(input);
        System.out.println("LVIII == "+result);

        // Example 5
        input = 1994;
        result = solution.intToRoman(input);
        System.out.println("MCMXCIV == "+result);
    }
}
