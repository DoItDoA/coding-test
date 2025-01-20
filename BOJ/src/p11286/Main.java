package p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            int r = Math.abs(a) - Math.abs(b);
            if (r != 0) return r;
            else return Integer.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (q.isEmpty()) sb.append(0).append("\n");
                else sb.append(q.poll()).append("\n");
            } else {
                q.add(x);
            }
        }
        System.out.println(sb);
    }
}
