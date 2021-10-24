package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.util.Scanner;

public class HJ6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        long k = (long) Math.sqrt(value);
        int a = 2;
        while (true) {
            if (value % a == 0) {
                System.out.print(a + " ");
                value /= a;
                if (value == 1) {
                    break;
                } else if (a > k) {
                    System.out.print(value + " ");
                    break;
                }
            } else {
                a++;
            }
        }
    }
}
