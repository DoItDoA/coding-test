package p5052;

import java.util.*;
import java.io.*;

public class Main {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String tel) {
            TrieNode curr = root;
            for (char ch : tel.toCharArray()) {
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
        }

        public boolean chk(String tel) {
            TrieNode curr = root;
            for (char ch : tel.toCharArray()) {
                if (curr.children.containsKey(ch)) {
                    curr = curr.children.get(ch);
                    if (curr.isEnd) return false;
                } else return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean isConsistence = true;
            while (n-- > 0) {
                String tel = br.readLine();
                if (!trie.chk(tel)) isConsistence = false;
                trie.insert(tel);
            }
            System.out.println(isConsistence ? "YES" : "NO");
        }
    }
}
