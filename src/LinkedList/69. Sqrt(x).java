    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Negative Argument was found.");
        } else if (x < 2) {
            return x;
        }
        
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }


// Wrong Solution
public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Negative Argument was found.");
        }
        
        if (x == 0 || x == 1) {
            return x;
        }
        
        int start = 1; 
        int end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int product = mid * mid;    // Integer Overflow
            if (mid == start || product == x) {
                return mid;
            } else if (product < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return 0;
    }
}
