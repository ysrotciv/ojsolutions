package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Count and Say
 * @author shuai.yang
 *
 */
public class Solution38 {
	
	public static void main(String[] args) {

		Solution38 solution = new Solution38();
		for (int i = 1; i < 100; i++) {
			String result = solution.countAndSay(i);
			System.out.println(result);
		}
	}
	
    public String countAndSay(int n) {
    	
    	if (n == 1)
			return "1";

		String result = "1";
		for (int i = 1; i < n; i++) {
			result = calNext(result);
		}
		return result;
    }
    
    private String calNext(String str) {
        String result = "";
        while(str.length() > 0) {
        	result += this.getPronounceStr(str);
        	str = this.getNextStr(str);
        }
    	return result;
    }
    
    private String getPronounceStr(String str) {
        
        char theIntegerChar = str.charAt(0);
        int num = 1;
        
        int index = 1;
        while (str.length() >= index + 1) {
        	if (theIntegerChar == str.charAt(index)) {
        		num++;
        		index++;
        	} else {
        		break;
        	}
        }
        
        return String.valueOf(num) + theIntegerChar;
    }
    
    private String getNextStr(String str) {
        
        char theIntegerChar = str.charAt(0);
        
        if (str.length() == 1)
        	return "";
        while (true) {
        	if (theIntegerChar == str.charAt(1)) {
        		if (str.length() == 2) {
        			str = "";
        			break;
        		}
        		str = str.substring(1);
        	} else {
        		str = str.substring(1);
        		break;
        	}
        }
        
        return str;
    }
}
