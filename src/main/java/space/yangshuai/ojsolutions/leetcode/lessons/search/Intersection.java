package space.yangshuai.ojsolutions.leetcode.lessons.search;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshuai on 2019-04-23.
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length >> 2);
        Set<Integer> result = new HashSet<>(nums1.length >> 2);
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(e -> e).toArray();
    }

}
