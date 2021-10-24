package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ8 {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        while (count > 0) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            int sum = map.getOrDefault(key, 0);
            sum += value;
            map.put(key, sum);
            count--;
        }

        int[] arr = map.keySet().stream().mapToInt(i -> i).toArray();
        Arrays.sort(arr);
        for (int val : arr) {
            System.out.println(val + " " + map.get(val));
        }

    }
}
