package p15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = {1, 2, 3};
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j >= arr[i]) dp[j] += dp[j - arr[i]];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
