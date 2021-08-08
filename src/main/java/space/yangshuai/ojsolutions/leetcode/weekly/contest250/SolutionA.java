package space.yangshuai.ojsolutions.leetcode.weekly.contest250;

public class SolutionA {

    public int canBeTypedWords(String text, String brokenLetters) {
        int[] broken = new int[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = 1;
        }

        int count = 0;
        boolean brokenWord = false;
        for (String word : text.split(" ")) {
            for (char c : word.toCharArray()) {
                if (broken[c - 'a'] == 1) {
                    brokenWord = true;
                    break;
                }
            }
            if (!brokenWord) {
                count++;
            } else {
                brokenWord = false;
            }
        }
        return count;
    }

}
