package p1654;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        long maxLine = 0;
        long[] lines = new long[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if (lines[i] > maxLine) maxLine = lines[i];
        }

        System.out.println(binarySearch(n, lines, maxLine));
    }

    private static long binarySearch(int n, long[] lines, long maxLine) {
        long left = 1;
        long right = maxLine;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;
            for (long line : lines) {
                if (line >= mid) {
                    cnt += line / mid;
                }
            }
            if (n <= cnt) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
