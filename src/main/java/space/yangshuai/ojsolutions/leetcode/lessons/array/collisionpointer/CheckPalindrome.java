package space.yangshuai.ojsolutions.leetcode.lessons.array.collisionpointer;

public class CheckPalindrome {

    public boolean isPalindrome(String s) {

        int head = 0;
        int tail = s.length() - 1;

        while (head < tail) {
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            if (!Character.isAlphabetic(headChar) && !Character.isDigit(headChar)) {
                head++;
                continue;
            }
            if (!Character.isAlphabetic(tailChar) && !Character.isDigit(tailChar)) {
                tail--;
                continue;
            }

            if (Character.isUpperCase(headChar)) {
                headChar = Character.toLowerCase(headChar);
            }

            if (Character.isUpperCase(tailChar)) {
                tailChar = Character.toLowerCase(tailChar);
            }

            if (headChar != tailChar) {
                return false;
            }

            head++;
            tail--;
        }

        return true;
    }

}
