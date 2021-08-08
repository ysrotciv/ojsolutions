package space.yangshuai.ojsolutions.leetcode.weekly.contest251;

public class SolutionA {

    public int getLucky(String s, int k) {

        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(c - 'a' + 1);
        }
        String raw = builder.toString();
        for (int i = 0; i < k; i++) {
            int tmp = getSum(raw);
            raw = String.valueOf(tmp);
        }
        return Integer.parseInt(raw);
    }

    private int getSum(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res += Character.getNumericValue(c);
        }
        return res;
    }

    public static void main(String[] args) {
        new SolutionA().getLucky("zbax", 2);
    }
}
