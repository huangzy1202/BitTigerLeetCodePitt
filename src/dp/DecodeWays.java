package dp;
/**
 * @author depeng
 * leetcode link: https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) <= '0' || s.charAt(0) > '9') {
            return 0;
        }
        int[] ways = new int[s.length()+1];
        ways[0] = 1;
        ways[1] = 1;
        
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char prevC = s.charAt(i-1);
            if (c == '0') {
                ways[i+1] = ways[i-1];
                if (prevC != '1' && prevC != '2') {
                    return 0;
                }
            } else if (c >= '1' && c <= '6') {
                if (prevC == '1' || prevC == '2') {
                    ways[i+1] = ways[i] + ways[i-1];
                } else {
                    ways[i+1] = ways[i];
                }
            } else {
                if (prevC == '1') {
                    ways[i+1] = ways[i] + ways[i-1];
                } else {
                    ways[i+1] = ways[i];
                }
            }
        }
        
        return ways[ways.length-1];
    }
}