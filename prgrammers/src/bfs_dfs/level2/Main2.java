package bfs_dfs.level2;

import java.util.*;

// 게임 최단 경로
public class Main2 {
    public static void main(String[] args) {
        int solution = Solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println("solution = " + solution);
    }

    private static class Solution {
        private static int[][] map;
        private static boolean[][] chk;
        private static int n, m;
        private static int[] dy = {0, 1, 0, -1};
        private static int[] dx = {1, 0, -1, 0};

        static class Go {
            int x, y;
            int level;

            public Go(int y, int x, int l) {
                this.x = x;
                this.y = y;
                level = l;
            }
        }

        public static int solution(int[][] maps) {
            map = maps;
            n = maps.length;
            m = maps[0].length;
            chk = new boolean[n][m];

            chk[0][0] = true;
            int answer = bfs(new Go(0, 0, 1));
            return answer;
        }

        private static int bfs(Go go) {
            Queue<Go> q = new LinkedList<>();
            q.add(go);
            while (!q.isEmpty()) {
                Go poll = q.poll();
                if (poll.x == m - 1 && poll.y == n - 1)
                    return poll.level;

                for (int k = 0; k < 4; k++) {
                    int nx = poll.x + dx[k];
                    int ny = poll.y + dy[k];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                        if (!chk[ny][nx] && map[ny][nx] == 1) {
                            chk[ny][nx] = true;
                            q.add(new Go(ny, nx, poll.level + 1));
                        }
                    }
                }
            }
            return -1;
        }
    }
}
