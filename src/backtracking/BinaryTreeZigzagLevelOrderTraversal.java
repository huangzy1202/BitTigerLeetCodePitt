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
    //use two stack to store the nodes of current level and next level
    //if flag = 0, push the left child first then the right one
    //otherwise, push the right chlid first then the left one
    //when pop all the nodes of the current level, reset initials and move to the next level
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
    
    //use a queue to level order traversal the tree 
    //if flag = 0, add the node value at the end of the list,
    //otherwise, add the node value at the head of the list
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;
        int size = 1;
    
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if(flag == 0) {
                    level.add(tmp.val);
                } else {
                    level.add(0, tmp.val);
                }
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
            res.add(level);
            size = queue.size();
            flag ^= 1;
        }
        return res;
    }
    
    //backtracking
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        helper(root, res, 0);
        return res;
    }
    
    private void helper(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null) return;
        
        if(res.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }
        
        List<Integer> tmp = res.get(level);
        if(level % 2 == 0) tmp.add(node.val);
        else tmp.add(0,node.val);
        
        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
    }
}
