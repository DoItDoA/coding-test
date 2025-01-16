package p11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        long[][] dp = new long[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = i + 1;
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }
        System.out.println(dp[n - 1][9]);
    }
}
