package space.yangshuai.ojsolutions.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution451 {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Stream<Map.Entry<Character,Integer>> sorted =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());
        StringBuilder builder = new StringBuilder();
        sorted.forEach(e -> {
            for (int i = 0; i < e.getValue(); i++) {
                builder.append(e.getKey());
            }
        });
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution451().frequencySort("tree"));
    }
}
