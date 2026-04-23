package DSA.Strings.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Trie {
    static TrieNode node;

    static class TrieNode {
        TrieNode[] childrens;
        boolean isEnd;
        int count = 0;

        public TrieNode() {
            this.childrens = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public static void insertWord(String word) {
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.childrens[idx] == null) {
                node.childrens[idx] = new TrieNode();
            }
            node.count++;
            node = node.childrens[idx];

        }
        node.isEnd = true; //word ending here
    }

    public static boolean searchWord(String word) {
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.childrens[idx] == null) {
                return false;
            }
            node = node.childrens[idx];
        }
        return node.isEnd;
    }

    public static boolean deleteTheWord(String word) {

        Stack<TrieNode> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.childrens[idx] == null) {
                return false;
            }
            stack.push(node);
            node = node.childrens[idx];
        }
        if (!node.isEnd) return false;
        node.isEnd = false;

        for (int i = word.length() - 1; i >= 0; i--) {
            TrieNode parent = stack.pop();
            int idx = word.charAt(i) - 'a';
            if (!node.isEnd && isEmpty(node)) {
                parent.childrens[idx] = null;
                node = parent;
            }
            else break;
        }
        return true;
    }

    public static boolean isEmpty(TrieNode parent) {
        for (TrieNode child : node.childrens)
            if (child != null) return false;
        return true;
    }

}
