package p11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] map;
    private static boolean[] chk;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][n];
        chk = new boolean[n];

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]) - 1;
            int n2 = Integer.parseInt(s[1]) - 1;
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                cnt++;
                chk[i] = true;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int num) {
        for (int i = 0; i < n; i++) {
            if (map[num][i] == 1 && !chk[i]) {
                chk[i] = true;
                dfs(i);
            }
        }
    }
}
