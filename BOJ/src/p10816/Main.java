package p10816;
// 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            int count = upperBound(nums, target) - lowerBound(nums, target);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
}
