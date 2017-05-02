package space.yangshuai.leetcode.contest.contest21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rotciv on 2017/2/25.
 */
public class Solution524 {

    public String findLongestWord(String s, List<String> d) {

        List<String> list = new ArrayList<>();

        for (String str: d) {
            if (compare(s, str)) {
                if (list.size() == 0) {
                    list.add(str);
                } else {
                    if (str.length() > list.get(0).length()) {
                        list.clear();
                        list.add(str);
                    } else if (str.length() == list.get(0).length()) {
                        list.add(str);
                    }
                }
            }
        }

        if (list.size() == 0) return "";

        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);

        return arr[0];
    }

    private boolean compare(String src, String dest) {

        int i = 0;
        int j = 0;
        while (i <= src.length() - 1 && j <= dest.length() - 1) {
            if (dest.charAt(j) == src.charAt(i)) {
                if (j == dest.length() - 1) return true;
                if (i == src.length() - 1) return false;
                j++;
            }
            i++;
        }

        return false;
    }

    public static void main(String[] args) {
/*        List<String> list = new ArrayList<>();
        list.add("ba");
        list.add("ab");
        list.add("a");
        list.add("b");
        System.out.println(new Solution524().findLongestWord("bab", list));*/
        System.out.println("ab".compareTo("ba"));
    }
}
