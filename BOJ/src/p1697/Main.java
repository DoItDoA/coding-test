package p1697;

import java.io.*;
import java.util.*;

public class Main {
    private static int s, d;
    private static boolean[] check = new boolean[200001];
    static class Subin {
        int current;
        int sec;

        public Subin(int c, int s) {
            this.current = c;
            this.sec = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        s = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        if (s == d) {
            System.out.println(0);
            return;
        }
        int sec = bfs(new Subin(5, 0));
        System.out.println(sec);
    }

    static int bfs(Subin subin) {
        Queue<Subin> q = new LinkedList<>();
        q.add(subin);

        while (!q.isEmpty()) {
            Subin s = q.poll();
            int[] method = {s.current * 2, s.current - 1, s.current + 1};
            for (int m : method) {
                if (m >= 0 && m <= 200000 && !check[m]) {
                    check[m] = true;
                    int sec = s.sec + 1;
                    if (m == d) return sec;
                    q.add(new Subin(m, sec));
                }
            }
        }
        return -1;
    }
}
