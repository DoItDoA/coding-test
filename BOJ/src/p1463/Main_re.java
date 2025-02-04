package p1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bfs(n));

    }

    private static int bfs(int num) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{num, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int curr = poll[0];

            if (curr == 1) return poll[1];

            for (int k = 0; k < 3; k++) {
                if (k == 0 && curr % 3 == 0) {
                    int next = curr / 3;
                    q.add(new int[]{next, poll[1] + 1});
                } else if (k == 1 && curr % 2 == 0) {
                    int next = curr / 2;
                    q.add(new int[]{next, poll[1] + 1});
                } else if (k == 2) {
                    int next = curr - 1;
                    q.add(new int[]{next, poll[1] + 1});
                }
            }
        }
        return -1;
    }
}
