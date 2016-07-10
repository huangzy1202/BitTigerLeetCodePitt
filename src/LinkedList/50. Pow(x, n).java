public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            if (n > 0) {
                return 0;
            } else {
                throw new IllegalArgumentException("Illegal Argument.");
            }
        } else {
            return helper(x, n);
        }
    }
    
    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        } 
        
        double res = helper(x, n / 2);
        if (n % 2 == 0) {
            res = res * res;
        } else if (n % 2 == 1) {
            res = res * res * x;
        } else {
            res = res * res * (1 / x);
        }

        return res;
    }
}
