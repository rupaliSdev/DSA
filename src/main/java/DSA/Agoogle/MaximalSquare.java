package DSA.Agoogle;

public class MaximalSquare {

    //https://algo.monster/liteproblems/221
    public static void main(String[] args) {

       char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }

    //https://leetcode.com/problems/maximal-square/submissions/1994209275/
    public static int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];
        int maxSideLength = 0;
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols; j++) {

                if (matrix[i][j] == '1') {

                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }
                maxSideLength = Math.max(maxSideLength, dp[i + 1][j + 1]);
            }
        }
        return maxSideLength * maxSideLength;

    }
}
