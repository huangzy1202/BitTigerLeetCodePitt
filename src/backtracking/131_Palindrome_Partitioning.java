public class Solution {

    static List<List<String>> result;
    static ArrayList<String> cur;

    public static List<List<String>> partition(String s) {

        result = new ArrayList<List<String>>();
        cur = new ArrayList<String>();
        partition(s,0);

        return result;
    }

    public static void partition(String s, int start) {

        if (start >= s.length() && cur.size() > 0) {
            List<String> r = (ArrayList<String>) cur.clone();
            result.add(r);
        }

        for (int end = start; end < s.length(); end++) {
            if (palindrome(s,start,end)) {
                cur.add(s.substring(start,end+1));
                partition(s,end+1);
                cur.remove(cur.size()-1);
            }
        }
    }


    public static boolean palindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
