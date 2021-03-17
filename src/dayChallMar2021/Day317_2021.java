package dayChallMar2021;

class SolutionDay317 {

    double radius;
    double x_center;
    double y_center;

    public SolutionDay317(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double x_rand = 1.0;
        double y_rand = 1.0;
        while (1.0 <= Math.pow(x_rand, 2.0) + Math.pow(x_rand, 2.0)) {
            x_rand = 2.0 * Math.random() - 1.0;
            y_rand = 2.0 * Math.random() - 1.0;
        }

        double[] point = new double[2];
        point[0] = radius * x_rand + x_center;
        point[1] = radius * y_rand + y_center;
        return point;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */

public class Day317_2021 {
    public static void main(String[] args) {
        SolutionDay317 solution;
        double[] p;

        // Test 1
        solution = new SolutionDay317(1.0, 0.0, 0.0);
        p = solution.randPoint();
        System.out.println("["+p[0]+", "+p[1]+"]");

        // Test 2
        solution = new SolutionDay317(0.01, 0.0, 0.0);
        p = solution.randPoint();
        System.out.println("["+p[0]+", "+p[1]+"]");

        // Test 3
        solution = new SolutionDay317(1000.0, 0.0, 0.0);
        p = solution.randPoint();
        System.out.println("["+p[0]+", "+p[1]+"]");

        // Test 4
        solution = new SolutionDay317(1.0, 1000.0, 1000.0);
        p = solution.randPoint();
        System.out.println("["+p[0]+", "+p[1]+"]");

        // Test 5
        solution = new SolutionDay317(100.0, 1000.0, 1000.0);
        p = solution.randPoint();
        System.out.println("["+p[0]+", "+p[1]+"]");
    }
}
