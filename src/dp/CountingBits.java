public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            int count = 0;
            int n = i;
            while(n != 0) {
                count += (n & 1);
                n = n >> 1;
            }
            result[i] = count;
        }
        return result;
    }
}
