public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return result;
        }
        ArrayList<Integer> cur = new ArrayList<>();
        helper(n, k, 1, cur, result);
        return result;
    }

    public void helper(int n, int k, int start, ArrayList<Integer> cur, List<List<Integer>> result) {
        if(cur.size() == k) {
            ArrayList<Integer> current = new ArrayList<>(cur);
            result.add(current);
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            helper(n, k, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
