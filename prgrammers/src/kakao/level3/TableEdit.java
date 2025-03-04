package kakao.level3;

import java.util.*;

public class TableEdit {
    private static String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Integer> stack = new Stack<>();
        for (String command : cmd) {
            String[] c = command.split(" ");

            if (c[0].equals("D")) {
                int move = Integer.parseInt(c[1]);
                for (int i = 0; i < move; i++) {
                    k = next[k];
                }
            } else if (c[0].equals("U")) {
                int move = Integer.parseInt(c[1]);
                for (int i = 0; i < move; i++) {
                    k = prev[k];
                }
            } else if (c[0].equals("C")) {
                stack.push(k);

                // 현재 행 삭제 후, 이전/다음 노드 연결
                int pr = prev[k];
                int nx = next[k];
                if (prev[k] != -1) next[prev[k]] = next[k];
                if (next[k] != -1) prev[next[k]] = prev[k];

                // 커서 이동 (삭제된 행이 마지막이면 위로, 아니면 아래로)
                k = (next[k] == -1) ? prev[k] : next[k];
            } else {
                int restored = stack.pop();
                if (prev[restored] != -1) next[prev[restored]] = restored;
                if (next[restored] != -1) prev[next[restored]] = restored;
            }

        }

        StringBuilder result = new StringBuilder("O".repeat(n));
        while (!stack.isEmpty()) {
            result.setCharAt(stack.pop(), 'X');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        System.out.println(TableEdit.solution(8, 2, cmd));
    }
}
