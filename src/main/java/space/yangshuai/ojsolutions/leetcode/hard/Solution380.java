package space.yangshuai.ojsolutions.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rotciv on 2017/1/5.
 */
public class Solution380 {

    private ArrayList<Integer> list;
    private HashMap map;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public Solution380() {
        list = new ArrayList();
        map = new HashMap();
    }

    /** Inserts a value to the map. Returns true if the map did not already contain the specified element. */
    public boolean insert(int val) {
        Object exist = map.get(val);
        if (exist != null)
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;

    }

    /** Removes a value from the map. Returns true if the map contained the specified element. */
    public boolean remove(int val) {

        boolean exist = map.containsKey(val);
        if (!exist) return false;
        int index = (int)map.get(val);
        int lastOne = list.get(list.size() - 1);
        map.put(lastOne, index);
        list.set(index, lastOne);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;

    }

    /** Get a random element from the map. */
    public int getRandom() {
        int index = (int) (rand.nextInt(list.size()));
        return list.get(index);
    }

    public static void main(String[] args) {
        Solution380 set = new Solution380();
        set.insert(1);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
