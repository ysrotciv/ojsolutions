package space.yangshuai.ojsolutions.leetcode.lessons.array.collisionpointer;

public class SumOfTwo {

    public int[] twoSum(int[] numbers, int target) {

        int head = 0;
        int tail = numbers.length - 1;

        while (head < tail) {

            int sum = numbers[head] + numbers[tail];
            if (sum == target) {
                return new int[]{++head, ++tail};
            } else if (sum > target) {
                tail--;
            } else {
                head++;
            }
        }

        return null;
    }
}
