package contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SolutionWC231 {
    public boolean checkOnesSegment(String s) {
        if (s == null)
            return false;
        char[] chars = s.toCharArray();
        char prev = '1';
        for (char ch : chars) {
            if (prev == '0' && ch == '1')
                return false;
            prev = ch;
        }
        return true;
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long newGoal;
        newGoal = Math.abs(goal - sum);
        long result = newGoal / limit;
        return newGoal % limit == 0 ? (int) result : (int) result + 1;
    }

    private class undWtConG {
        int n;
        int distance;
        HashMap<undWtConG, Integer> children; // <child, weight>

        undWtConG(int n) {
            this.n = n;
            distance = -1;
            children = new HashMap<>();
        }
    }

    private int maxNode;
    private HashMap<Integer, undWtConG> graphNodes;
    private HashMap<Integer, Integer> distHash;

    private int distanceToLastNode(int n, List<Integer> visited) {
        if (distHash.containsKey(n))
            return distHash.get(n);
        int minDistance = Integer.MAX_VALUE;
        for (undWtConG child : graphNodes.get(n).children.keySet()) {
            if (visited.contains(child.n))
                continue;
            visited.add(child.n);
            child.distance = distanceToLastNode(child.n, visited);
            if (minDistance > child.distance + graphNodes.get(n).children.get(child))
                minDistance = child.distance + graphNodes.get(n).children.get(child);
        }
        return minDistance;
    }

    private void buildUndirectedWeightedConnectedGraph(int[][] edges) {
        for (int i = 1; i <= maxNode; i++) {
            graphNodes.put(i, new undWtConG(i));
        }
        undWtConG nodeA, nodeB;
        int weight;
        for (int i = 0; i <= edges.length - 1; i++) {
            nodeA = graphNodes.get(edges[i][0]);
            nodeB = graphNodes.get(edges[i][1]);
            weight = edges[i][2];
            nodeA.children.put(nodeB, weight);
            nodeB.children.put(nodeA, weight);
        }
    }

    private int validPathCnt(undWtConG root) {
        if (root == null) {
            System.out.println("validPathCnt(null);");
            return 0;
        }
        if (root.n == maxNode)
            return 1;
        int pathCnt = 0;
        for (undWtConG child : root.children.keySet()) {
            if (root.distance <= child.distance)
                continue;
            pathCnt += validPathCnt(child);
        }
        return pathCnt;
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (edges == null) return 0;
        distHash = new HashMap<>();
        graphNodes = new HashMap<>();
        maxNode = n;
        buildUndirectedWeightedConnectedGraph(edges);
        distHash.put(n, 0);
        distanceToLastNode(1, new ArrayList<>());
        return validPathCnt(graphNodes.get(0));
    }
}

public class WeeklyContest231 {
    public static void main(String[] args) {
        SolutionWC231 solution = new SolutionWC231();
        int n;
        int[][] edges;
        int cRPResult;

        // Trivial 1
        n = 1;
        edges = null;
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("1 == " + cRPResult);

        // Trivial 2
        n = 1;
        edges = new int[][]{null};
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("1 == " + cRPResult);

        // Trivial 3
        n = 2;
        edges = null;
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("0 == " + cRPResult);

        // Trivial 4
        n = 0;
        edges = new int[][]{{}};
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("0 == " + cRPResult);

        // Trivial 5
        n = 1;
        edges = new int[][]{{}};
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("1 == " + cRPResult);

        // Trivial 6
        n = 2;
        edges = new int[][]{{1,2,1}};
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("1 == " + cRPResult);

        // Trivial 7
        n = 4;
        edges = new int[][]{{1,2,2},{1,3,2},{2,4,1},{3,4,1}};
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("2 == " + cRPResult);

        // Example 1
        n = 5;
        edges = new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1},
                {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}};
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("3 == " + cRPResult);

        // Example 2
        n = 7;
        edges = new int[][]{{1, 3, 1}, {4, 1, 2}, {7, 3, 4},
                {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}};
        cRPResult = solution.countRestrictedPaths(n, edges);
        System.out.println("1 == " + cRPResult);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
        int[] nums;
        int limit, goal;
        int mEResult;

        // Example 1
        nums = new int[]{1, -1, 1};
        limit = 3;
        goal = -4;
        mEResult = solution.minElements(nums, limit, goal);
        System.out.println("2 == " + mEResult);

        // Example 2
        nums = new int[]{1, -10, 9, 1};
        limit = 100;
        goal = 0;
        mEResult = solution.minElements(nums, limit, goal);
        System.out.println("1 == " + mEResult);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
        String s;
        boolean result;

        // Example 1
        s = "1001";
        result = solution.checkOnesSegment(s);
        System.out.println("false == " + result);

        // Example 2
        s = "110";
        result = solution.checkOnesSegment(s);
        System.out.println("true == " + result);

        // Test 1
        s = "1";
        result = solution.checkOnesSegment(s);
        System.out.println("true == " + result);

        // Test 2
        s = "10";
        result = solution.checkOnesSegment(s);
        System.out.println("true == " + result);
    }
}
