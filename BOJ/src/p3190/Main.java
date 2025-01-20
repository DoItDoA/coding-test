package p3190;
// 보류
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;

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
            int y = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            map[y][x] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, String> command = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String[] s = br.readLine().split(" ");
            command.put(Integer.parseInt(s[0]), s[1]);
        }

    }
}
