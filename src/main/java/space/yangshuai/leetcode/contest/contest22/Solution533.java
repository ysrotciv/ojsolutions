package space.yangshuai.leetcode.contest.contest22;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rotciv on 2017/3/5.
 */
public class Solution533 {

    public int findBlackPixel(char[][] picture, int N) {

        Set<Integer> horizontal = new HashSet<>();
        Set<Integer> hTemp = new HashSet<>();
        Set<Integer> vTemp = new HashSet<>();
        Set<Integer> vertical = new HashSet<>();

        int count;

        for (int i = 0; i < picture.length; ++i) {
            count = 0;
            for (int j = 0; j < picture[0].length; ++j) {
                if (picture[i][j] == 'B') {
                    vTemp.add(i);
                    hTemp.add(j);
                    count++;
                }
            }
            if (count == N) {
                vertical.add(i);
                horizontal.addAll(hTemp);
            }
            hTemp.clear();
            vTemp.clear();
        }

        for (int j: horizontal) {
            count = 0;
            for (int i = 0; i < picture.length; ++i) {
                if (picture[i][j] == 'B') {
                    count++;
                }
            }
            if (count != N) {
                hTemp.add(j);
            }
        }
        horizontal.removeAll(hTemp);

        return vertical.size() * horizontal.size();
    }

    public static void main(String[] args) {

        String[] arr = new String[]{"WBWBBW","WBWBBW","WBWBBW","BWBWWB"};
        char[][] d2 = new char[arr.length][arr[0].length()];

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length(); ++j) {
                d2[i][j] = arr[i].charAt(j);
            }
        }

        System.out.println(new Solution533().findBlackPixel(d2, 3));

    }
}
