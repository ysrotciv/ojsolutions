package space.yangshuai.ojsolutions.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rotciv on 2017/1/5.
 */
public class Solution381 {

    private int index;
    private int[] nums;
    private ArrayList<Integer> list;
    private HashMap<Integer, ArrayList<Integer>> map;

    /** Initialize your data structure here. */
    public Solution381() {
        index = 0;
        nums = new int[100];
        list = new ArrayList<>();
        map = new HashMap();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        if (index == nums.length) {
            int[] newNums = new int[nums.length * 2];
            System.arraycopy( nums, 0, newNums, 0, nums.length );
            nums = newNums;
        }
        nums[index] = val;
        ArrayList list = map.get(val);
        if (list == null) {
            list = new ArrayList();
            result = true;
        }
        list.add(index);
        map.put(val, list);
        this.list.add(index);
        index++;
        return result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean result = false;
        ArrayList list = map.get(val);
        if (list != null) {
            int index = (int) list.remove(0);
            this.list.remove(Integer.valueOf(index));
            if (list.size() == 0)
                map.remove(val);
            result = true;
        }

        return result;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int length = list.size();
        int listIndex = (int) (Math.random() * length);
        int index = (int) list.get(listIndex);
        return nums[index];
    }

    public static void main(String[] args) {
        Solution381 randomizedCollection = new Solution381();
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(10));
        System.out.println(randomizedCollection.insert(100));
        System.out.println(randomizedCollection.insert(10));
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
    }
}
