package space.yangshuai.ojsolutions.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ) ) ;
        String input = br.readLine( );
        String[] arr = input.split(" ");
        System.out.println(arr[arr.length - 1].length());
    }
}
