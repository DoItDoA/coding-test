package p3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(val[i]);
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int start = 0, end = n - 1, cnt = 0;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == x) {
                start++;
                end--;
                cnt++;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(cnt);
    }
}
