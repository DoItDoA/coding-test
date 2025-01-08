package two_pointer.p1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(val[i]);
        }

        Arrays.sort(nums);
        int left = 0, right = n - 1, sum = 0, cnt = 0;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum > m) {
                right--;
            } else if (sum < m) {
                left++;
            } else {
                right--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
