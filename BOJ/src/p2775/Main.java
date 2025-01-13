package p2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k + 1][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = i + 1;
            }

            for (int i = 1; i <= k; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += dp[i - 1][j];
                    dp[i][j] = sum;
                }
            }
            System.out.println(dp[k][n - 1]);
        }
    }
}
