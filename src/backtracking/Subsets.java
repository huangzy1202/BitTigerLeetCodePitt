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
    
    //https://leetcode.com/discuss/46668/recursive-iterative-manipulation-solutions-explanations
    // This problem can also be solved iteratively. 
    // Take [1, 2, 3] in the problem statement as an example. 
    // The process of generating all the subsets is like:
    // Initially: [[]]
    // Adding the first number to all the existed subsets: [[], [1]];
    // Adding the second number to all the existed subsets: [[], [1], [2], [1, 2]];
    // Adding the third number to all the existed subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            int n = res.size();
            for(int j = 0; j < n; j++) {
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }
        return res;
    }
    
    // Bit Manipulation
    // TThe idea is that to give all the possible subsets, we just need to exhaust all the possible combinations of the numbers. 
    // And each number has only two possibilities: either in or not in a subset. And this can be represented using a bit.
    // There is also another a way to visualize this idea. 
    // That is, if we use the above example, 1 appears once in every two consecutive subsets, 
    // 2 appears twice in every four consecutive subsets, and 3 appears four times in every eight subsets, 
    // shown in the following (initially the 8 subsets are all empty):
    // [], [], [], [], [], [], [], []
    // [], [1], [], [1], [], [1], [], [1]
    // [], [1], [2], [1, 2], [], [1], [2], [1, 2]
    // [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
    //https://leetcode.com/discuss/9213/my-solution-using-bit-manipulation
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        Arrays.sort(nums);
        int n = 1 << nums.length;
        
        for(int i = 0; i < n; i++) {
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        return res;
    }
}
