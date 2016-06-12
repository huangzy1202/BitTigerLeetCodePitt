public class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if(size == 1) return 0;
        if(size == 2) {
            if(prices[1] > prices[0]) return prices[1] - prices[0];
            return 0;
        } 

        int[] diff = new int[size - 1];
        for(int i = 0; i < size - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        int[][] profit = new int[size - 1][2];
        int size2 = size - 1;
        //[i][0]不要,[i][1]要
        profit[0][0] = 0;
        profit[0][1] = diff[0];

        profit[1][0] = diff[0];
        profit[1][1] = diff[1];
      
        int nn = 0;
        int yn = diff[0];
        int yy = diff[0] + diff[1];
        int ny = diff[1];
        
        for(int i = 2; i < size2; i++) {
            //update profit
            int max = nn;
            if(yy > max) max = yy;
            if(ny > max) max = ny;
            profit[i][1] = max;
            if(yn > max) max = yn;
            profit[i][0] = max;
            //update state
            nn = profit[i - 2][0];
            yn = profit[i - 2][1];
            yy = profit[i - 2][1] + diff[i - 1];
            ny = profit[i - 2][0] + diff[i - 1];
        }
        
        return profit[size2 - 1][0] > profit[size2 - 1][1] ? profit[size2 - 1][0] : profit[size2 - 1][1];
    }
}
