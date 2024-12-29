package binary_search.p1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기 N 입력
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        // 배열 정렬
        Arrays.sort(nums);

        // 타겟 수 개수 M 입력
        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            if (binarySearch(nums, target)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
