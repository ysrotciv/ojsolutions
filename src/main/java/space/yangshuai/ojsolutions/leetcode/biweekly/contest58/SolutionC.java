package space.yangshuai.ojsolutions.leetcode.biweekly.contest58;

public class SolutionC {

    public int minSpaceWastedKResizing(int[] nums, int k) {
        int sum = 0;
        int endIndex = nums.length - 1;
        int max = 0;
        while (k >= 0 && endIndex >= 0) {
            int maxIndex = 0;
            max = 0;
            for (int i = k; i <= endIndex; i++) {
                if (nums[i] > max) {
                    maxIndex = i;
                    max = nums[i];
                }
            }
            for (int i = maxIndex + 1; i <= endIndex; i++) {
                sum += max - nums[i];
            }
            endIndex = maxIndex - 1;
            k--;
        }
        for (int i = 0; i <= endIndex; i++) {
            sum += max - nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionC().minSpaceWastedKResizing(new int[]{10,20,30}, 1));
    }

}
