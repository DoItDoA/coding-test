package p3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    private static int n;
    private static int[][] map;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int y = Integer.parseInt(s[0]) - 1;
            int x = Integer.parseInt(s[1]) - 1;
            map[y][x] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, String> command = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String[] s = br.readLine().split(" ");
            command.put(Integer.parseInt(s[0]), s[1]);
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0, 0});
        map[0][0] = 2;
        int sec = 0;
        while (!snake.isEmpty()) {
            int[] head = snake.peekLast();
            int hy = head[0];
            int hx = head[1];
            int hd = head[2];

            if (command.containsKey(sec)) {
                String c = command.get(sec);
                if (c.equals("D")) {
                    hd = (hd + 1) % 4;
                } else {
                    hd = (hd + 3) % 4;
                }
            }

            int ny = hy + dy[hd];
            int nx = hx + dx[hd];
            sec++;

            if (ny >= n || ny < 0 || nx >= n || nx < 0 || map[ny][nx] == 2) break;

            snake.addLast(new int[]{ny, nx, hd});

            if (map[ny][nx] == 1) {
                map[ny][nx] = 2;
            } else {
                map[ny][nx] = 2;
                int[] tail = snake.removeFirst();
                map[tail[0]][tail[1]] = 0;
            }


        }
        System.out.println(sec);
    }
}
