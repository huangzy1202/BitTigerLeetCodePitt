public class Solution {
    public int lengthOfLIS(int[] nums) {
        //initialize the array with 1
        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = 1;
        }
        
        for(int i = 1; i < res.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    res[i] = Math.max(res[j]+1, res[i]);
                }
            }
        }
        
        int maxLen = 0;
        for(int i: res) {
            System.out.println(i);
            maxLen = Math.max(maxLen, i);
        }
        return maxLen;
        
    }
}
