package two_pointer.p2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] val = br.readLine().split(" ");
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(val[i]);
        }

        Arrays.sort(nums);

        long min = Long.MAX_VALUE;
        long x = 0, y = 0, z = 0;

        for (int left = 0; left < n - 2; left++) {
            int right = n - 1;
            int mid = left + 1;
            while (mid < right) {
                long sum = nums[left] + nums[mid] + nums[right];
                if (Math.abs(sum) < min) {
                    x = nums[left];
                    y = nums[mid];
                    z = nums[right];
                    min = Math.abs(sum);
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    mid++;
                } else {
                    System.out.println(x + " " + y + " " + z);
                    return;
                }
            }
        }

        System.out.println(x + " " + y + " " + z);
    }
}
