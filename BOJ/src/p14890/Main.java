package p14890;
// 존나 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static int[][] map;
    private static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] road = map[i];
            if (roadPass(road)) count++;
        }

        for (int i = 0; i < n; i++) {
            int[] road = new int[n];
            for (int j = 0; j < n; j++) {
                road[j] = map[j][i];
            }
            if (roadPass(road)) count++;
        }
        System.out.println(count);
    }

    private static boolean roadPass(int[] road) {
        boolean[] chk = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            if (road[i] == road[i + 1]) continue;
            else if (road[i] + 1 == road[i + 1]) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || road[i] != road[i - j] || chk[i - j]) {
                        return false;
                    }
                    chk[i - j] = true;
                }
            } else if (road[i] - 1 == road[i + 1]) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || road[i + 1] != road[i + j] || chk[i + j]) {
                        return false;
                    }
                    chk[i + j] = true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
