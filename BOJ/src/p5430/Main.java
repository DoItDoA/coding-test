package p5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char[] pArr = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            String[] arr = arrStr.substring(1, arrStr.length() - 1).split(",");

            Deque<String> deque = new LinkedList<>();
            for (String a : arr) {
                if (!a.equals(""))
                    deque.addLast(a);
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char p : pArr) {
                if (p == 'R') {
                    isReversed = !isReversed;
                } else if (p == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (!isReversed) deque.removeFirst();
                    else deque.removeLast();
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (!isReversed) sb.append(deque.pollFirst());
                    else sb.append(deque.pollLast());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
