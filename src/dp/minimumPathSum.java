public class minimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }    
        
        // 表达式：  result[i][j]: 从左下到本点的最小值
        // 递推公式: result[i][j] = Math.mn(result[i - 1][j], result[i][j - 1]) + grid[i][j]
        // 初始化：  result[i][j] = grid[i][j].
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        
        result[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            result[0][j] = grid[0][j];
            result[0][j] += result[0][j - 1];
        }
        
        // initiate the first column
        for (int i = 1; i < m; i++) {
            result[i][0] = grid[i][0];
            result[i][0] += result[i - 1][0];
        }
        
        // get the result.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = grid[i][j]; 
                result[i][j] += Math.min(result[i - 1][j], result[i][j - 1]);    
            }
        }
        
        return result[m - 1][n - 1];
        
    }
}
