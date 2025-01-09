package p1012;

import java.io.*;
import java.util.*;

public class Main {
    private static List<int[][]> mapList = new ArrayList<>();
    private static List<boolean[][]> checkList = new ArrayList<>();
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);

            int[][] map = new int[n][m];
            for (int j = 0; j < k; j++) {
                String[] point = br.readLine().split(" ");
                int x = Integer.parseInt(point[0]);
                int y = Integer.parseInt(point[1]);
                map[y][x] = 1;
            }
            mapList.add(map);
            checkList.add(new boolean[n][m]);
        }

        List<Integer> cnts = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            int cnt = 0;
            int[][] map = mapList.get(i);
            boolean[][] check = checkList.get(i);
            int maxN = map.length;
            int maxM = map[maxN - 1].length;
            for (int y = 0; y < maxN; y++) {
                for (int x = 0; x < maxM; x++) {
                    if (map[y][x] == 1 && !check[y][x]) {
                        cnt++;
                        check[y][x] = true;
                        bfs(y, x, i);
                    }
                }
            }
            cnts.add(cnt);
        }

        for (int cnt : cnts) {
            System.out.println(cnt);
        }
    }

    static void bfs(int y, int x, int i) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        int[][] map = mapList.get(i);
        boolean[][] check = checkList.get(i);
        int maxN = map.length;
        int maxM = map[maxN - 1].length;

        while (!q.isEmpty()) {
            int[] currentYX = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = currentYX[0] + dy[k];
                int nx = currentYX[1] + dx[k];
                if (ny >= 0 && ny < maxN && nx >= 0 && nx < maxM) {
                    if (map[ny][nx] == 1 && !check[ny][nx]) {
                        check[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
