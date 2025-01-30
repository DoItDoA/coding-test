package p13549;
// 주의
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);


        int[] d = {-1, 1};

        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        q.add(new int[]{N, 0});
        dp[N] = 0;

        int time = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if (poll[0] == K) {
                time = poll[1];
                break;
            }

            for (int k = 0; k < 2; k++) {
                int nd = poll[0] + d[k];
                int nTime = poll[1] + 1;

                if (nd < 0 || nd > 100000 || nTime > dp[nd]) continue;

                dp[nd] = nTime;

                q.add(new int[]{nd, nTime});
            }

            int nd = poll[0] * 2;
            if (nd > 100000 || poll[1] >= dp[nd]) continue;
            dp[nd] = poll[1];
            q.add(new int[]{nd, poll[1]});
        }
        System.out.println(time);
    }
}
