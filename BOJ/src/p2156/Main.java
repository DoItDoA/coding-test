package p2156;
// 어려움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));
        if (n == 1) {
            System.out.println(dp[0]);
            return;
        } else if (n == 2) {
            System.out.println(dp[1]);
            return;
        }

        int max = dp[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(wine[i] + wine[i - 1] + dp[i - 3], wine[i] + dp[i - 2]));
            if (max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}
