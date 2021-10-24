package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.util.*;

public class HJ3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        List<TreeSet<Integer>> list = new LinkedList<>();
        while (sc.hasNext()) {
            int count  = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            while (count > 0) {
                set.add(sc.nextInt());
                count--;
            }
            list.add(set);
        }
        for (TreeSet<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }
    }

}
