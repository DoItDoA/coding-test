package p17143;
// 풀수는 있지만 조금더 시간 복잡도 생각
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int r, c;
    private static int[] dy = {0, -1, 1, 0, 0};
    private static int[] dx = {0, 0, 0, 1, -1};
    private static int[][] map;
    private static Map<Integer, Shark> find = new HashMap<>();

    private static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);
        map = new int[r][c];

        for (int i = 1; i <= m; i++) {
            s = br.readLine().split(" ");
            int r1 = Integer.parseInt(s[0]) - 1;
            int c1 = Integer.parseInt(s[1]) - 1;
            map[r1][c1] = i;
            int s1 = Integer.parseInt(s[2]);
            int d = Integer.parseInt(s[3]);
            int z = Integer.parseInt(s[4]);
            find.put(i, new Shark(r1, c1, s1, d, z));
        }

        List<Shark> catchShark = new ArrayList<>();
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (map[i][j] != 0) {
                    int key = map[i][j];
                    catchShark.add(find.get(key));
                    find.remove(key);
                    map[i][j] = 0;
                    break;
                }
            }

            map = new int[r][c];
            for (Shark shark : find.values()) {
                int[] p = move(shark.r, shark.c, shark.s, shark.d);
                shark.r = p[0];
                shark.c = p[1];
                shark.d = p[2];
            }

            Set<Integer> keys = find.keySet();
            Queue<Integer> removeKeys = new LinkedList<>();
            for (int key : keys) {
                Shark shark = find.get(key);
                int r = shark.r;
                int c = shark.c;
                if (map[r][c] != 0) {
                    int prevKey = map[r][c];
                    Shark prev = find.get(prevKey);
                    if (prev.z < shark.z) {
                        map[r][c] = key;
                        removeKeys.add(prevKey);
                    } else {
                        removeKeys.add(key);
                    }
                } else {
                    map[r][c] = key;
                }
            }
            while (!removeKeys.isEmpty()) {
                find.remove(removeKeys.poll());
            }
        }
        int sum = 0;
        for (Shark shark : catchShark) {
            sum += shark.z;
        }
        System.out.println(sum);
    }

    private static int[] move(int y, int x, int s, int d) {
        if (d == 1 || d == 2)
            s %= (r - 1) * 2;
        else
            s %= (c - 1) * 2;

        for (int i = 0; i < s; i++) {
            if (y + dy[d] >= r || y + dy[d] < 0 || x + dx[d] >= c || x + dx[d] < 0) {
                if (d % 2 == 1) d += 1;
                else d -= 1;
            }

            y += dy[d];
            x += dx[d];
        }
        return new int[]{y, x, d};
    }
}