public class uniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        // 1. 状态表达式: D[i][j]: 代表从起点到这一点的所有的路径数目
        // 2. 递推公式:   D[i][j] = D[i - 1][j] + D[i][j - 1]
        // 3. 初始化: D[0][0] = 1 原x点只有一种方法到达
        
        int[][] result = new int[m][n];
        
        // initiate.
        result[0][0] = 1;
        
        // initiate the first line
        for (int j = 1; j < n; j++) {
            result[0][j] = result[0][j - 1];
        }
        
        // initiate the first column
        for (int i = 1; i < m; i++) {
            result[i][0] = result[i - 1][0];
        }
        
        // get the result.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];    
            }
        }
        return result[m - 1][n - 1];
    }
}
