package p20055;
// 보류
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] line;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        line = new int[2 * n];
        robot = new boolean[n];

        s = br.readLine().split(" ");
        for (int i = 0; i < 2 * n; i++) {
            line[i] = Integer.parseInt(s[i]);
        }

        int step = 0;
        while (true) {
            if (line[0] != 0) {
                line[0] -= 1;
                robot[0] = true;
            }


            int temp = line[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                line[i] = line[i - 1];
            }
            line[0] = temp;


            for (int i = n - 1; i > 0; i--) {
                if (!robot[i + 1] && line[i + 1] != 0) {
                    robot[i + 1] = true;
                    line[i + 1] -= 1;
                    robot[i] = false;
                }
            }
            robot[n - 1] = false;


            for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[n - 1] = false;


            int cnt = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (line[i] == 0) cnt++;
            }

            step++;
            if (k == cnt) break;
        }
        System.out.println(step);
    }
}
