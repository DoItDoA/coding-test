package kakao.level2;

public class MatrixRotate {
    class Solution {
        private static int[][] map;
        private static int[] dx = {0,1,0,-1};
        private static int[] dy = {1,0,-1,0};
        private static int min;
        public int[] solution(int rows, int columns, int[][] queries) {
            map = new int[rows+1][columns+1];
            int cnt = 1;
            for(int i=1; i<=rows; i++){
                for(int j=1; j<=columns; j++){
                    map[i][j] = cnt++;
                }
            }


            int n = queries.length;

            int[] answer = new int[n];
            for(int i=0; i<n; i++){
                int[] q = queries[i];
                min = rows * columns;
                dfs(q[0], q[1], q, 0, map[q[0]][q[1]]);
                answer[i] = min;
            }



            return answer;
        }

        private static void dfs(int x, int y, int[] query, int d, int num){
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx < x1 || nx > x2 || ny < y1 || ny > y2){
                d++;
                if(d == 4) return;

                nx = x+dx[d];
                ny = y+dy[d];
            }


            if(num < min) min = num;
            int next = map[nx][ny];
            map[nx][ny] = num;
            dfs(nx, ny, query, d, next);
        }
    }
}
