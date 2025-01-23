package p15684;
// 잘 생각하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n, m, h;
    private static int[][] map;
    private static int min = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);

        map = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int horizontal = Integer.parseInt(s[0]);
            int vertical = Integer.parseInt(s[1]);

            map[horizontal][vertical] = vertical;
            map[horizontal][vertical + 1] = vertical;
        }
        int[] lr = {-1, 1};
        addLine(1, 1, 0);
        System.out.println(min == 4 ? -1 : min);
    }

    private static void addLine(int y, int x, int depth) {
        if (isPass()) {
            min = Math.min(depth, min);
            return;
        }

        if (depth >= 3) {
            return;
        }
        for (int i = y; i <= h; i++) {
            for (int j = x; j < n; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = j;
                    map[i][j + 1] = j;
                    addLine(i, j, depth + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
            x = 1;
        }
    }

    private static boolean isPass() {
        for (int i = 1; i <= n; i++) {
            int pos = i;
            for (int j = 1; j <= h; j++) {
                if (map[j][pos] != 0) {
                    if (map[j][pos] == pos) {
                        pos++;
                    } else if (map[j][pos] == pos - 1) {
                        pos--;
                    }
                }
            }
            if (i != pos) return false;
        }
        return true;
    }
}
