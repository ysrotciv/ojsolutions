package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.util.Scanner;

public class HJ4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next();
            for (int i = 0; i < line.length(); i+= 8) {
                if (i + 7 < line.length()) {
                    System.out.println(line.substring(i, i + 8));
                } else {
                    StringBuilder builder = new StringBuilder(line.substring(i));
                    for (int j = line.length() - i; j <= 7; j++) {
                        builder.append('0');
                    }
                    System.out.println(builder);
                }
            }
        }

    }
}
