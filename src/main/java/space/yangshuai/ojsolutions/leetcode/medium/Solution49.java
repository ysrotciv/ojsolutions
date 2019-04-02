package space.yangshuai.ojsolutions.leetcode.medium;

import java.util.*;

/**
 * Created by rotciv on 2017/2/16.
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            String sorted = sortStr(str);
            List<String> list = map.get(sorted);
            if (list == null) {
                list = new LinkedList<>();
                list.add(str);
                map.put(sorted, list);
            } else {
                list.add(str);
            }
        }

        for (List<String> list: map.values()) {
            result.add(list);
        }

        return result;
    }

    private String sortStr(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
