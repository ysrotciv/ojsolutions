package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.*;

/**
 * @author yangshuai on 2019-05-10.
 */
public class Anagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            List<String> list = map.getOrDefault(new String(arr), new ArrayList<>());
            list.add(str);
            map.put(new String(arr), list);
        }

        return new ArrayList<>(map.values());
    }

}
