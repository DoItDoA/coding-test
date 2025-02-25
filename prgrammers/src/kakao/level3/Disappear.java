package kakao.level3;

public class Disappear {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int n, m;

    private static int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], true);
    }

    private static int dfs(int[][] board, int ax, int ay, int bx, int by, boolean turnA) {
        // 현재 턴 플레이어의 위치 설정 (0: A, 1: B)
        int x = (turnA) ? ax : bx;
        int y = (turnA) ? ay : by;

        // 현재 위치의 발판이 사라졌다면, 이동할 수 없으므로 0을 반환 (패배)
        if (board[x][y] == 0) return 0; // 현재 게임 상태에서 시작하여 게임이 종료될 때까지 진행된 총 이동 횟수를 계산하기 위함

        int maxMoves = 0;
        int minMoves = Integer.MAX_VALUE;
        boolean canMove = false;

        // 4방향에 대해 이동 가능성 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 보드 범위 체크 및 이동할 수 있는지 확인
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 0) continue;

            canMove = true;
            // 현재 위치의 발판을 제거 (이동 후 사라짐)
            board[x][y] = 0;
            board[nx][ny] = 2;
            int moves;
            if (turnA) moves = dfs(board, nx, ny, bx, by, false) + 1;
            else moves = dfs(board, ax, ay, nx, ny, true) + 1;

            // 백트래킹: 탐색 후 발판 복구
            board[x][y] = 1;
            board[nx][ny] = -1;
            // moves가 홀수이면 현재 플레이어 승리 경로 → 승리 시 최소 이동 횟수를 선택
            if (moves % 2 == 1) {
                minMoves = Math.min(minMoves, moves);
            }
            // moves가 짝수이면 현재 플레이어 패배 경로 → 패배 시 최대 이동 횟수를 선택 (패배를 늦추기 위해)
            else {
                maxMoves = Math.max(maxMoves, moves);
            }
        }
        if (minMoves == 6 || maxMoves == 6) {
            System.out.println();
        }
        // 한 방향도 이동할 수 없으면 0 반환 (패배)
        if (!canMove) return 0;

        // 승리 가능한 경로가 있다면 그 중 최소 이동 횟수를, 없으면 패배 경로 중 최대 이동 횟수를 반환
        return (minMoves != Integer.MAX_VALUE) ? minMoves : maxMoves;
    }

    public static void main(String[] args) {
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
