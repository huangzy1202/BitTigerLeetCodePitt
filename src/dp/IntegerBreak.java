public class Solution {
    //DP solution
    public int integerBreak(int n) {
        if(n < 4) return n - 1;
        int[] results = new int[n];
        results[0] = 0;
        results[1] = 1;
        for(int i = 3; i <= n; i++) {
            int biggest = 0;
            for(int j = 1 ; j < i; j++) {
                int temp = results[j - 1] * (i - j);
                biggest = temp > biggest ? temp : biggest;
            }
            results[i - 1] = i > biggest ? i : biggest;
        }
        return results[n - 1];
    }
    
    //Tricky solution
    private int integerBreak2(int n) {
        if(n < 4) return n - 1;
        int result = 1;
        while(n > 4) {
            result *= 3;
            n -= 3;
        }
        if(n != 0) result *= n;
        return result;
    }
}
