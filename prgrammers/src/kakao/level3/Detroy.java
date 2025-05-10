package kakao.level3;

import java.util.*;

public class Detroy {
    class Solution {
        public int solution(int[][] board, int[][] skill) {
            int n = board.length;
            int m = board[0].length;

            int[][] d = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0 && i == 0) d[i][j] = board[i][j];
                    else if (i == 0) d[i][j] = board[i][j] - board[i][j - 1];
                    else if (j == 0) d[i][j] = board[i][j] - board[i - 1][j];
                    else d[i][j] = board[i][j] - board[i][j - 1] - board[i - 1][j] + board[i - 1][j - 1];
                }
            }

            for (int[] s : skill) {
                int type = s[0];
                int r1 = s[1];
                int c1 = s[2];
                int r2 = s[3];
                int c2 = s[4];
                int degree = s[5];
                int by = type == 1 ? -1 : 1;

                d[r1][c1] += by * degree;
                if (c2 + 1 < m) d[r1][c2 + 1] -= by * degree;
                if (r2 + 1 < n) d[r2 + 1][c1] -= by * degree;
                if (c2 + 1 < m && r2 + 1 < n) d[r2 + 1][c2 + 1] += by * degree;
            }


            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    d[i][j] += d[i][j - 1];
                }
            }
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (i >= 1) d[i][j] += d[i - 1][j];
                    if (d[i][j] > 0) cnt++;
                }
            }

            return cnt;
        }
    }
}
