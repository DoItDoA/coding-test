package kakao.level3;

import java.util.*;

public class Mountain {

    class Solution {
        private static List<int[]>[] graph;
        private static int n;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            this.n = n;
            graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

            for (int[] path : paths) {
                int a = path[0];
                int b = path[1];
                int c = path[2];

                graph[a].add(new int[]{b, c});
                graph[b].add(new int[]{a, c});
            }

            boolean[] chk = new boolean[n + 1];
            for (int g : gates) chk[g] = true;

            Set<Integer> setSummit = new HashSet<>();
            for (int s : summits) setSummit.add(s);

            return bfs(gates, setSummit, chk);
        }

        private static int[] bfs(int[] gates, Set<Integer> set, boolean[] chk) {
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            int INF = Integer.MAX_VALUE;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, INF);

            for (int gate : gates) {
                q.add(new int[]{gate, 0});
                dp[gate] = 0;
            }

            int min = Integer.MAX_VALUE;
            int summ = 0;
            while (!q.isEmpty()) {
                int[] p = q.poll();

                if (dp[p[0]] < p[1]) continue;

                if (set.contains(p[0])) {
                    if (min > p[1]) {
                        min = p[1];
                        summ = p[0];
                    } else if (min == p[1] && summ > p[0]) {
                        summ = p[0];
                    }
                    continue;
                }


                for (int[] e : graph[p[0]]) {

                    if (chk[e[0]]) continue;

                    int maxIntensity = Math.max(p[1], e[1]);
                    if (dp[e[0]] > maxIntensity) {
                        dp[e[0]] = maxIntensity;
                        q.add(new int[]{e[0], maxIntensity});
                    }
                }
            }

            return new int[]{summ, min};
        }
    }
}
