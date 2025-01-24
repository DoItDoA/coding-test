package p16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    private static int n, m, k;
    private static int[][] feed, give;
    private static List<Integer>[][] trees;
    private static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    private static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        feed = new int[n][n];
        give = new int[n][n];
        trees = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                give[i][j] = Integer.parseInt(s[j]);
                feed[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]) - 1;
            int y = Integer.parseInt(s[1]) - 1;
            int age = Integer.parseInt(s[2]);
            trees[x][y].add(age);
        }

        while (k-- > 0) {
            for (int season = 0; season < 3; season++) {
                if (season == 0) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (trees[i][j].isEmpty()) continue;
                            List<Integer> ages = trees[i][j];
                            Collections.sort(ages);
                            List<Integer> alive = new ArrayList<>();
                            int size = ages.size();
                            int dead = 0;
                            for (int t = 0; t < size; t++) {
                                Integer a = ages.get(t);
                                if (feed[i][j] < a) {
                                    dead += a / 2;
                                } else {
                                    feed[i][j] -= a;
                                    alive.add(a + 1);
                                }
                            }
                            trees[i][j] = alive;
                            feed[i][j] += dead;
                        }
                    }
                } else if (season == 1) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (trees[i][j].isEmpty()) continue;

                            for (int age : trees[i][j]) {
                                if (age % 5 == 0) {
                                    for (int k = 0; k < 8; k++) {
                                        int nx = j + dx[k];
                                        int ny = i + dy[k];

                                        if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;

                                        trees[ny][nx].add(1);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    for (int y = 0; y < n; y++) {
                        for (int x = 0; x < n; x++) {
                            feed[y][x] += give[y][x];
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += trees[i][j].size();
            }
        }
        System.out.println(cnt);
    }
}
