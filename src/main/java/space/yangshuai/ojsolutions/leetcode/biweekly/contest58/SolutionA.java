package space.yangshuai.ojsolutions.leetcode.biweekly.contest58;

public class SolutionA {

    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char first = s.charAt(0);
        char second = s.charAt(1);
        stringBuilder.append(first).append(second);
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first != second || first != c) {
                stringBuilder.append(c);
                first = second;
                second = c;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SolutionA().makeFancyString("ab"));
    }

}
