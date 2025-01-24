package p16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m, k;
    private static int[][] feed, give;
    private static List<Tree> trees = new ArrayList<>();
    private static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    private static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};

    private static class Tree {
        int age, x, y;
        int isLive = 1;

        public Tree(int age, int x, int y) {
            this.age = age;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        feed = new int[n][n];
        give = new int[n][n];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                give[i][j] = Integer.parseInt(s[j]);
                feed[i][j] = 5;
            }
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]) - 1;
            int y = Integer.parseInt(s[1]) - 1;
            int age = Integer.parseInt(s[2]);
            trees.add(new Tree(age, x, y));
        }

        while (k-- > 0) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    Collections.sort(trees, ((o1, o2) -> Integer.compare(o1.age, o2.age)));
                    int size = trees.size();
                    for (int j = 0; j < size; j++) {
                        Tree tree = trees.get(j);
                        if (feed[tree.x][tree.y] < tree.age) {
                            tree.isLive = 0;
                        } else {
                            feed[tree.x][tree.y] -= tree.age++;
                        }
                    }
                    Collections.sort(trees, ((o1, o2) -> Integer.compare(o2.isLive, o1.isLive)));
                    for (int j = size - 1; j >= 0; j--) {
                        Tree tree = trees.get(j);
                        if (tree.isLive == 1) break;
                        feed[tree.x][tree.y] += (tree.age / 2);
                        trees.remove(j);
                    }
                } else if (i == 1) {
                    int size = trees.size();
                    for (int j = 0; j < size; j++) {
                        Tree tree = trees.get(j);
                        if (tree.age % 5 == 0) {
                            for (int k = 0; k < 8; k++) {
                                int nx = tree.x + dx[k];
                                int ny = tree.y + dy[k];

                                if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;

                                trees.add(new Tree(1, nx, ny));
                            }
                        }
                    }
                } else {
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            feed[x][y] += give[x][y];
                        }
                    }
                }
            }
        }
        System.out.println(trees.size());
    }
}