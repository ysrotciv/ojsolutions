package space.yangshuai.ojsolutions.leetcode.contest.contest135;

/**
 * @author yangshuai on 2019-05-05.
 */
public class SolutionA {

    class Point {
        float x;
        float y;
        Point(int[] arr) {
            this.x =arr[0];
            this.y = arr[1];
        }

        public boolean equals(Point other) {
            return x == other.x && y == other.y;
        }
    }

    public boolean isBoomerang(int[][] points) {

        Point a = new Point(points[0]);
        Point b = new Point(points[1]);
        Point c = new Point(points[2]);

        if (a.equals(b) || b.equals(c) || a.equals(c)) {
            return false;
        }

        if (a.y - b.y == 0 && b.y - c.y == 0) {
            return false;
        }

        if (a.y - b.y == 0 && b.y - c.y != 0) {
            return true;
        }

        if (a.y - b.y != 0 && b.y - c.y == 0) {
            return true;
        }



        return ((a.x - b.x) / (a.y - b.y)) != ((b.x - c.x) / (b.y - c.y));
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0}, {0, 0}, {2, 0}};
        new SolutionA().isBoomerang(arr);
    }

}
