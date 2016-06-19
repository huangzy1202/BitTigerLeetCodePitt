public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        List<Integer> prev = grayCode(n - 1);
        result.addAll(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
            result.add(prev.get(i) + (int) Math.pow(2, n - 1));
        }
        return result;
    }
}
