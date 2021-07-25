package space.yangshuai.ojsolutions.leetcode.contest.contest249;

import java.util.HashSet;
import java.util.Set;

public class SolutionB {

    public int countPalindromicSubsequence(String s) {

        int ans = 0;

        int[] apl = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            apl[c - 'a']++;
            right[c - 'a'] = i;
        }

        Set<Character> set = new HashSet<>(26);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (apl[c - 'a'] <= 1) {
                continue;
            }
            for (int j = i + 1; j < right[c - 'a']; j++) {
                set.add(s.charAt(j));
            }
            ans += set.size();
            set.clear();
            apl[c - 'a'] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        new SolutionB().countPalindromicSubsequence("aabca");
    }

}
