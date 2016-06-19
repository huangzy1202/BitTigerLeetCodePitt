public class Solution {
    //backtracking
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
    
    //iteration
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
