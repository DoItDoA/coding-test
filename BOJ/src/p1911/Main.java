package p1911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] hole = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hole[i][0] = Integer.parseInt(st.nextToken());
            hole[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hole, (o1, o2) -> o1[0] - o2[0]);

        int min = hole[0][0];
        int max = hole[0][0];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (hole[i][0] >= max) {
                min = hole[i][0];
                max = hole[i][0];
            }

            while (true) {
                if (max < hole[i][1]) {
                    max += l;
                    cnt++;
                } else break;
            }
        }
        System.out.println(cnt);
    }
}
