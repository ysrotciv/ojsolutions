package space.yangshuai.ojsolutions.leetcode.weekly.contest28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rotciv on 2017/4/16.
 */
public class Solution555 {

    private static PriorityQueue<String> strQueue;
    private static String[] strArr;

    public String splitLoopedString(String[] strs) {

        lexico(strs);
        strArr = strs;
        ArrayList<LexicoString> lexicoStrings = maxIndexes(strs);
        strQueue = new PriorityQueue<>(lexicoStrings.size(), Collections.reverseOrder());
        int maxIndex = 0;

        for (int i = 0; i < lexicoStrings.size(); ++i) {
            addString(lexicoStrings.get(i));
        }

        return strQueue.poll();
    }

    private static void addString(LexicoString lexicoString) {
        StringBuilder builder = new StringBuilder();
        String str = strArr[lexicoString.index];
        builder.append(str.substring(lexicoString.maxCharIndex));
        for (int i = lexicoString.index + 1; i < strArr.length; ++i) {
            builder.append(strArr[i]);
        }
        for (int i = 0; i < lexicoString.index; ++i) {
            builder.append(strArr[i]);
        }
        builder.append(str.substring(0, lexicoString.maxCharIndex));
        strQueue.add(builder.toString());

        builder = new StringBuilder();
        int reverseIndex = str.length() - 1 - lexicoString.maxCharIndex;
        String reverseStr = new StringBuilder(str).reverse().toString();
        builder.append(reverseStr.substring(reverseIndex));
        for (int i = lexicoString.index + 1; i < strArr.length; ++i) {
            builder.append(strArr[i]);
        }
        for (int i = 0; i < lexicoString.index; ++i) {
            builder.append(strArr[i]);
        }
        builder.append(reverseStr.substring(0, reverseIndex));
        strQueue.add(builder.toString());
    }

    private static void lexico(String[] strs) {

        boolean reverse = false;

        for (int j = 0; j < strs.length; ++j) {

            String str = strs[j];
            reverse = false;

            for (int i = 0; i < str.length() / 2; ++i) {
                if (str.charAt(i) < str.charAt(str.length() - i - 1)) {
                    reverse = true;
                    break;
                } else if (str.charAt(i) > str.charAt(str.length() - i - 1)) {
                    break;
                }
            }

            if (reverse) {
                str = new StringBuilder(str).reverse().toString();
                strs[j] = str;
            }
        }

    }

    private static ArrayList<LexicoString> maxIndexes(String[] strs) {
        ArrayList<LexicoString> list = new ArrayList<>();
        char max = 'a' - 1;
        for (int i = 0; i < strs.length; ++i) {
            String str = strs[i];
            for (int j = 0; j < str.length(); ++j) {
                char c = str.charAt(j);
                if (c > max) {
                    max = c;
                    list.clear();
                    list.add(new LexicoString(i, j));
                } else if (c == max) {
                    list.add(new LexicoString(i, j));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution555().splitLoopedString(new String[]{"awef","eawf","zdaeff","awefzewaf","awefzewaf"}));
    }

}
