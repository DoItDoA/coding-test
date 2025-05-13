package p12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static String s, t;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        char[] cArr = br.readLine().toCharArray();
        Deque<Character> dq = new LinkedList<>();
        for (char c : cArr) {
            dq.addLast(c);
        }
        recur(dq);
        System.out.println(result);
    }

    private static void recur(Deque<Character> dq) {
        if (dq.size() == s.length()) {
            String t = "";
            for (char c : dq) t += String.valueOf(c);
            if (s.equals(t)) result = 1;
            return;
        }

        if (dq.peekLast() == 'A') {
            char poll = dq.pollLast();
            recur(dq);
            dq.addLast(poll);
        }
        if (dq.peekFirst() == 'B') {
            char poll = dq.pollFirst();
            Deque<Character> ndq = new LinkedList<>();
            for (char c : dq) {
                ndq.addFirst(c);
            }
            recur(ndq);
            dq.addFirst(poll);
        }
    }
}
