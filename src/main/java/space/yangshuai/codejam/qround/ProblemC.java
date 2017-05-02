package space.yangshuai.codejam.qround;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by yang
 * Created on 09/04/2017.
 */
public class ProblemC {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int n = Integer.valueOf(arr[0]);
            int k = Integer.valueOf(arr[1]);
            System.out.println("Case #" + i + ": " + distances(n, k));
        }
    }

    private static String distances(int n, int k) {

        Queue<Tuple> queue = new PriorityQueue<>();


        List<Tuple> list = new ArrayList<>();
        list.add(new Tuple(0, n));
        int minDis = 0;
        int maxDis = 0;

        for (int i = 0; i < k; ++i) {
            int max = 0;
            int index = 0;
            int listIndex = 0;
            int j;

            for (j = 0; j < list.size(); ++j) {
                Tuple tuple = list.get(j);
                if (tuple.value > max) {
                    index = tuple.index;
                    max = tuple.value;
                    listIndex = j;
                }
            }

            Tuple tuple = list.get(listIndex);
            minDis = (max - 1) / 2;
            maxDis = max - minDis - 1;
            tuple.value = minDis;
            list.add(listIndex + 1, new Tuple(index + tuple.value + 1, maxDis));
        }

        return maxDis + " " + minDis;
    }

}
