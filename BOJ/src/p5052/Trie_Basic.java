package p5052;

import java.util.HashMap;
import java.util.Map;

public class Trie_Basic {
    private static class TrieNode {
        Map<Character, TrieNode> node = new HashMap<>();
        boolean isEnd = false;
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode current = root;
            for (char ch : str.toCharArray()) {
                current.node.putIfAbsent(ch, new TrieNode());
                current = current.node.get(ch);
            }
            current.isEnd = true;
        }

        public boolean search(String str) {
            TrieNode current = root;
            for (char ch : str.toCharArray()) {
                if (!current.node.containsKey(ch)) {
                    return false;
                }
                current = current.node.get(ch);
            }
            return current.isEnd;
        }

        public boolean startsWith(String str) {
            TrieNode current = root;
            for (char ch : str.toCharArray()) {
                if (!current.node.containsKey(ch)) {
                    return false;
                }
                current = current.node.get(ch);
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");

        System.out.println(trie.search("appl"));
        System.out.println(trie.search("apple"));

        System.out.println(trie.startsWith("ap"));
    }
}
