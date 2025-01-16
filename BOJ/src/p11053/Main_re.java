package p11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] val = br.readLine().split(" ");
        int[] num = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(val[i]);
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) max = dp[i];
                }
            }
        }
        System.out.println(max);
    }
}
