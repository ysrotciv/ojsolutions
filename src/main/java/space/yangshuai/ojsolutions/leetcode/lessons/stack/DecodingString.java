package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.Stack;

/**
 * @author yangshuai on 2019-05-05.
 */
public class DecodingString {

    public String decodeString(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder total = new StringBuilder();

        Stack<String> stack = new Stack<>();

        boolean isDigit = true;


        for (char c : s.toCharArray()) {
            if (c != '[' && c != ']') {
                if (!isDigit && Character.isDigit(c)) {
                    if (stringBuilder.length() > 0) {
                        stack.push(stringBuilder.toString());
                    }
                    stringBuilder = new StringBuilder();
                    isDigit = true;
                } else {
                    isDigit = Character.isDigit(c);
                }
                stringBuilder.append(c);
            } else {
                if (c == '[') {
                    stack.push(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    stack.push("[");
                    isDigit = false;
                } else {
                    String raw = stringBuilder.toString();
                    if (raw.isEmpty()) {
                        raw = stack.pop();
                    }
                    String peek = stack.pop();
                    if (!peek.equals("[")) {
                        raw = peek + raw;
                        stack.pop();
                        stringBuilder = new StringBuilder();
                    }
                    int ratio = Integer.parseInt(stack.pop());
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < ratio; ++i) {
                        result.append(raw);
                    }
                    if (!stack.isEmpty()) {
                        String head = stack.peek();
                        if (head.equals("[")) {
                            stack.push(result.toString());
                        } else {
                            stack.pop();
                            stack.push(head + result.toString());
                        }
                        stringBuilder = new StringBuilder();
                    } else {
                        total.append(result.toString());
                        stringBuilder = new StringBuilder();
                    }
                }
            }
        }

        if (!stack.empty()) {
            total.append(stack.pop());
        }

        if (stringBuilder.length() > 0) {
            total.append(stringBuilder);
        }

        return total.toString();
    }

    public static void main(String[] args) {
        assert("aaabcbc".equals(new DecodingString().decodeString("3[a]2[bc]")));
        assert("accaccacc".equals(new DecodingString().decodeString("3[a2[c]]")));
        assert("abcabccdcdcdef".equals(new DecodingString().decodeString("2[abc]3[cd]ef")));
        assert ("aaabFFFFcbFFFFc".equals(new DecodingString().decodeString("3[a]2[b4[F]c]")));
        assert ("sdfeegfeegi".equals(new DecodingString().decodeString("sd2[f2[e]g]i")));
        new DecodingString().decodeString("100[leetcode]");
        assert ("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef".equals(new DecodingString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")));
    }

}
