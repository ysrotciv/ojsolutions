package space.yangshuai.ojsolutions.leetcode.contest.contest136;

import java.util.HashMap;
import java.util.Map;

public class SolutionA {

    public boolean isRobotBounded(String instructions) {

        Map<Character, Integer> map = new HashMap<>(6);

        if (backToOriginal(instructions)) {
            return true;
        }

        for (char c : instructions.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (Math.abs(map.getOrDefault('L', 0) - map.getOrDefault('R', 0)) % 4 != 0) {
            return true;
        }

        return false;
    }

    public boolean backToOriginal(String instructions) {
        int angle = 0;
        Map<Integer, Integer> map = new HashMap<>(8);
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                map.put(angle, map.getOrDefault(angle, 0) + 1);
            } else if (c == 'L') {
                angle = (angle + 3) % 4;
            } else {
                angle = (angle + 1) % 4;
            }
        }
        if (map.getOrDefault(0, 0) != map.getOrDefault(2, 0)) {
            return false;
        }
        if (map.getOrDefault(1, 0) != map.getOrDefault(3, 0)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String raw = "GL";
        boolean result = new SolutionA().isRobotBounded(raw);
        System.out.println(result);
    }
}
