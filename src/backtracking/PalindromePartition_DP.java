package backtracking;

public class PalindromePartition_DP {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] res = new List[len + 1];
        res[0] = new LinkedList<List<String>>();
        res[0].add(new LinkedList<String>());
        boolean[][] dp = new boolean[len][len];

        for (int end = 0; end < len; end++) {
            res[end + 1] = new LinkedList<List<String>>();
            for (int start = 0; start <= end; start++) {
                if (s.charAt(end) == s.charAt(start) && (end - start <= 1 || dp[end - 1][start + 1])) {
                    dp[end][start] = true;
                    String sub = s.substring(start, end + 1);
                    List<List<String>> lists = res[start];
                    for (List<String> list: lists) {
                        List<String> newList = new LinkedList<String>(list);
                        newList.add(sub);
                        res[end + 1].add(newList);
                    }
                }
            }
        }
        
        return res[len];
    }
}
