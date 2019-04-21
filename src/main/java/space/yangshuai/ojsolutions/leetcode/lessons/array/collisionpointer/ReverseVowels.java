package space.yangshuai.ojsolutions.leetcode.lessons.array.collisionpointer;

import java.awt.print.Pageable;

public class ReverseVowels {

    public String reverseVowels(String s) {

        int head = 0;
        int tail = s.length() - 1;

        char[] arr = s.toCharArray();

        while (head < tail) {

            char headChar = arr[head];
            if (!isVowel(headChar)) {
                head++;
                continue;
            }
            char tailChar = arr[tail];
            if (!isVowel(tailChar)) {
                tail--;
                continue;
            }

            arr[head] = tailChar;
            arr[tail] = headChar;

            head++;
            tail--;
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        new ReverseVowels().reverseVowels("hello");
    }
}
