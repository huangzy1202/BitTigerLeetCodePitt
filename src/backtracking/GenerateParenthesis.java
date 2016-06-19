public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        if(n <= 0) {
            return result;
        }
        String cur = "";
        helper(n, n, result, cur);
        return result;
    }
    public void helper(int left, int right, LinkedList<String> result, String cur) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            String current = new String(cur);
            result.add(current);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, result, cur + "(");
        }
        if (right > 0) {
            helper(left, right - 1, result, cur + ")");
        }
    }
}
