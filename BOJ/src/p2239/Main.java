package p2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        recur(0, 0);
    }

    private static void recur(int x, int y) {
        if (x == 8 && y == 8) {
            compleate();
            System.exit(0);
        }

        for (int i = x; i < 9; i++) {
            for (int j = y; j < 9; j++) {
                if (map[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (!check(num, i, j)) continue;

                        map[i][j] = num;
                        recur(i, j);
                        map[i][j] = 0;
                    }
                    return;
                }
                if (i == 8 && j == 8) {
                    compleate();
                    System.exit(0);
                }
            }
            y = 0;
        }
    }

    private static void compleate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int num, int x, int y) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (x / 3 == i / 3 && y / 3 == j / 3) {
                    if (num == map[i][j]) return false;
                }
            }
        }

        for (int n : map[x]) {
            if (n == num) return false;
        }


        for (int j = 0; j < 9; j++) {
            if (map[j][y] == num) return false;
        }
        return true;
    }
}
