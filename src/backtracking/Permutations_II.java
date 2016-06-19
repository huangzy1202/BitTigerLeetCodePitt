package backtracking;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = getMap(nums);   // value: count
        helper(nums, res, map, new LinkedList<Integer>());
        return res;
    }
    
    private HashMap<Integer, Integer> getMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 1);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, HashMap<Integer, Integer> map, LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new LinkedList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if(map.get(nums[i]) <= 0) {
                continue;
            }
            list.add(nums[i]);
            map.put(nums[i], map.get(nums[i]) - 1);
            helper(nums, res, map, list);
            list.removeLast();
            map.put(nums[i], map.get(nums[i]) + 1);
        }
    }
    
    
    // Solution from hot answer
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
