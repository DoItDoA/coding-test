package p17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static class Dust {
        int y, x, q, degree;

        public Dust(int y, int x, int q, int degree) {
            this.y = y;
            this.x = x;
            this.q = q;
            this.degree = degree;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        int t = Integer.parseInt(s[2]);

        int[][] map = new int[r][c];
        List<Integer> airClean = new ArrayList<>();
        Queue<Dust> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] != 0) {
                    if (map[i][j] == -1) airClean.add(i);
                    else {
                        queue.add(new Dust(i, j, map[i][j], 0));
                        map[i][j] = 0;
                    }
                }
            }
        }

        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};
        for (int time = 0; time < t; time++) {
            while (!queue.isEmpty() && queue.peek().degree == time) {
                Dust dust = queue.poll();
                int subQ = dust.q / 5;
                int q = dust.q;
                for (int k = 0; k < 4; k++) {
                    int ny = dust.y + dy[k];
                    int nx = dust.x + dx[k];

                    if (ny >= r || ny < 0 || nx >= c || nx < 0 || map[ny][nx] == -1) continue;
                    q -= subQ;
                    map[ny][nx] += subQ;
                }
                map[dust.y][dust.x] += q;
            }

            for (int i = 0; i < 2; i++) {
                int y = airClean.get(i);
                int x = 0;
                int prev = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int k;
                    if (i == 0) k = dir;
                    else k = (3 - dir + 1) % 4;

                    while (y + dy[k] < r && y + dy[k] >= 0 && x + dx[k] < c && x + dx[k] >= 0 && map[y + dy[k]][x + dx[k]] != -1) {
                        int temp = map[y += dy[k]][x += dx[k]];
                        map[y][x] = prev;
                        prev = temp;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] != -1 && map[i][j] != 0) {
                        queue.add(new Dust(i, j, map[i][j], time + 1));
                        map[i][j] = 0;
                    }
                }
            }
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll().q;
        }
        System.out.println(sum);
    }
}
