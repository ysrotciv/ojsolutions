package space.yangshuai.ojsolutions.leetcode.contest.contest26;

import java.util.*;

/**
 * Created by rotciv on 2017/4/2.
 */
public class Solution522 {

    public int findLUSlength(String[] strs) {

        int max = 0;

        for (String str: strs) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        if (max == 0) {
            return -1;
        }

        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (String str: strs) {
            if (str.length() == max) {
                count++;
                int value = map.getOrDefault(str, 0) + 1;
                map.put(str, value);
            }
        }

        if (count == 1) {
            return max;
        } else {
            if (unique(map)) {
                return max;
            }
        }

        Set<String> templates = new HashSet<>();
        templates.addAll(map.keySet());

        ArrayList<String> list = new ArrayList<>();
        for (String str: strs) {
            if (!contains(templates, str)) {
                list.add(str);
            }
        }

        while (list.size() > 0) {
            max = 0;
            for (String str: list) {
                if (str.length() > max) {
                    max = str.length();
                }
            }

            if (max == 0) {
                return -1;
            }

            map.clear();
            count = 0;

            for (String str: list) {
                if (str.length() == max) {
                    count++;
                    int value = map.getOrDefault(str, 0) + 1;
                    map.put(str, value);
                }
            }

            if (count == 1) {
                return max;
            } else {
                if (unique(map)) {
                    return max;
                }
            }

            templates.addAll(map.keySet());

            list.removeIf(str -> contains(templates, str));

        }

        return -1;
    }

    private boolean contains(Set<String> parents, String sub) {

        for (String parent: parents) {

            int parentIndex = 0;
            int subIndex = 0;

            while (parentIndex < parent.length() && subIndex < sub.length()) {
                if (parent.charAt(parentIndex) == sub.charAt(subIndex)) {
                    parentIndex++;
                    subIndex++;
                } else {
                    parentIndex++;
                }
            }

            if (subIndex == sub.length()) {
                return true;
            }
        }

        return false;
    }

    private boolean unique(Map<String, Integer> map) {

        for (int value: map.values()) {
            if (value == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        args = new String[]{"j","j","viez","ogk","ogk","lfn","ypmhwx","ypmhwx","m","m","ak","ivivzoncju","ivivzoncju","wmybi","wmybi","dyzfjg","dyzfjg"};
        System.out.println(new Solution522().findLUSlength(args));
    }
}
