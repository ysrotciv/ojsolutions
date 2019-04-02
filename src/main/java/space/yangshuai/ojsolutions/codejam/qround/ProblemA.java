package space.yangshuai.ojsolutions.codejam.qround;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by yang
 * Created on 08/04/2017.
 */
public class ProblemA {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            String sentence = arr[0];
            int k = Integer.valueOf(arr[1]);
            System.out.println("Case #" + i + ": " + minStep(sentence.toCharArray(), k));
        }
    }

    private static String minStep(char[] s, int k) {

        int count = 0;
        for (int i = 0; i <= s.length - k; ++i) {
            if (s[i] == '-') {
                count++;
                for (int j = i; j < i + k; ++j) {
                    if (s[j] == '-') {
                        s[j] = '+';
                    } else {
                        s[j] = '-';
                    }
                }

            }
        }

        for (int i = s.length - k + 1; i < s.length; ++i) {
            if (s[i] == '-') {
                return "IMPOSSIBLE";
            }
        }

        return count + "";
    }
}
