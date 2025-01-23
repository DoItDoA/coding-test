package p15685;
// 규칙 찾기 빡셈
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];

        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};

        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int d = Integer.parseInt(s[2]);
            int g = Integer.parseInt(s[3]);

            List<List<Integer>> dp = new ArrayList<>();
            for (int i = 0; i <= g; i++) dp.add(new ArrayList<>());
            dp.get(0).add(d);

            for (int i = 1; i <= g; i++) {
                for (int num : dp.get(i - 1)) dp.get(i).add(num);
                for (int num : reverseDP(dp.get(i - 1))) dp.get(i).add(num);
            }

            map[y][x] = 1;
            int i = 0;
            for (List<Integer> list : dp) {
                while (i < list.size()) {
                    Integer dir = list.get(i);
                    y += dy[dir];
                    x += dx[dir];
                    map[y][x] = 1;
                    i++;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static List<Integer> reverseDP(List<Integer> nums) {
        List<Integer> clone = new ArrayList<>();
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            clone.add((nums.get(i) + 1) % 4);
        }

        Collections.reverse(clone);
        return clone;
    }
}
