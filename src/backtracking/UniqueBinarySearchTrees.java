public class Solution {
    public int numTrees(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int number = 1; number <= n; number++) {
            for (int j = 0; j < number; j++) {
                dp[number] += dp[j] * dp[number - 1 - j];
            }
        }
        return dp[n];
    }
}
