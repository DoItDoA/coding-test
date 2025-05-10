package p5397;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] str = br.readLine().toCharArray();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : str) {
                if (c == '<') {
                    if (left.isEmpty()) continue;
                    right.push(left.pop());
                } else if (c == '>') {
                    if (right.isEmpty()) continue;
                    left.push(right.pop());
                } else if (c == '-') {
                    if (left.isEmpty()) continue;
                    left.pop();
                } else {
                    left.push(c);
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            System.out.println(sb);
        }
    }
}
