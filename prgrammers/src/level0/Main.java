package level0;

/*
 * 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터
 * 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
 * * */
public class Main {
    public static void main(String[] args) {
        solution(5);
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

}
