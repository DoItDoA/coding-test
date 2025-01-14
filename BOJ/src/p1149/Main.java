package p1149;
// 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] c = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            c[i][0] = Integer.parseInt(s[0]);
            c[i][1] = Integer.parseInt(s[1]);
            c[i][2] = Integer.parseInt(s[2]);
        }

        int[][] dp = new int[n][3];
        dp[0][0] = c[0][0];
        dp[0][1] = c[0][1];
        dp[0][2] = c[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + c[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + c[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + c[i][2];
        }

        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}
