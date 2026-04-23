package DSA.Strings.Trie;

import java.util.List;

public class ReplaceWords {


    /*❓ Problem

Replace words in sentence with shortest root.

📌 Example
dict = ["cat","bat","rat"]
sentence = "the cattle was rattled"

Output: "the cat was rat"*/
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }


    public String replaceWords(List<String> dict, String sentence) {

        TrieNode root = build(dict);
        StringBuilder sb = new StringBuilder();

        for (String word : sentence.split(" ")) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(findRoot(word, root));
        }

        return sb.toString();
    }

    private String findRoot(String word, TrieNode root) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null) return word;

            node = node.children[idx];

            if (node.word != null) return node.word;
        }

        return word;
    }

    private TrieNode build(List<String> dict) {
        TrieNode root = new TrieNode();

        for (String w : dict) {
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
