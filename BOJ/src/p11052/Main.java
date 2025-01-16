package p11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] price = new int[n];
        int[] dp = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(s[i]);
        }

        dp[0] = price[0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int i1 = dp[j];
                int i2 = price[i - 1 - j];
                max = Math.max(dp[j] + price[i - 1 - j], max);
            }
            dp[i] = Math.max(max, price[i]);
        }
        System.out.println(dp[n - 1]);
    }
}
