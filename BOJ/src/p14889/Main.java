package p14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[] chk;
    private static Integer min = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input);
        map = new int[n][n];
        chk = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(val[j]);
            }
        }

        recur(0, 0);
        System.out.println(min);
    }

    static void recur(int start, int depth) {
        if (depth == n / 2) {
            int n1 = 0;
            for (int i = 0; i < n; i++) {
                if (chk[i]) {
                    for (int j = 0; j < n; j++) {
                        if (chk[j]) {
                            n1 += map[i][j];
                        }
                    }
                }
            }
            int n2 = 0;
            for (int i = 0; i < n; i++) {
                if (!chk[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!chk[j]) {
                            n2 += map[i][j];
                        }
                    }
                }
            }
            int val = Math.abs(n1 - n2);
            if (min == null || val < min) min = val;
            return;
        }

        for (int i = start; i < n; i++) {
            if (!chk[i]) {
                chk[i] = true;
                recur(i, depth + 1);
                chk[i] = false;
            }
        }
    }
}
