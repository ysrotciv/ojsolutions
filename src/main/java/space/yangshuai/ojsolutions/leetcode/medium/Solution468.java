package space.yangshuai.ojsolutions.leetcode.medium;

/**
 * Created by rotciv on 2017/3/2.
 */
public class Solution468 {

    public String validIPAddress(String IP) {

        if (IP.length() > 4 * 8 + 7) return "Neither";

        if (IP.contains(".")) {
            if (IP.startsWith(".") || IP.endsWith(".")) return "Neither";
            String[] arr = IP.split("\\.");
            if (arr.length != 4) return "Neither";

            for (String str: arr) {
                if (str.isEmpty()) return "Neither";
                if (str.startsWith("0") && str.length() > 1) return "Neither";
                for (char c: str.toCharArray()) {
                    if (!Character.isDigit(c)) return "Neither";
                }
                int value = Integer.valueOf(str);
                if (value > 255) return "Neither";
            }

            return "IPv4";
        }

        if (IP.contains(":")) {
            if (IP.startsWith(":") || IP.endsWith(":")) return "Neither";

            String[] arr = IP.toUpperCase().split(":");
            if (arr.length != 8) return "Neither";

            for (String str: arr) {
                if (str.length() > 4 || str.isEmpty()) return "Neither";
                for (char c: str.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        if (c < 65 || c > 70) return "Neither";
                    }
                }
            }

            return "IPv6";
        }

        return "Neither";
    }

    public static void main(String[] args) {
        System.out.println(new Solution468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }

}
