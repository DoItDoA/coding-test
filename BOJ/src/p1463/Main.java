package p1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];

        for (int i = 2; i <= n; i++) {
            dp[i - 1] = dp[i - 2] + 1;

            if (i % 2 == 0) {
                int d1 = dp[i - 1];
                int d2 = dp[i / 2 - 1] + 1;
                dp[i - 1] = Math.min(d1, d2);
            }

            if (i % 3 == 0) {
                int d1 = dp[i - 1];
                int d2 = dp[i / 3 - 1] + 1;
                dp[i - 1] = Math.min(d1, d2);
            }
        }

        System.out.println(dp[n - 1]);
    }
}
