package space.yangshuai.leetcode.easy;

/**
 * Created by rotciv on 2017/2/14.
 */
public class Solution345 {

    public String reverseVowels(String s) {

        if (s.isEmpty()) return "";

        int low = 0;
        int high = s.length() - 1;
        String compare = "aeiouAEIOU";
        char[] result = new char[s.length()];

        while (low < high) {

            while (low < high && !compare.contains(s.charAt(low) + "")) {
                result[low] = s.charAt(low);
                low++;
            }
            while (low < high && !compare.contains(s.charAt(high) + "")) {
                result[high] = s.charAt(high);
                high--;
            }

            if (low >= high) break;
            result[low] = s.charAt(high);
            result[high] = s.charAt(low);
            low++;
            high--;
        }

        if (low == high)
            result[low] = s.charAt(low);

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new Solution345().reverseVowels("leetcode"));
        System.out.println(new Solution345().reverseVowels("hello"));
        System.out.println(new Solution345().reverseVowels(""));
        System.out.println(new Solution345().reverseVowels("swap"));
        System.out.println(new Solution345().reverseVowels("ai"));
    }
}
