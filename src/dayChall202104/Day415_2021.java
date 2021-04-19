package dayChall202104;

class SolutionDay415 {
    public int fib(int n) {
        if (n<1) return 0;
        if (n==1) return 1;
        return fib(n-1) + fib (n-2);
    }
}

public class Day415_2021 {
    public static void main(String[] args) {
        SolutionDay415 solution = new SolutionDay415();
        int inputN;
        int result;

        // Example 1
        inputN = 2;
        result = solution.fib(inputN);
        System.out.println("1 == "+result);

        // Example 2
        inputN = 3;
        result = solution.fib(inputN);
        System.out.println("2 == "+result);

        // Example 3
        inputN = 4;
        result = solution.fib(inputN);
        System.out.println("3 == "+result);

        // Edge 0
        inputN = 0;
        result = solution.fib(inputN);
        System.out.println("0 == "+result);

        // Edge 30
        inputN = 30;
        result = solution.fib(inputN);
        System.out.println("832040 == "+result);
    }
}
