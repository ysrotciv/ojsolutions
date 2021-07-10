package space.yangshuai.ojsolutions.leetcode.easy;


public class Solution605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*if (flowerbed.length == 1) {
            return flowerbed[0]^1 >= n;
        }
        int sum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            } else {
                if (i == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    sum++;
                } else if (flowerbed[i - 1] == 0 && i == flowerbed.length - 1) {
                    flowerbed[i] = 1;
                    sum++;
                } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    sum++;
                }
            }
            if (sum >= n) {
                return true;
            }
        }
        return sum >= n;*/
        return true;
    }

}
