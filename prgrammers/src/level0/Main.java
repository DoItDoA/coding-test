package level0;

import java.util.ArrayList;
import java.util.List;

/*
 * 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터
 * 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
 * * */
public class Main {
    public static void main(String[] args) {
        solution(5);
        solution2(5);
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 0;
        int k = 0;
        while (true) {
            for (int i = 0 + k; i < n - k; i++) {
                answer[k][i] = ++num;
            }
            if (num == n * n) break;

            for (int i = 1 + k; i < n - k; i++) {
                answer[i][n - k - 1] = ++num;
            }
            if (num == n * n) break;

            for (int i = n - 2 - k; i >= 0 + k; i--) {
                answer[n - 1 - k][i] = ++num;
            }
            if (num == n * n) break;

            for (int i = n - 2 - k; i >= 1 + k; i--) {
                answer[i][k] = ++num;
            }
            if (num == n * n) break;
            k++;
        }

        return answer;
    }

    private static List<Integer> dy = new ArrayList<>(List.of(0, 1, 0, -1));
    private static List<Integer> dx = new ArrayList<>(List.of(1, 0, -1, 0));

    public static int[][] solution2(int n) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
        dfs(0, 0, answer);
        return answer;
    }

    private static void dfs(int y, int x, int[][] answer) {
        for (int k = 0; k < 2; k++) {
            int ay = y + dy.get(0);
            int ax = x + dx.get(0);
            if (ay >= 0 && ay < answer.length && ax >= 0 && ax < answer.length && answer[ay][ax] == 0) {
                answer[ay][ax] = answer[y][x] + 1;
                dfs(ay, ax, answer);
            } else {
                Integer dy0 = dy.remove(0);
                dy.add(dy0);
                Integer dx0 = dx.remove(0);
                dx.add(dx0);
            }
        }
    }
}
