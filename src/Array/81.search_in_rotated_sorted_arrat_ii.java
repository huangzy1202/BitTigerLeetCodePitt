public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        
        int left = 0, right = nums.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            // System.out.println(mid + " " + nums[mid]);
            if(nums[mid] == target) {
                return true;
            } 
            
            if(nums[mid] > nums[left]) {
                if(nums[mid] > target && target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < nums[left]){
                if(nums[right] >= target && target > nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                left++;
            }
        }
        
        if(nums[left] == target || nums[right] == target) {
            return true;
        } else {
            return false;
        }
    }
}