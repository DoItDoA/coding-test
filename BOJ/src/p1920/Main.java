package p1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(val[i]);

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        String[] val2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++)
            targets[i] = Integer.parseInt(val2[i]);

        Arrays.sort(nums);

        for (int target : targets) {
            search(nums, 0, n - 1, target);
        }
    }

    private static void search(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target)
                System.out.println(1);
            else
                System.out.println(0);
            return;
        }

        int mid = (start + end) / 2;
        if (nums[mid] < target)
            search(nums, mid + 1, end, target);
        else
            search(nums, start, mid, target);
    }
}