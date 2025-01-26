package p2630;
// 어려움
// 분할 정복 기초
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int blue = 0, white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void recur(int x, int y, int size) {
        if (isSame(x, y, size)) {
            if (map[x][y] == 1) blue++;
            else white++;
        } else {
            int half = size / 2;
            recur(x, y, half);
            recur(x + half, y, half);
            recur(x, y + half, half);
            recur(x + half, y + half, half);
        }
    }

    private static boolean isSame(int x, int y, int size) {
        int firstColor = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != firstColor) return false;
            }
        }
        return true;
    }
}
