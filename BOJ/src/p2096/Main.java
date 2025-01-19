package p2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][3];
        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (i == 0) {
                    dpMax[i][j] = Integer.parseInt(s[j]);
                    dpMin[i][j] = Integer.parseInt(s[j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMax[i][j] = map[i][j] + Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]);
                    dpMin[i][j] = map[i][j] + Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]);
                } else if (j == 1) {
                    dpMax[i][j] = map[i][j] + Math.max(dpMax[i - 1][j], Math.max(dpMax[i - 1][j - 1], dpMax[i - 1][j + 1]));
                    dpMin[i][j] = map[i][j] + Math.min(dpMin[i - 1][j], Math.min(dpMin[i - 1][j - 1], dpMin[i - 1][j + 1]));
                } else {
                    dpMax[i][j] = map[i][j] + Math.max(dpMax[i - 1][j - 1], dpMax[i - 1][j]);
                    dpMin[i][j] = map[i][j] + Math.min(dpMin[i - 1][j - 1], dpMin[i - 1][j]);
                }
            }
        }
        int max = Math.max(dpMax[n - 1][0], Math.max(dpMax[n - 1][1], dpMax[n - 1][2]));
        int min = Math.min(dpMin[n - 1][0], Math.min(dpMin[n - 1][1], dpMin[n - 1][2]));
        System.out.println(max + " " + min);
    }
}
