package p2512;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int[] budgets = new int[n];
        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(val[i]);
            if (budgets[i] > max) max = budgets[i];
        }
        int m = Integer.parseInt(br.readLine());

        long left = 0;
        long right = max;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            for (int budget : budgets) {
                if (budget > mid) total += mid;
                else total += budget;
            }

            if (total <= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
