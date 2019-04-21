package space.yangshuai.ojsolutions.leetcode.lessons.array.collisionpointer;

public class MostWater {

    public int maxArea(int[] height) {

        int head = 0;
        int tail = height.length - 1;

        int headHeight = height[head];
        int tailHeight = height[tail];
        int maxArea = (tail - head) * Math.min(headHeight, tailHeight);
        if (headHeight < tailHeight) {
            head++;
        } else {
            tail--;
        }

        while (head < tail) {
            if (height[head] < headHeight) {
                head++;
                continue;
            }
            if (height[tail] < tailHeight) {
                tail--;
                continue;
            }
            int area = (tail - head) * Math.min(height[head], height[tail]);
            headHeight = height[head];
            tailHeight = height[tail];
            if (area > maxArea) {
                maxArea = area;
            }
            if (headHeight < tailHeight) {
                head++;
            } else {
                tail--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        new MostWater().maxArea(new int[]{2,3,4,5,18,17,6});
    }
}
