public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        helper(new ArrayList<Integer>(), 0, res, nums);
        return res;
    }
    
    private void helper(List<Integer> path, int index, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<Integer>(path));
        
        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(path, i+1, res, nums);
            path.remove(path.size()-1);
        }
    }
}
