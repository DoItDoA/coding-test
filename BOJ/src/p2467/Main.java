package p2467;

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

        int left = 0, right = n - 1, min = Integer.MAX_VALUE;
        int sum = 0;

        int[] two = new int[2];

        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum > 0) {
                if (sum < min) {
                    two[0] = nums[left];
                    two[1] = nums[right];
                    min = sum;
                }
                right--;
            } else if (sum < 0) {
                sum *= -1;
                if (sum < min) {
                    two[0] = nums[left];
                    two[1] = nums[right];
                    min = sum;
                }
                left++;
            } else {
                two[0] = nums[left];
                two[1] = nums[right];
                break;
            }
        }
        Arrays.sort(two);

        System.out.println(two[0] + " " + two[1]);
    }
}
