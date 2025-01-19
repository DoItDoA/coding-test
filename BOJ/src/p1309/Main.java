package p1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 9901;
        long[][] dp = new long[n + 1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 3;

        dp[1][0] = 2;
        dp[1][1] = 2;
        dp[1][2] = 3;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][1] + dp[i - 1][2]) % mod;
                } else if (j == 1) {
                    dp[i][j] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
                } else {
                    dp[i][j] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
                }
            }
        }
        long[] list = dp[n - 1];
        long sum = 0;
        for (long num : list) {
            sum += num;
        }
        System.out.println(sum % mod);
    }
}
