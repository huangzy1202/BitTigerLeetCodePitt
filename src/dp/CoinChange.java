public class Solution {
        public int coinChange(int[] coins, int amount) {  
            if(coins == null || coins.length == 0) {  
                return -1;  
            }  
            if(amount <=0) return 0;  
            int[] dp = new int[amount+1];  
            for(int i=1;i<dp.length; i++) {  
                dp[i] = Integer.MAX_VALUE;  
            }  
            for(int am=1;am<=amount;am++) {  
                for(int i=0;i<coins.length;i++) {  
                    if(coins[i]<=am) {  
                        int diff = am - coins[i];  
                        if(dp[diff] != Integer.MAX_VALUE) {  
                            dp[am] = Math.min(dp[diff] +1, dp[am]);  
                        }  
                    }     
                }  
            }  
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];  
        }  
}

