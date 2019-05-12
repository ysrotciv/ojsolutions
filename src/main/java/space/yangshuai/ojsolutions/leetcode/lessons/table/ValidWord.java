package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai on 2019-05-08.
 */
public class ValidWord {

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> countMap = new HashMap<>(s.length() >> 1);

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            int count = countMap.getOrDefault(c, 0) - 1;
            if (count == 0) {
                countMap.remove(c);
            } else if (count < 0) {
                return false;
            } else {
                countMap.put(c, count);
            }
        }

        return countMap.isEmpty();
    }

}
