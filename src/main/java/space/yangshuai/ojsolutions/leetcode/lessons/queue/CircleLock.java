package space.yangshuai.ojsolutions.leetcode.lessons.queue;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author yangshuai on 2019-04-23.
 */
public class CircleLock {

    class Node {
        String value;
        int level;
        Node (String value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    public int openLock(String[] deadends, String target) {

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(new Node("0000", 0));
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) {
            return -1;
        }

        while (queue.size() > 0) {
            Node node = queue.pop();
            if (target.equals(node.value)) {
                return node.level;
            } else {
                addAllStatus(queue, set, node);
            }
        }

        return -1;
    }

    private void addAllStatus(LinkedList<Node> queue, Set set, Node node) {
        char[] arr = node.value.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            int up = arr[i] + 1;
            if (up == 58) {
                up = 48;
            }
            int down = arr[i] - 1;
            if (down == 47) {
                down = 57;
            }
            char[] newArr = new char[4];
            System.arraycopy(arr, 0, newArr, 0, 4);
            newArr[i] = (char)up;
            String upString = new String(newArr);
            if (!set.contains(upString)) {
                queue.add(new Node(upString, node.level + 1));
                set.add(upString);
            }
            System.arraycopy(arr, 0, newArr, 0, 4);
            newArr[i] = (char)down;
            String downString = new String(newArr);
            if (!set.contains(downString)) {
                queue.add(new Node(downString, node.level + 1));
                set.add(downString);
            }
        }
    }

    public static void main(String[] args) {
        new CircleLock().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888");
    }

}
