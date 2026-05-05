package DSA.AMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {

    /*  (0,0) (0,1) (0,2)

              (1,0) (1,1) (1,2)

              (2,0) (2,1) (2,2)*/
    public static void main(String[] args) {
        System.out.println(spiralMatrixIII(5, 6, 1, 4));
    }

    //https://leetcode.com/problems/spiral-matrix-iii/description/
    public static int[][] spiralMatrixIII(int rows, int cols, int row, int col) {
        int n = rows, m = cols;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[n * m][2];
        int step = 1, idx = 0;
        result[idx++] = new int[]{row, col};
        while (idx < n * m) {
            for (int d = 0; d < 4; d++) {
                for (int s = 1; s <= step; s++) {
                    row += dirs[d][0];
                    col += dirs[d][1];
                    if ((row >= 0 && row < n) && (col >= 0 && col < m)) {
                        System.out.println("(" + row + "," + col + "),");
                        result[idx++] = new int[]{row, col};
                    }
                }
                if (d % 2 == 1) {
                    step++;
                }
            }
        }
        return result;
    }


}
