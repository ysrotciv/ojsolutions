package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by rotciv on 2017/2/16.
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {

        int index = s.length() - 1;
        int count = 0;
        char[] arr = s.toCharArray();

        while (index >= 0 && arr[index] == ' ')
            index--;

        if (index < 0) return 0;

        for (int i = index; i >= 0; i--) {
            if (arr[i] != ' ') count++;
            else break;
        }

        return count;
    }

}
