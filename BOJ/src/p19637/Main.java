package p19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] power = new int[n];
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int idx = binarySearch(power, num);
            System.out.println(str[idx]);
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
