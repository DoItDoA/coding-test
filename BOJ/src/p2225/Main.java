package p2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        long[][] dp = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
            }
        }
        System.out.println(dp[k][n]);
    }
}
