public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), 0, res, nums);
        return res;
    }
    
    private void helper(List<Integer> path, int index, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<Integer>(path));
        
        for(int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            helper(path, i+1, res, nums);
            path.remove(path.size()-1);
        }
    }
    
    //iteration
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        int size = 0, start;
        for(int i = 0; i < nums.length; i++) {
            if(i >= 1 && nums[i] == nums[i - 1]) {
                start = size;
            }else {
                start = 0;
            }
            size = res.size();
            for(int j = start; j < size; j++) {
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }
        return res;
    }
}
