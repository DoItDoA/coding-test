package backtracking.p14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static Integer min = null;
    private static Integer max = null;
    private static int[] numbers;
    private static int[] method = {0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input);
        numbers = new int[n];
        String[] num = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(num[i]);
        }
        String[] m = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            method[i] = Integer.parseInt(m[i]);
        }

        recur(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void recur(int idx, int num) {
        if (idx == n) {
            if (min == null || min > num) min = num;
            if (max == null || max < num) max = num;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (method[i] == 0) continue;
            method[i] -= 1;
            switch (i) {
                case 0:
                    recur(idx + 1, num + numbers[idx]);
                    break;
                case 1:
                    recur(idx + 1, num - numbers[idx]);
                    break;
                case 2:
                    recur(idx + 1, num * numbers[idx]);
                    break;
                case 3:
                    recur(idx + 1, num / numbers[idx]);
                    break;
            }
            method[i] += 1;
        }
    }
}
