package space.yangshuai.ojsolutions.leetcode.common.utils;

/**
 * @author yangshuai on 2019-04-22.
 */
public class ArrayParser {

    public static char[][] parse(String raw) {
        String[] arr = raw.trim().split("\\],");
        int height = arr.length;
        int width = arr[0].split(",").length;
        char[][] result = new char[height][width];
        for (int i = 0; i < height; ++i) {
            String[] temp = arr[i].replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "").split(",");
            for (int j = 0; j < width; ++j) {
                result[i][j] = temp[j].charAt(0);
            }
        }

        return result;
    }
}
