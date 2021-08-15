package space.yangshuai.ojsolutions.leetcode.weekly.contest253;


public class SolutionC {

    public int minSwaps(String s) {
        int left = 0;
        int right = s.length() - 1;
        int leftCount = 0;
        int rightCount = 0;
        int swapCount = 0;
        char[] arr = s.toCharArray();
        while (left < right) {
            while (left < right) {
                if (arr[left] == '[') {
                    leftCount++;
                    left++;
                } else {
                    if (leftCount > 0) {
                        leftCount--;
                        left++;
                    } else {
                        break;
                    }
                }
            }
            while (left < right) {
                if (arr[right] == ']') {
                    rightCount++;
                    right--;
                } else if (rightCount > 0) {
                    rightCount--;
                    right--;
                } else {
                    break;
                }
            }
            if (left < right) {
                leftCount++;
                rightCount++;
                left++;
                right--;
                swapCount++;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionC().minSwaps("[]"));
    }
}
