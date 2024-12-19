package BFS.p2606;

import java.io.*;
import java.util.*;

public class Main {
    private static int v, e;
    private static boolean[][] map;
    private static boolean[] check;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        map = new boolean[v][v];
        check = new boolean[v];

        for (int i = 0; i < e; i++) {
            String[] val = br.readLine().split(" ");
            int i1 = Integer.parseInt(val[0]) - 1;
            int i2 = Integer.parseInt(val[1]) - 1;
            map[i1][i2] = true;
            map[i2][i1] = true;
        }
//        bfs();
        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int idx) {
        check[idx] = true;
        for (int i = 0; i < v; i++) {
            if (map[idx][i] && !check[i]) {
                cnt++;
                check[i] = true;
                dfs(i);
            }
        }
    }

    static void bfs() {
        check[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        cnt = 0;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 0; i < v; i++) {
                if (map[poll - 1][i] && !check[i]) {
                    cnt++;
                    check[i] = true;
                    q.add(i + 1);
                }
            }
        }
    }
}
