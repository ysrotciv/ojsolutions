package space.yangshuai.ojsolutions.leetcode.contest.contest251;

public class SolutionB {

    public String maximumNumber(String num, int[] change) {

        char[] arr = num.toCharArray();
        boolean start = false;

        for (int i = 0; i < arr.length; i++) {
            int value = Character.getNumericValue(arr[i]);
            if (value == change[value]) {
                continue;
            }
            if (value < change[value]) {
                start = true;
                arr[i] = (char) (change[value] + '0');
            } else if (start) {
                break;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println((char) (1 + '0'));
    }
}
