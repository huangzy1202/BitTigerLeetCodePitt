public class Solution {
    public static int countNumbersWithUniqueDigits(int n) {
        HashSet<Integer> alreadyHave = new HashSet<>();
        return countNoneRepeat(n,alreadyHave);
    }

    public static int countNoneRepeat(int n, HashSet<Integer> alreadyHave) {
        if (n < 1) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (!alreadyHave.contains(i)) {
                alreadyHave.add(i);
                result += countNoneRepeat(n-1,alreadyHave);
                alreadyHave.remove(i);
            } else {
                if (i == 0 && alreadyHave.size() == 1) {
                    alreadyHave.remove(0);
                    result += countNoneRepeat(n-1,alreadyHave);
                }
            }
        }
        return result;
    }
}
