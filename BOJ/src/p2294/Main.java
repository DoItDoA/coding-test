package p2294;
// 함정 조심
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] coin = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int c : coin) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k]);
    }
}