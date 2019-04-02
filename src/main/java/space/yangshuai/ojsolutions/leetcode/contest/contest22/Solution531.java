package space.yangshuai.ojsolutions.leetcode.contest.contest22;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rotciv on 2017/3/5.
 */
public class Solution531 {

    public int findLonelyPixel(char[][] picture) {

        Set<Integer> horizontal = new HashSet<>();
        Set<Integer> vertical = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        int count = 0;

        int height = picture.length;
        if (height == 0) return 0;
        int width = picture[0].length;
        if (width == 0) return 0;

        for (int i = 0; i < width; ++i) horizontal.add(i);
        for (int i = 0; i < height; ++i) vertical.add(i);

        int singleIndex;
        boolean single;
        for (int i = 0; i < height; ++i) {

            if (!vertical.contains(i)) continue;

            vertical.remove(i);
            single = true;
            singleIndex = -1;

            for (int j = 0; j < width; ++j) {
                if (picture[i][j] == 'B') {
                    temp.add(j);
                    if (singleIndex == -1) {
                        singleIndex = j;
                    } else {
                        single = false;
                    }
                }
            }
            if (!horizontal.contains(singleIndex)) single = false;
            horizontal.removeAll(temp);
            temp.clear();

            if (single && singleIndex != -1) {
                single = true;
                for (int j: vertical) {
                    if (picture[j][singleIndex] == 'B') {
                        single = false;
                        temp.add(j);
                    }
                }
                if (single) count++;
                vertical.removeAll(temp);
                temp.clear();
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] arr = new String[]{"WWB","WBW","BWW"};
        char[][] d2 = new char[arr.length][arr[0].length()];

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length(); ++j) {
                d2[i][j] = arr[i].charAt(j);
            }
        }

        System.out.println(new Solution531().findLonelyPixel(d2));

    }
}
