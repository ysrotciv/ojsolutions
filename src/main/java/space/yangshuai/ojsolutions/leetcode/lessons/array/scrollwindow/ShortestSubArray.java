package space.yangshuai.ojsolutions.leetcode.lessons.array.scrollwindow;

public class ShortestSubArray {

    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        int head = 0;
        int tail = 0;
        int result;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= s) {
                return 1;
            }
            sum += nums[i];
            if (sum >= s) {
                tail = i;
                break;
            }
        }

        if (tail == 0) {
            return 0;
        }

        result = tail - head + 1;
        sum -= nums[head++];

        while (true) {

            if (sum >= s) {
                result--;
                sum -= nums[head];
                head++;
            } else {
                head++;
                tail++;
                if (tail >= nums.length) {
                    return result;
                } else {
                    sum -= nums[head - 1];
                    sum += nums[tail];
                }
            }
        }

    }

    public static void main(String[] args) {
        new ShortestSubArray().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }

}
