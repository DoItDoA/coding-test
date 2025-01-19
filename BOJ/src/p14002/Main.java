package p14002;
// 보류
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] dp = new int[n];
        int[] parent = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
            dp[i] = 1;
        }

        int max = 1;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
    }
}
