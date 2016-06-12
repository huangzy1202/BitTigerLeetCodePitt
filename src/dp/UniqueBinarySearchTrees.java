package dp;
/**
 * @author depeng
 * leetcode link: https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
        if(n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }
        
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        return helper(n, count);
    }
    
    private int helper(int i, int[] count) {
        if(count[i] != 0) {
            return count[i];
        }
        for(int j = 0; j < i; j++) {
            count[i] += helper(j, count) * helper(i - j -1, count);
        }
        return count[i];
    }
    
    // this solution is from Code Ganker
    public int numTrees2(int n) {
        if(n<=0)
            return 0;
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                res[i] += res[j]*res[i-j-1];
            }
        }
        return res[n];
    }
}
