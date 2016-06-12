//This problem is a little tricky at first glance. However, 
//if you have finished the House Robber problem, 
//this problem can simply be decomposed into two House Robber problems. 
//Suppose there are n houses, since house 0 and n - 1 are now neighbors, 
//we cannot rob them together and thus the solution is now the maximum of
//Rob houses 0 to n - 2;
//Rob houses 1 to n - 1.
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(helper(nums,0,n-2), helper(nums,1,n-1));
    }
    
    private int helper(int[] nums, int start, int end) {
        int cur = 0;
        int p0 = 0;
        int p1 = 0;
        for(int i = start; i <= end; i++) {
            cur = Math.max(p0 + nums[i], p1);
            p0 = p1;
            p1 = cur;
        }
        return cur;
    }
}

//http://blog.welkinlan.com/2015/03/31/house-robber-simple-dp/
//Same method with solution 0, except for this time we can start from any of the house
class Solution2{
  public int rob(int[] nums) {
    int res = 0;
        
    for(int i = 0; i < nums.length; i++) {
      int p0 = 0;
      int p1 = nums[i];
            
      int cur = p1;
      for(int j = 2; j < nums.length; j++) {
        cur = Math.max(p0 + nums[(i+j-1)%nums.length], p1);
        p0 = p1;
        p1 = cur;
      }
      res = Math.max(res, cur);
    }
    return res;
  }
}

//rob house I
class Solution0{
    public int rob1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int[] res = new int[nums.length+1];
        res[0] = 0;
        res[1] = nums[0];
        
        for(int i = 2; i < res.length; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + nums[i-1]);
        }
        
        return res[res.length-1];
        
    }
}
