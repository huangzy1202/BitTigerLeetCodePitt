public class Solution {
    static HashSet<Integer> used = new HashSet<>();
    static int total;
    public static List<Integer> grayCode(int n) {
        used.clear();
        total = (int)Math.pow(2,n);
        List<Integer> result = new ArrayList<>();
        solve((int)Math.pow(2,n),result);
        return result;
    }

    public static boolean solve(int n, List<Integer> result) {

        if (n > 0) {
            for (int i=0; i < total; i++) {
                if ((!used.contains(i)) && (result.size() == 0 || checkGray(result.get(result.size()-1),i))) {
                    result.add(i);
                    used.add(i);
                    if (!solve(n-1,result)) {
                        result.remove(result.size()-1);
                        used.remove(i);
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;

    }

    public static boolean checkGray(int a, int b) {

        if (a == b) {
            return false;
        }

        int i = 1;
        while(i < Math.max(a,b)) {
            if ((a/i%2 == 0) && (b/i%2 != 0)) {
                if (a != b - i) {
                    return false;
                } else {
                    return true;
                }
            } else if ((a/i%2 != 0) && (b/i%2 == 0)) {
                if (a - i != b) {
                    return false;
                } else {
                    return true;
                }
            }
            i *= 2;
        }
        return true;
    }
}
