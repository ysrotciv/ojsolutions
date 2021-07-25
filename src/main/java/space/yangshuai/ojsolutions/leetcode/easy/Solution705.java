package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution705 {

    class MyHashSet {

        int BASE = 769;
        LinkedList<Integer>[] values;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            values = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                values[i] = new LinkedList<>();
            }
        }

        public void add(int key) {
            int k = hash(key);
            for (Integer integer : values[k]) {
                if (integer == key) {
                    return;
                }
            }
            values[k].offerLast(key);
        }

        public void remove(int key) {
            int k = hash(key);
            values[k].removeIf(element -> element == key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int k = hash(key);
            return values[k].contains(key);
        }

        private int hash(int value) {
            return value % BASE;
        }

    }
}
