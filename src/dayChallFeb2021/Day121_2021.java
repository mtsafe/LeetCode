package dayChallFeb2021;

class SolutionDay121 {
    public int brokenCalc_1stTry(int X, int Y) {
        if (X > Y)
            return X - Y;
        int opsUsed = 0;
        while (X != Y) {
            while (X < Y) {
                X *= 2;
                System.out.print(X + " ");
                opsUsed++;
            }
            if (X > Y) {
                if (X - 1 == Y)
                    return ++opsUsed;
                X /= 2;
                X--;
                System.out.print(X + " ");
            }
            if (opsUsed > 39)
                return opsUsed;
        }
        return opsUsed;
    }

    private int calc(int X, int twos, int[] a) {
        if (a == null)
            return X;
        int sum = X - a[0];
        for (int i = 1; i <= twos; i++) {
            sum = 2 * sum - a[i];
        }
        return sum;
    }

    public int brokenCalc(int X, int Y) {
        if (X > Y)
            return X - Y;
        int tmp = X;
        int opsUsed = 0;
        while (tmp < Y) {
            tmp *= 2;
            opsUsed++;
        }
        int twos = opsUsed;
        int[] a = new int[twos + 1];
        for (int i = 0; i <= twos; i++) {
            while (calc(X, twos, a) > Y) {
                a[i] += 1;
                opsUsed++;
            }
            if (calc(X, twos, a) == Y)
                break;
            a[i] -= 1;
            opsUsed--;
        }
        return opsUsed;
    }
}

public class Day121_2021 {
    public static void main(String[] args) {
        SolutionDay121 solution = new SolutionDay121();
        int inputX, inputY;
        int result;

        // Trivial 1
        inputX = 2;
        inputY = 2;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("0 == " + result);

        // Edge 1
        inputX = 1;
        inputY = 1;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("0 == " + result);

        // Edge 2
        inputX = 1000000000;
        inputY = 1000000000;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("0 == " + result);

        // Edge 3
        inputX = 1000000000;
        inputY = 1;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("999999999 == " + result);

        // Edge 4
        inputX = 1;
        inputY = 1000000000;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("39 == " + result);

        // Example 1
        inputX = 2;
        inputY = 3;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("2 == " + result);

        // Example 2
        inputX = 5;
        inputY = 8;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("2 == " + result);

        // Example 3
        inputX = 3;
        inputY = 10;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("3 == " + result);

        // Example 4
        inputX = 1024;
        inputY = 1;
        result = solution.brokenCalc(inputX, inputY);
        System.out.println("1023 == " + result);
    }
}
