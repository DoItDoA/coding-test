package kakao.level3;

import java.util.*;

public class SheepWolf {

    class Solution {
        private static List<Integer>[] graph;
        private static int n;
        private static int max = 0;
        private static int[] info;

        public int solution(int[] info, int[][] edges) {
            n = info.length;
            this.info = info;
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

            for (int[] e : edges) {
                graph[e[0]].add(e[1]);
            }

            dfs(List.of(0), 0, 0);

            return max;
        }

        private static void dfs(List<Integer> animal, int sheep, int wolf) {
            if (sheep > max) max = sheep;

            for (int i = 0; i < animal.size(); i++) {
                int a = animal.get(i);
                int type = info[a];
                int nSheep = sheep;
                int nWolf = wolf;

                if (type == 1) nWolf++;
                else nSheep++;


                if (nWolf >= nSheep) continue;

                List<Integer> list = new ArrayList<>(animal);
                list.remove(i);

                for (int next : graph[a]) {
                    list.add(next);
                }
                dfs(list, nSheep, nWolf);
            }
        }
    }
}
