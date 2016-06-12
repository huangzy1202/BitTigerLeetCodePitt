package dp;
/**
 * @author depeng
 * leetcode link: https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2D {
	private int[][] sums;
    
    public RangeSumQuery2D(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            //throw new IllegalArgumentException("Illegal matrix parameter was found.");
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.sums = new int[rows + 1][cols + 1];
        for(int i = 0; i <= rows; i++) {
            sums[i][0] = 0;
        }
        for(int j = 0; j <= cols; j++) {
            sums[0][j] = 0;
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sums == null) {
            return 0;
        }
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}