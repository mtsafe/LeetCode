package dayChallFeb2021;

class SolutionDay114 {
    private boolean[] visited;
    int[] subsetValues;

    private int otherSubgraph(int subgraph) {
        if (subgraph == 1)
            return 2;
        return 1;
    }

    public boolean verifyEdges(int[] node, int nodeNum) {
        if (node == null)
            return false;
        for (int edgeNum = 0; edgeNum < node.length; edgeNum++) {
            if (subsetValues[node[edgeNum]] == 0) {
                subsetValues[node[edgeNum]] = otherSubgraph(subsetValues[nodeNum]);
            } else if (subsetValues[node[edgeNum]] == subsetValues[nodeNum]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        if (graph == null)
            return false;
        visited = new boolean[graph.length];
        subsetValues = new int[graph.length];
        subsetValues[0] = 1;
        boolean skipped = true;
        while (skipped) {
            skipped = false;
            for (int nodeNum = 0; nodeNum < graph.length; nodeNum++) {
                if (subsetValues[nodeNum] == 0 &&
                        graph[nodeNum].length == 0) {
                    subsetValues[nodeNum] = 2;
                    skipped = true;
                    continue;
                }
                if (!verifyEdges(graph[nodeNum], nodeNum))
                    return false;
            }
        }
        return true;
    }
}

public class Day114_2021 {
    public static void main(String[] args) {
        SolutionDay114 solution = new SolutionDay114();
        int[][] input;
        boolean result;

        // Trivial 1
        input = null;
        result = solution.isBipartite(input);
        System.out.println("false == " + result);

        // Trivial 2
        input = new int[][]{{}};
        result = solution.isBipartite(input);
        System.out.println("true == " + result);

        // Trivial 3
        input = new int[][]{{}, {}};
        result = solution.isBipartite(input);
        System.out.println("true == " + result);

        // Test 1
        input = new int[][]{{}, {}, {3}, {2}};
        result = solution.isBipartite(input);
        System.out.println("true == " + result);

        // Example 1
        input = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        result = solution.isBipartite(input);
        System.out.println("true == " + result);

        // Example 2
        input = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        result = solution.isBipartite(input);
        System.out.println("false == " + result);

        // Testcase 1
        input = new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}};
        result = solution.isBipartite(input);
        System.out.println("true == " + result);

        // Testcase 2
        input = new int[][]{{1}, {0, 3}, {3}, {1, 2}};
        result = solution.isBipartite(input);
        System.out.println("true == " + result);
    }
}
