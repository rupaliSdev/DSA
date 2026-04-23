package DSA.Strings.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    /*
    * Given board + word list, return all words found in grid.

📌 Example
board =
a b c e
s f c s
a d e e

words = ["abcced","see","abcb"]

Output: ["abcced","see"]
    *
    *
    *
    * */


    public List<String> findWords(char[][] board, String[] words) {

        TrieNode node = buildTrie(words);
        List<String> res = new ArrayList<>();


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                dfs(board, i, j, node, res);
            }
        }
        return res;

    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {

        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }


        // mark visited
        board[i][j] = '#';

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 &&
                    ni < board.length && nj < board[0].length) {
                dfs(board, ni, nj, node, res);
            }
        }

        // backtrack
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.word = w;
        }
        return root;
    }
}


class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
}
