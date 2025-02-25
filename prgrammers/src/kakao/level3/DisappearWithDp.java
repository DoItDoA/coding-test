package kakao.level3;

public class DisappearWithDp {
    private static final int[] dx = {0, 1, 0, -1}; // 상하좌우
    private static final int[] dy = {1, 0, -1, 0};
    private static int[][][] dp; // 현재 플레이어가 위치한 좌표 (x, y) 상태에서 게임이 종료될 때까지 남은 이동 횟수를 저장
    private static int n, m;

    private static int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        dp = new int[2][n][m]; // [x][y][플레이어: 0=A, 1=B]
        int dfs = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0);
        return dfs;
    }

    private static int dfs(int[][] board, int ax, int ay, int bx, int by, int turn) {
        // 현재 플레이어의 위치
        int x = (turn == 0) ? ax : bx;
        int y = (turn == 0) ? ay : by;

        // 이미 밟고 있는 발판이 사라진 경우, 현재 플레이어가 패배
        if (board[x][y] == 0) return 0;

        // 이미 계산한 결과가 있으면 재사용 (메모이제이션)
        if (dp[turn][x][y] != 0) return dp[turn][x][y];

        int maxMoves = 0;
        int minMoves = Integer.MAX_VALUE;

        boolean canMove = false;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 0) continue;
            canMove = true;
            board[x][y] = 0; // 현재 위치 발판 제거
            int moves = turn == 0 ?
                    dfs(board, nx, ny, bx, by, 1) + 1 :
                    dfs(board, ax, ay, nx, ny, 0) + 1;
            board[x][y] = 1; // 백트래킹: 다시 발판 복구

            // 상대가 패배하는 경우 → 현재 플레이어는 최단 이동으로 승리 가능
            if (moves % 2 == 1) minMoves = Math.min(minMoves, moves);
            else maxMoves = Math.max(maxMoves, moves);
        }


        // 이동할 수 없는 경우 (현재 플레이어가 패배)
        if (!canMove) return 0;

        // 최적 전략 선택 (승리 가능하면 최소 이동 수, 아니면 최대 이동 수)
        int result = (minMoves != Integer.MAX_VALUE) ? minMoves : maxMoves;
        dp[turn][x][y] = result; // 결과 저장 (메모이제이션)
        return result;
    }

    public static void main(String[] args) {
        DisappearWithDp disappear = new DisappearWithDp();
        int[][] board = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};

        System.out.println("최소 이동 횟수: " + solution(board, aloc, bloc));
    }
}
