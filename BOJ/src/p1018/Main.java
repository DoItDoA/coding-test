package p1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int min = Integer.MAX_VALUE;
    private static Character[][] chess1 = new Character[8][8];
    private static Character[][] chess2 = new Character[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Character[][] map = new Character[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        chess1[i][j] = 'B';
                        chess2[i][j] = 'W';
                    } else {
                        chess1[i][j] = 'W';
                        chess2[i][j] = 'B';
                    }
                } else {
                    if (j % 2 == 0) {
                        chess1[i][j] = 'W';
                        chess2[i][j] = 'B';
                    } else {
                        chess1[i][j] = 'B';
                        chess2[i][j] = 'W';
                    }
                }
            }
        }


        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                chkChess(i, j, map);
            }
        }
        System.out.println(min);
    }

    private static void chkChess(int col, int row, Character[][] map) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                if (map[col + k][row + l] != chess1[k][l]) cnt1++;
                if (map[col + k][row + l] != chess2[k][l]) cnt2++;
            }
        }

        if (min > cnt1) min = cnt1;
        if (min > cnt2) min = cnt2;
    }
}
