package space.yangshuai.codejam.qround;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by yang
 * Created on 09/04/2017.
 */
public class ProblemB {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            System.out.println("Case #" + i + ": " + tidy(line.toCharArray()));
        }
    }

    private static String tidy(char[] origin) {
        int i;
        for (i = 0; i < origin.length - 1; ++i) {
            if (origin[i] > origin[i + 1]) {
                origin[i] -= 1;
                i--;
                while (i >= 0 && origin[i] > origin[i + 1]) {
                    origin[i] -= 1;
                    i--;
                }
                i++;
                break;
            }
        }
        for (int j = i + 1; j < origin.length; ++j) {
            origin[j] = '9';
        }

        String result = new String(origin);
        if (result.charAt(0) == '0') {
            result = result.substring(1);
        }

        return result;
    }

}
