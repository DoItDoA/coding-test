package two_pointer.p1253;

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

        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            long target = nums[i];
            while (left < right) {
                if (i == left) {
                    left++;
                    continue;
                }
                if (i == right) {
                    right--;
                    continue;
                }

                long sum = nums[left] + nums[right];

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
