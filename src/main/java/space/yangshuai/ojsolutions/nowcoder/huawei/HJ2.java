package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ) ) ;
        String input = br.readLine().toLowerCase();
        char compare = br.readLine().toLowerCase().charAt(0);

        int count = 0;
        for (char c : input.toCharArray()) {
            if (compare == c) {
                count++;
            }
        }
        System.out.println(count);
    }
}
