package backtracking;

public class Solution {
    // how to analyze the runtime of this solution??? 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        helper(nums, res, used, new LinkedList<Integer>());
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, boolean[] used, LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new LinkedList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            helper(nums, res, used, list);
            list.removeLast();
            used[i] = false;
        }
    }
    
    
    // Solution from hot answer
    // https://leetcode.com/discuss/19510/my-ac-simple-iterative-java-python-solution
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums.length == 0) return result;
        List<Integer> cur = new LinkedList<Integer>();
        cur.add(nums[0]);
        result.add(cur);
        for(int i = 1; i < nums.length; i++) {
            int curSize = result.size();
            for(int j = 0; j < curSize; j++) {
                for(int x = 0; x < result.get(j).size(); x++) {
                    List<Integer> newList = new LinkedList<Integer>(result.get(j));
                    newList.add(x, nums[i]);
                    result.add(newList);
                }
                result.get(j).add(nums[i]);
            }
        }
        return result;
    }
}