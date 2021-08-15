package space.yangshuai.ojsolutions.leetcode.weekly.contest253;

import java.util.Objects;

public class SolutionA {

    public boolean isPrefixString(String s, String[] words) {

        int start = 0;
        int end = words[0].length();
        int index = 0;

        if (end > s.length()) {
            return false;
        }

        while (true) {
            if (Objects.equals(s.substring(start, end), words[index])) {
                if (end == s.length()) {
                    return true;
                }
                index++;
                if (index >= words.length) {
                    return false;
                }
                start = end;
                end = end + words[index].length();
                if (end > s.length()) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
