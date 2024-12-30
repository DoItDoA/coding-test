package bfs_dfs.level3;
// 입국 심사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 입력 처리
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] times = new int[m];
        for (int i = 0; i < m; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for (int time : times) {
            if (time > max) max = time;
        }

        // 이분 탐색 범위 설정
        long left = 1; // 최소 시간
        long right = (long) max * n; // 최대 시간
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2; // 현재 시간
            long total = 0; // mid 시간 동안 심사할 수 있는 총 인원

            for (int time : times) {
                total += mid / time;
                if (total >= n) break; // 더 계산할 필요 없음
            }

            if (total >= n) { // 모든 사람을 심사할 수 있으면
                answer = mid; // 결과 갱신
                right = mid - 1; // 더 짧은 시간 탐색
            } else {
                left = mid + 1; // 더 긴 시간 탐색
            }
        }

        System.out.println(answer); // 최소 시간 출력
    }
}
