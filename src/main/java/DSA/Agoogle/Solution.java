package DSA.Agoogle;

import java.util.*;

class Solution {

    enum Type { CHAR, DISJ, REP, CONCAT }

    static class Node {
        Type type;
        Node left, right;
        char c;
    }

    public boolean isMatch(String s, Node root) {
        Set<Integer> res = match(root, s, 0);
        return res.contains(s.length());
    }

    private Set<Integer> match(Node node, String s, int start) {
        Set<Integer> result = new HashSet<>();

        if (node == null) return result;

        switch (node.type) {

            case CHAR:
                if (start < s.length() && s.charAt(start) == node.c) {
                    result.add(start + 1);
                }
                return result;

            case DISJ:
                result.addAll(match(node.left, s, start));
                result.addAll(match(node.right, s, start));
                return result;

            case CONCAT:
                for (int mid : match(node.left, s, start)) {
                    result.addAll(match(node.right, s, mid));
                }
                return result;

            case REP:
                result.add(start);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);

                while (!queue.isEmpty()) {
                    int curr = queue.poll();

                    for (int next : match(node.left, s, curr)) {
                        if (!result.contains(next)) {
                            result.add(next);
                            queue.add(next);
                        }
                    }
                }
                return result;
        }

        return result;
    }
}