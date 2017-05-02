package space.yangshuai.codejam.roundonea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by rotciv on 2017/4/15.
 */
public class ProblemB {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            int ingredients = Integer.valueOf(arr[0]);
            int packages = Integer.valueOf(arr[1]);

            int[] standards = new int[ingredients];

            arr = in.nextLine().split(" ");
            for (int j = 0; j < arr.length; ++j) {
                standards[j] = Integer.valueOf(arr[j]);
            }

            List<PriorityQueue<Ingredient>> totalList = new ArrayList<>(ingredients);
            PriorityQueue<Ingredient> queue;

            for (int j = 0; j < ingredients; ++j) {
                queue = new PriorityQueue<>(packages);
                line = in.nextLine();
                arr = line.split(" ");
                for (String str: arr) {
                    Ingredient ingredient = new Ingredient(Integer.valueOf(str), standards[j]);
                    if (ingredient.valid) {
                        queue.add(new Ingredient(Integer.valueOf(str), standards[j]));
                    }
                }
                totalList.add(queue);
            }

            System.out.println("Case #" + i + ": " + kits(totalList));
        }

    }

    private static int kits(List<PriorityQueue<Ingredient>> list) {
        Ingredient[] ingredients = new Ingredient[list.size()];
        int sum = 0;

        float min = Float.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).isEmpty()) {
                return 0;
            }
            ingredients[i] = list.get(i).poll();
            if (ingredients[i].ratio < min) {
                min = ingredients[i].ratio;
                minIndex = i;
            }
        }

        while (true) {

            int[] result = intersection(ingredients);
            if (result != null) {
                sum++;
                for (int i = 0; i < list.size(); ++i) {
                    if (list.get(i).isEmpty()) {
                        return sum;
                    }
                    ingredients[i] = list.get(i).poll();
                    if (ingredients[i].ratio < min) {
                        min = ingredients[i].ratio;
                        minIndex = i;
                    }
                }
            } else {
                if (list.get(minIndex).isEmpty()) {
                    return sum;
                }
                ingredients[minIndex] = list.get(minIndex).poll();
            }
        }
    }

    private static int[] intersection(Ingredient[] ingredients) {

        Ingredient head = ingredients[0];
        int min = head.min;
        int max = head.max;

        for (int i = 1; i < ingredients.length; ++i) {
            Ingredient ingredient = ingredients[i];
            if (ingredient.min > min) {
                min = ingredient.min;
            }
            if (ingredient.max < max) {
                max = ingredient.max;
            }

            if (min > max) {
                return null;
            }
        }

        return new int[]{min, max};
    }


}
