package dp;
/**
 * @author depeng
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] local = new int[nums.length];
        int[] global = new int[nums.length];
        local[0] = nums[0];
        global[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            local[i] = Math.max(nums[i], local[i-1] + nums[i]);
            global[i] = Math.max(global[i-1], local[i]);
        }
        return global[nums.length-1];
    }
}
