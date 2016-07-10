//Time = O(m * n)
//Space = O(m + n)
//m, n is the length of two input strings

public class Solution {
    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] result = new int[length1 + length2]; // the max length of result < m + n e.g: 99 * 9 = 198
        
        for(int i = length1 - 1; i >= 0; i--) {
            for(int j = length2 - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); //按位相乘
                int position1 = i + j;
                int position2 = i + j + 1;
                
                tmp += result[position2]; //加上上次按位相乘的结果
                result[position1] += tmp / 10; //十位
                result[position2] = tmp % 10; //个位
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int number : result) {
            if(!(sb.length() == 0 && number == 0)) { //skip heading 0s
                sb.append(number);
            }
        }
        
        if(sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
