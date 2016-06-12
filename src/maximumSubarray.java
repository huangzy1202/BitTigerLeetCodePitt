public class maximumSubarray {
    public int maxSubArray0(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                 max = sum;
             }
             if (sum < 0) {
                 sum = 0;
             }
        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        return maxArray(nums, 0, n-1, max);
    }
    private int maxArray(int[] nums, int left, int right, int max) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = left + (right - left) / 2;
        int lmax = maxArray(nums, left, mid - 1, max);
        int rmax = maxArray(nums, mid + 1, right, max);
        max = Math.max(lmax, rmax, max);
        int sum = 0, mlmax = 0;
        for (int i = mid - 1; i > left; i--) {
            sum += nums[i];
            if (sum > mlmax) {
                mlmax = sum;
            }
        }
        sum = 0; int mrmax = 0;
        for (int i = mid + 1; i < right; i++) {
            sum += nums[i];
            if (sum > mrmax) {
                mrmax = sum;
            }
        }
        max = Math.max(max, mlmax + mrmax + nums[mid]);  
        return max;  
    }
}
