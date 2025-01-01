package two_pointer.p2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int start = 0, end = 0, sum = 0, cnt = 0;

        while (end <= n) {
            if (sum < m) {
                if (end < n) sum += nums[end];
                end++;
            } else if (sum > m) {
                sum -= nums[start];
                start++;
            } else {
                cnt++;
                if (end < n) sum += nums[end];
                end++;
            }
        }
        System.out.println(cnt);
    }
}
