package p1005;
// 보류
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            int[] buildTime = new int[n + 1]; // 각 건물의 건설 시간
            int[] indegree = new int[n + 1]; // 각 건물의 진입 차수
            int[] dp = new int[n + 1]; // 최소 건설 시간
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 건설 시간 입력
            s = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                buildTime[i] = Integer.parseInt(s[i - 1]);
            }

            // 규칙 입력
            for (int i = 1; i <= k; i++) {
                s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                graph.get(x).add(y);
                indegree[y]++;
            }

            // 목표 건물
            int w = Integer.parseInt(br.readLine());

            // 위상 정렬
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = buildTime[i]; // 초기 시간 설정
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : graph.get(current)) {
                    indegree[next]--;
                    dp[next] = Math.max(dp[next], dp[current] + buildTime[next]);
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            // 결과 출력
            sb.append(dp[w]).append("\n");
        }
        System.out.println(sb);
    }
}
