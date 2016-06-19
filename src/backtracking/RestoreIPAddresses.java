public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s,res,0,"",0);
        return res;
    }
    
    private void helper(String s, List<String> res, int index, String ip, int count) {
        if(count > 4) return;
        if(count == 4 && index == s.length()) res.add(ip);
        
        for(int i = 1; i < 4 && index + i <= s.length(); i++) {
            String tmp = s.substring(index, index+i);
            if((tmp.startsWith("0") && tmp.length() > 1) || (i == 3 && Integer.parseInt(tmp) > 255)) continue;
            helper(s, res, index+i, ip+tmp+(count==3?"":"."),count+1);
        }
    }
}
