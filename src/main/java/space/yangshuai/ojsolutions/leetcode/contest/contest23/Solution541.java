package space.yangshuai.ojsolutions.leetcode.contest.contest23;

/**
 * Created by rotciv on 2017/3/12.
 */
public class Solution541 {

    public String reverseStr(String s, int k) {

        char[] src = s.toCharArray();
        char[] target = new char[src.length];
        int temp = k;

        for (int i = 0; i < src.length; i++) {
            int offset = (i + 1) % (2 * k);
            if (offset <= k && offset != 0) {
                if ((i + 1 - offset + k) > src.length && (offset == 1)) {
                    temp = src.length - (i + 1 - offset);
                }
                int index = i + 1 - offset + (temp + 1 - offset) - 1;
                target[index] = src[i];
            } else {
                target[i] = src[i];
            }
        }

        return new String(target);
    }

    public static void main(String[] args) {
        System.out.println(new Solution541().reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39));
    }

}
