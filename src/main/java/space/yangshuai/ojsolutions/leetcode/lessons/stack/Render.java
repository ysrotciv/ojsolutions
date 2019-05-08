package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author yangshuai on 2019-05-08.
 */
public class Render {

    private Set<String> set = new HashSet<>();
    private int length;
    private int width;
    private int oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        LinkedList<int[]> queue = new LinkedList<>();
        queue.push(new int[]{sr, sc});
        length = image.length;
        width = image[0].length;
        oldColor = image[sr][sc];

        while (queue.size() > 0) {
            int[] node = queue.pop();
            int x = node[0];
            int y = node[1];
            String str = String.format("%s_%s", x, y);
            set.add(str);
            image[x][y] = newColor;
            addNode(x + 1, y, queue, image);
            addNode(x - 1, y, queue, image);
            addNode(x, y + 1, queue, image);
            addNode(x, y - 1, queue, image);
        }

        return image;
    }

    private void addNode(int x, int y, LinkedList<int[]> queue, int[][] image) {

        if (x < 0 || x >= length) {
            return;
        }
        if (y < 0 || y >= width) {
            return;
        }
        if (image[x][y] != oldColor) {
            return;
        }
        if (set.contains(String.format("%s_%s", x, y))) {
            return;
        }
        queue.push(new int[]{x, y});
    }

}
