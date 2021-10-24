package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.util.Scanner;

public class HJ7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float val = sc.nextFloat();
        int a = (int)val;
        if (val-a >= 0.5) {
            a++;
        }
        System.out.println(a);
    }
}
