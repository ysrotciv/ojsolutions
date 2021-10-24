package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.util.Scanner;

public class HJ5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next().replace("0x", "");
            System.out.println(Integer.parseInt(line, 16));
        }
    }
}
