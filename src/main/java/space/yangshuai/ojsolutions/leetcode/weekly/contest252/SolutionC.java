package space.yangshuai.ojsolutions.leetcode.weekly.contest252;

public class SolutionC {

    public long minimumPerimeter(long neededApples) {

        long sum = 0;
        int level = 1;

        while (neededApples > sum) {
            long temp = (long) (1 + (level - 1)) * (level - 1);
            long border = (1 + level * 2L) * level + temp;
            sum += border * 4;
            level++;
        }
        return (level - 1) * 8L;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionC().minimumPerimeter(496811800468306L));
    }

}
