package DSA.Agoogle;

import java.util.*;

public class PacificAtlanticWaterFlow {

    //https://leetcode.com/problems/pacific-atlantic-water-flow/description/
    //https://algo.monster/liteproblems/417


    /*There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

*/

    public static void main(String[] args) {
        int heights[][] = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {


        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        Set<Integer> pacificVisited = new HashSet<>();
        Set<Integer> atlanticVisited = new HashSet<>();

        int rows = heights.length, cols = heights[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    pacific.offer(new int[]{i, j});
                    pacificVisited.add(i * cols + j);
                }
                if (i == rows - 1 || j == cols - 1) {
                    atlantic.offer(new int[]{i, j});
                    atlanticVisited.add(i * cols + j);
                }
            }
        }

        bfs(pacificVisited,pacific,heights);
        bfs(atlanticVisited,atlantic,heights);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer cell :pacificVisited){
            if(atlanticVisited.contains(cell)){
                List<Integer> temp = new ArrayList<>();
                temp.add(cell/cols);
                temp.add(cell% cols);
                res.add(temp);
            }

        }


        return res;
    }

    private static void bfs(Set<Integer> visited, Queue<int[]> queue, int[][] heights) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];
                for (int[] d : dirs) {
                    int cRow = row + d[0];
                    int cCol = col + d[1];
                    int encodedPos = cRow * heights[0].length + cCol;
                    if (cRow >= 0 && cCol >= 0 && cRow < heights.length && cCol < heights[0].length && !visited.contains(encodedPos)
                    && heights[cRow][cCol]>= heights[row][col]) {
                        queue.offer(new int[]{cRow, cCol});
                        visited.add(encodedPos);
                    }
                }
            }
        }
    }
}
