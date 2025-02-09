package p2110;
// 어려움
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(position);

        binarySearch(position, c, n);
    }

    private static void binarySearch(int[] position, int c, int n) {
        int left = 1; // 최소거리
        int right = position[n - 1] - position[0]; // 최대 거리
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isInstall(position, mid, c)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isInstall(int[] positon, int mid, int c) {
        int first = positon[0]; // 첫번째 집에 무조건 설치
        int cnt = 1;
        for (int i = 1; i < positon.length; i++) {
            int distance = positon[i] - first;
            if (distance >= mid) {
                cnt++;
                first = positon[i];
            }
        }
        return cnt >= c;
    }
}

