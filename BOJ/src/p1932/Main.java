package p1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> triangle = new ArrayList<>();
        List<int[]> dp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] val = br.readLine().split(" ");
            int[] line = new int[i];
            for (int j = 0; j < i; j++) {
                line[j] = Integer.parseInt(val[j]);
            }
            triangle.add(line);
            line = new int[i];
            dp.add(line);
        }

        dp.get(0)[0] = triangle.get(0)[0];

        int max = dp.get(0)[0];
        for (int i = 1; i < n; i++) {
            int[] line = dp.get(i);
            for (int j = 0; j < line.length; j++) {
                if (j == 0) {
                    dp.get(i)[j] = triangle.get(i)[j] + dp.get(i - 1)[0];
                } else if (j == line.length - 1) {
                    dp.get(i)[j] = triangle.get(i)[j] + dp.get(i - 1)[j - 1];
                } else {
                    dp.get(i)[j] = Math.max(triangle.get(i)[j] + dp.get(i - 1)[j - 1], triangle.get(i)[j] + dp.get(i - 1)[j]);
                }
                if (max < dp.get(i)[j]) max = dp.get(i)[j];
            }
        }
        System.out.println(max);
    }
}
