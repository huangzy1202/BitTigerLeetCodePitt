public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
            
        int sign = 1;
        if(dividend > 0 && divisor <0 || dividend < 0 && divisor > 0)
            sign = -1;
            
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        int res = 0;
        //Time = O(logN)
        while(dvd >= dvs) {
            long tmp = dvs;
            long multiplier = 1;
            while( dvd >= (tmp << 1)) {
                tmp <<= 1;
                multiplier <<=1;
            }
            dvd -= tmp;
            res += multiplier;
        }
        
        //TLE Time = O(N)
        // while(dvd >= dvs) {
        //     dvd -=dvs;
        //     res++;
        //     System.out.println(dvd);
        //     System.out.println(res + "==");
        // }
        return sign == 1 ? (int) res : (int) -res;
        
    }
}
