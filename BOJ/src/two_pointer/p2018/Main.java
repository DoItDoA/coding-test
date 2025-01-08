package two_pointer.p2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        int left = 0, right = 0, sum = 0, cnt = 1;
        while (true) {
            if (sum < n) {
                sum += nums[right++];
                if(right == n) break;
            } else if (sum > n) {
                sum -= nums[left++];
            } else {
                sum -= nums[left++];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
