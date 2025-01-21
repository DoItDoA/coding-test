package p14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] gears = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[][] methed = new int[k][2];
        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            methed[i][0] = Integer.parseInt(s[0]);
            methed[i][1] = Integer.parseInt(s[1]);
        }

        int[] d = {-1, 1};
        for (int[] m : methed) {
            boolean[] chk = new boolean[4];
            int seq = m[0] - 1;
            chk[seq] = true;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{seq, m[1]});
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int cs = poll[0];
                int cd = poll[1];
                int[] gear = gears[cs];
                int cl = gear[6];
                int cr = gear[2];

                for (int i = 0; i < 2; i++) {
                    int ns = cs + d[i];
                    if (ns >= 4 || ns < 0) continue;
                    if (!chk[ns]) {
                        chk[ns] = true;
                        int[] nGear = gears[ns];
                        int nl = nGear[6];
                        int nr = nGear[2];
                        int nd = 0;
                        if (ns > cs && nl != cr) nd = cd * -1;
                        else if (ns < cs && nr != cl) nd = cd * -1;
                        q.add(new int[]{ns, nd});
                    }
                }
                turn(gear, cd);
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += gears[i][0] * Math.pow(2, i);
        }
        System.out.println(sum);
    }

    private static void turn(int[] gear, int dr) {
        if (dr == 1) {
            int temp = gear[7];
            for (int i = 7; i > 0; i--) {
                gear[i] = gear[i - 1];
            }
            gear[0] = temp;
        } else if (dr == -1) {
            int temp = gear[0];
            for (int i = 0; i < 7; i++) {
                gear[i] = gear[i + 1];
            }
            gear[7] = temp;
        }
    }
}
