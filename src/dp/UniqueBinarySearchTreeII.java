//http://bangbingsyb.blogspot.com/2014/11/leetcode-unique-binary-search-trees-i-ii.html

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //recursion
class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return helper(1,n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        
        if(start > end) {
            res.add(null);
            return res;
        }
        
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

//dp
//result[i] stores the result until length i. 
//For the result for length i+1, select the root node j from 0 to i, combine the result from left side and right side. 
//Note for the right side we have to clone the nodes as the value will be offsetted by j.
class Solution2 {
    public static List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);

        for(int len = 1; len <= n; len++){
            result[len] = new ArrayList<TreeNode>();
            for(int j=0; j<len; j++){
                for(TreeNode nodeL : result[j]){
                    for(TreeNode nodeR : result[len-j-1]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j+1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset){
        if(n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
