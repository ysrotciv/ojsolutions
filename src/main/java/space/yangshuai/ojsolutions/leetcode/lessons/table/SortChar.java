package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai on 2019-05-08.
 */
public class SortChar {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e -> {
            for (int i = 0 ; i < e.getValue(); ++i) {
                stringBuilder.append(e.getKey());
            }
        });
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new SortChar().frequencySort("tree");
    }

}
