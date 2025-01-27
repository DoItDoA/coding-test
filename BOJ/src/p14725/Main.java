package p14725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String[] str) {
            TrieNode curr = root;

            for (String s : str) {
                curr.children.putIfAbsent(s, new TrieNode());
                curr = curr.children.get(s);
            }
        }

        public void getAll(StringBuilder sb) {
            get(root, sb, "");
        }

        private static void get(TrieNode node, StringBuilder sb, String m) {
            Set<String> strings = node.children.keySet();
            for (String key : strings) {
                if (node.children.containsKey(key)) {
                    sb.append(m + key).append("\n");
                    get(node.children.get(key), sb, m + "--");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            String[] strings = new String[cnt];
            for (int i = 0; i < cnt; i++) {
                strings[i] = st.nextToken();
            }
            trie.insert(strings);
        }

        StringBuilder sb = new StringBuilder();
        trie.getAll(sb);
        System.out.println(sb);
    }
}
