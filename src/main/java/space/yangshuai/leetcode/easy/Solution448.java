package space.yangshuai.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/1/3.
 */
public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int num : nums) {
//            System.out.println(num);
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) {
           nums[(nums[i]-1) % n] += n;
        }
        for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
        return res;

    }


    public static void main(String[] args) {

        int[] array = new int[]{2,3,4,5,6,7,5,5};
        List<Integer> list = new Solution448().findDisappearedNumbers(array);
        for (int num : list) {
            System.out.println(num);
        }
    }

}
