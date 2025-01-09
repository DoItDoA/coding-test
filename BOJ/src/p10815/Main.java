package p10815;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            if (binarySearch(nums, target)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return false;
    }

}
