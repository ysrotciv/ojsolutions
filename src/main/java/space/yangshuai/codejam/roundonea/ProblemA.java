package space.yangshuai.codejam.roundonea;

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
            int row = Integer.valueOf(arr[0]);
            int column = Integer.valueOf(arr[1]);
            char[][] grids = new char[row][column];
            for (int j = 0; j < row; ++j) {
                line = in.nextLine();
                char[] cArr = line.toCharArray();
                System.arraycopy(cArr, 0, grids[j], 0, column);
            }
            System.out.println("Case #" + i + ": ");
            if (row != 0 && column != 0) {
                assign(grids);
            }
        }
    }

    private static void assign(char[][] grids) {

        int height = grids.length;
        int width = grids[0].length;

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (grids[i][j] == ('?')) {
                    if (j > 0) {
                        grids[i][j] = grids[i][j - 1];
                    } else {
                        int k = j + 1;
                        while (k < width) {
                            if (grids[i][k] != ('?')) {
                                for (int l = j; l < k; ++l) {
                                    grids[i][l] = grids[i][k];
                                }
                                break;
                            } else {
                                ++k;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (grids[j][i] == ('?')) {
                    if (j > 0) {
                        grids[j][i] = grids[j - 1][i];
                    } else {
                        int k = j + 1;
                        while (k < height) {
                            if (grids[k][i] != ('?')) {
                                for (int l = j; l < k; ++l) {
                                    grids[l][i] = grids[k][i];
                                }
                                break;
                            } else {
                                ++k;
                            }
                        }
                    }
                }
            }
        }

        for (char[] grid : grids) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < width; ++j) {
                builder.append(grid[j]);
            }
            System.out.println(builder.toString());
        }
    }
}
