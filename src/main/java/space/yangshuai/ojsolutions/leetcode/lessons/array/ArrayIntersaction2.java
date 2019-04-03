package space.yangshuai.ojsolutions.leetcode.lessons.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yangshuai on 2019-04-03.
 */
public class ArrayIntersaction2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int head1 = 0, head2 = 0;

        while (head1 < nums1.length && head2 < nums2.length) {
            if (nums1[head1] == nums2[head2]) {
                result.add(nums1[head1]);
                head1++;
                head2++;
            } else {
                if (nums1[head1] < nums2[head2]) {
                    head1++;
                } else {
                    head2++;
                }
            }
        }

        int[] duplication = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            duplication[i] = result.get(i);
        }
        return duplication;
    }

}
