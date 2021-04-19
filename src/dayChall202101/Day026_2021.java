package dayChall202101;

class SolutionDay026 {
    class TerrainNode {
        int height;
        boolean visited;
    }
    class Terrain {
        TerrainNode[][] terrain;
        Terrain(int[][]map) {
            terrain = new TerrainNode[map.length][map[0].length];
            for (int i = 0; i < map.length; i++)
                for (int j = 0; j < map.length; j++) {
                    terrain[i][j].height = map[i][j];
                    terrain[i][j].visited = false;
                }
        }
    }
    private int effort(int[][] map, int x1, int y1, int x2, int y2) {
        return Math.abs(map[x1][y1] - map[x2][y2]);
    }

    public int minimumEffortPath(int[][] heights) {
        Terrain terrain = new Terrain(heights);
        return 1;
    }
}

public class Day026_2021 {
    public static void main(String[] args) {
        SolutionDay026 solution = new SolutionDay026();
        int result;
        int[][] input;
        input = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
        result = solution.minimumEffortPath(input);
    }
}
