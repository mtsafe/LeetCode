package dayChall202102;

class SolutionDay101 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int hW = 0;
        if (n < 0)
            hW++;
        int mask = 1;
        for (int i = 0; i<31; i++){
            if ( ((n>>>i) & mask) != 0)
                hW++;
        }
        return hW;
    }
}

public class Day101_2021 {
    public static void main(String[] args) {
        SolutionDay101 solution = new SolutionDay101();
        System.out.println("2 == "+solution.hammingWeight(3));
        System.out.println("3 == "+solution.hammingWeight(11));
        System.out.println("1 == "+solution.hammingWeight(16));
        System.out.println("31 == "+solution.hammingWeight(-3));
    }
}
