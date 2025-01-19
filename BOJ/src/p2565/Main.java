package p2565;
// 원리를 좀 더 파악

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> all = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(s[0]));
            list.add(Integer.parseInt(s[1]));
            all.add(list);
        }

        Collections.sort(all, ((o1, o2) -> Integer.compare(o1.get(0), o2.get(0))));

        int[] bList = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < all.size(); i++) {
            bList[i] = all.get(i).get(1);
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (bList[i] > bList[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) max = dp[i];
                }
            }
        }
        System.out.println(n - max);
    }
}
