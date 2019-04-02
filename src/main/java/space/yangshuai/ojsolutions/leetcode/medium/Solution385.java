package space.yangshuai.leetcode.medium;

import space.yangshuai.ojsolutions.leetcode.common.NestedInteger;

/**
 * Created by rotciv on 2017/3/2.
 */
public class Solution385 {

    NestedInteger root = new NestedInteger();
    NestedInteger current = new NestedInteger();

    public NestedInteger deserialize(String s) {


        if (!s.contains("[")) {
            root.setInteger(Integer.valueOf(s));
        } else {
            current = root;
            parse(s);
        }

        return root;
    }

    private void parse(String str) {

        str = str.substring(1, str.length() - 1);
        int firstIndex = str.indexOf('[');

        if (firstIndex != -1) {
            int lastIndex = str.lastIndexOf(']');
            String headStr = str.substring(0, firstIndex);
            String tailStr = str.substring(lastIndex + 1);
            String totalStr = headStr + tailStr;
            if (!totalStr.isEmpty()) {
                String[] arr = totalStr.split(",");
                for (String ele: arr) {
                    if (!ele.isEmpty())
                        current.add(new NestedInteger(Integer.valueOf(ele)));
                }
            }

            String remain = str.substring(firstIndex, lastIndex + 1);
            NestedInteger list = new NestedInteger();
            current.add(list);
            current = list;

            parse(remain);
        } else {
            for (String ele: str.split(",")) {
                if (!ele.isEmpty())
                    current.add(new NestedInteger(Integer.valueOf(ele)));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution385().deserialize("[123,[456,[789]]]"));
    }
}
