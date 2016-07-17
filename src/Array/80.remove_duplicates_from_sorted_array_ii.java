public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1 || nums.length == 2) return nums.length;
        
        int slow = 0, fast = 1, times = 0, res = 0;
        while(fast < nums.length) {
            if(nums[slow] == nums[fast] && times != 0) {
                fast++;
                times++;
            } else if (nums[slow] == nums[fast] && times == 0){
                slow++;
                nums[slow] = nums[fast];
                fast++;
                times++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
                times = 0;
            }
        }
        return slow + 1;
    }
}
