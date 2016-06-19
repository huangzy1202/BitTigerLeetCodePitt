/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        List<Integer> level = new ArrayList<>();
        
        int flag = 0; 
        //0: left -> right
        //1: right -> left
        curLevel.push(root);
        
        while(!curLevel.isEmpty()) {
            TreeNode tmp = curLevel.pop();
            level.add(tmp.val);
            
            if(flag == 0) {
                if(tmp.left != null) nextLevel.push(tmp.left);
                if(tmp.right != null) nextLevel.push(tmp.right);
            } else {
                if(tmp.right != null) nextLevel.push(tmp.right);
                if(tmp.left != null) nextLevel.push(tmp.left);
            }
            
            if(curLevel.isEmpty()) {
                res.add(level);
                level = new ArrayList<>();
                curLevel = nextLevel;
                nextLevel = new Stack<>();
                flag ^= 1;
            }
        }
        return res;
    }
}