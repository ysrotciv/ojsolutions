package space.yangshuai.ojsolutions.leetcode.weekly.contest137;

import java.util.*;

public class SolutionC {

    class Node {
        int level;
        String word;

        Node(int level, String word) {
            this.level = level;
            this.word = word;
        }
    }

    public int longestStrChain(String[] words) {

        if (words.length == 1) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        Map<Integer, List<String>> map = new HashMap<>(words.length);
        for (String word : words) {
            int size = word.length();
            if (size < min) {
                min = size;
            }
            List<String> list = map.getOrDefault(size, new ArrayList<>());
            list.add(word);
            map.put(size, list);
        }

        Map<String, List<String>> wordMap = new HashMap<>(words.length >> 1);

        LinkedList<Node> queue = new LinkedList<>();
        for (String word : words) {
            queue.add(new Node(1, word));
        }

        while (true) {
            List<String> list = map.get(min);
            List<String> nextList = map.get(min + 1);
            if (nextList == null || nextList.isEmpty()) {
                break;
            }
            for (String word : list) {
                List<String> nextWords = new ArrayList<>();
                for (String next : nextList) {
                    if (isPredecessor(word, next)) {
                        nextWords.add(next);
                    }
                }
                wordMap.put(word, nextWords);
            }
            min++;
        }

        while (queue.size() > 0) {
            Node node = queue.pop();
            List<String> nextWords = wordMap.get(node.word);
            if (nextWords == null || nextWords.isEmpty()) {
                if (node.level > result) {
                    result = node.level;
                }
            } else {
                for (String word : nextWords) {
                    queue.add(new Node(node.level + 1, word));
                }
            }
        }

        return result;
    }

    private boolean isPredecessor(String pre, String post) {

        char[] preArr = pre.toCharArray();
        char[] postArr = post.toCharArray();

        int postIndex = 0;
        int times = 0;

        for (int i = 0; i < preArr.length; ++i) {
            if (preArr[i] != postArr[postIndex]) {
                if (times > 0) {
                    return false;
                } else {
                    if (preArr[i] != postArr[postIndex + 1]) {
                        return false;
                    } else {
                        times++;
                        postIndex += 2;
                    }
                }
            } else {
                postIndex++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int result = new SolutionC().longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"});
        System.out.println(result);
    }
}
