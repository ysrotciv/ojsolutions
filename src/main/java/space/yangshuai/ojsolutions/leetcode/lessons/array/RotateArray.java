package space.yangshuai.ojsolutions.leetcode.lessons.array;

/**
 * @author yangshuai on 2019-04-02.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {

        k %= nums.length;

        if (nums.length <= 1) {
            return;
        }

        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);

        if (nums.length - k >= 0) System.arraycopy(nums, 0, nums, k, nums.length - k);

        System.arraycopy(temp, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

}
