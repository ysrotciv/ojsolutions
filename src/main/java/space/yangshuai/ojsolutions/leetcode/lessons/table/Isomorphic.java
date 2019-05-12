package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai on 2019-05-08.
 */
public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>(s.length() >> 1);
        Map<Character, Character> reserve = new HashMap<>(s.length() >> 1);

        for (int i = 0; i < s.length(); ++i) {

            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (!map.containsKey(tc)) {
                map.put(tc, sc);
                if (reserve.containsKey(sc)) {
                    return false;
                } else {
                    reserve.put(sc, tc);
                }
            } else {
                if (map.get(tc) == sc) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}
