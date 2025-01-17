package p11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[][] dp = new int[n + 1][];

        for (int i = 0; i <= n; i++) {
            dp[i] = new int[i + 1];
            dp[i][0] = 1;
            dp[i][i] = 1;
        }


        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
            }
        }
        System.out.println(dp[n][k]);
    }
}
