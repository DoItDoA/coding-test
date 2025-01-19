package p9184;
// 보류
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if (a == -1 && b == -1 && c == -1) {
                return;
            }
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }

    private static int w(int a, int b, int c) {
        if (inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    private static boolean inRange(int a, int b, int c) {
        return 0 <= a && a < 21 && 0 <= b && b < 21 && 0 <= c && c < 21;
    }
}
