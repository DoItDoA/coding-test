package p14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        h = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);

        int[][] map = new int[h][w];
        int[] block = new int[w];
        s = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < w; i++) {
            int b = block[i];
            for (int j = 0; j < b; j++) {
                map[j][i] = 1;
            }
        }

        for (int j = 0; j < w - 1; j++) {
            for (int i = h - 1; i >= 0; i--) {
                if (map[i][j] == 1) {
                    boolean isSide = false;
                    for (int k = 1 + j; k < w; k++) {
                        if (map[i][k] == 1) {
                            isSide = true;
                            break;
                        }
                    }
                    if (isSide) {
                        for (int k = 1 + j; k < w; k++) {
                            if (map[i][k] == 0) {
                                map[i][k] = 2;
                            } else if (map[i][k] == 1) break;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 2) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
