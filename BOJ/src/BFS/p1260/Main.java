package BFS.p1260;

import java.io.*;
import java.util.*;

public class Main {
    private static boolean[][] map;
    private static boolean[] dfsChk;
    private static boolean[] bfsChk;
    private static int n, m, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        v = Integer.parseInt(input[2]);

        map = new boolean[n][n];
        dfsChk = new boolean[n];
        bfsChk = new boolean[n];

        for (int i = 0; i < m; i++) {
            String[] val = br.readLine().split(" ");
            int n1 = Integer.parseInt(val[0]);
            int n2 = Integer.parseInt(val[1]);
            map[n1 - 1][n2 - 1] = true;
            map[n2 - 1][n1 - 1] = true;
        }

        dfs(v);
        System.out.println();
        bfs(v);
        System.out.println();
    }

    static void dfs(int idx) {
        dfsChk[idx - 1] = true;
        System.out.print(idx + " ");
        for (int i = 0; i < n; i++) {
            if (map[idx - 1][i] && !dfsChk[i]) {
                dfsChk[i] = true;
                dfs(i + 1);
            }
        }
    }

    static void bfs(int idx) {
        bfsChk[idx - 1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);

        while (!q.isEmpty()) {
            Integer val = q.poll();
            System.out.print(val + " ");
            for (int i = 0; i < n; i++) {
                if (map[val - 1][i] && !bfsChk[i]) {
                    bfsChk[i] = true;
                    q.add(i + 1);
                }
            }
        }
    }
}
