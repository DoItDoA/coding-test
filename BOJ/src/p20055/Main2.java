package p20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2 * n];
        for (int i = 0; i < n * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] robots = new boolean[n];

        int step = 0;
        while (true) {
            step++;

            int tempBelt = belt[n * 2 - 1];
            for (int i = n * 2 - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tempBelt;
            boolean tempRobot = robots[n - 1];
            for (int i = n - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false;
            robots[n - 1] = false;

            for (int i = n - 2; i > 0; i--) {
                if (robots[i] && !robots[i + 1] && belt[i + 1] > 0) {
                    robots[i] = false;
                    robots[i + 1] = true;
                    belt[i + 1]--;
                    if (belt[i + 1] == 0) k--;
                }
            }
            robots[n - 1] = false;

            if (belt[0] > 0) {
                robots[0] = true;
                belt[0]--;
                if (belt[0] == 0) k--;
            }

            if (k <= 0) break;
        }
        System.out.println(step);
    }
}
