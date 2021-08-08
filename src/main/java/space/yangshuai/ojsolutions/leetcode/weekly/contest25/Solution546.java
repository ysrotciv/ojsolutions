package space.yangshuai.ojsolutions.leetcode.weekly.contest25;

import java.util.*;

/**
 * Created by rotciv on 2017/3/26.
 */
public class Solution546 {

    class Pair {
        int val;
        int num;

        public Pair(int val, int num) {
            this.val = val;
            this.num = num;
        }
    }

    public int removeBoxes(int[] boxes) {
        int sum = 0;
        List<Pair> list = new ArrayList<Pair>();
        Map<Integer, Integer> map = new HashMap<>();
        int temp = boxes[0];
        int count = 1;
        for (int i = 1; i < boxes.length; ++i) {
            if (boxes[i] != temp) {
                addNewValue(list, map, temp, count);
                temp = boxes[i];
                count = 1;
            } else {
                count++;
            }
        }
        addNewValue(list, map, temp, count);
        return 0;
    }

    private int removeSingle(List<Pair> list, Map<Integer, Integer> map) {
        int sum = 0;
        Iterator<Pair> iterator = list.iterator();
        Pair current;
        Pair pre = null;
        if (iterator.hasNext()) current = iterator.next();
        else return sum;
        while (iterator.hasNext()) {
            if(map.get(current.val) == 1) {
                sum += current.num * current.num;
                iterator.remove();
                current = iterator.next();
                if (pre != null) {
                    while (current != null && pre.val == current.val) {
                        pre.num = pre.num + current.num;
                        current = iterator.next();
                    }
                }
            } else {
                pre = current;
                current = iterator.next();
            }
        }

        return 0;
    }

    private void addNewValue(List<Pair> list, Map<Integer, Integer> map, int val, int num) {
        list.add(new Pair(val, num));
        int count = map.getOrDefault(val, 0);
        map.put(val, count + 1);

    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.getOrDefault(0, 0));
    }

}
