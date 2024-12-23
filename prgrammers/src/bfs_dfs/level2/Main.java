package bfs_dfs.level2;
// 타겟 넘버
public class Main {
    public static void main(String[] args) {
        int solution = Solution.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println("solution = " + solution);
    }

    private static class Solution {
        private static int[] numberAll;
        private static int targetAll;
        private static int count;

        public static int solution(int[] numbers, int target) {
            numberAll = numbers;
            targetAll = target;
            
            dfs(0, 0);
            int answer = count;
            return answer;
        }

        static void dfs(int num, int i) {
            if (i == numberAll.length) {
                if (targetAll == num) count++;
                return;
            }
            int[] method = {1, -1};
            for (int m : method) {
                int a = num + m * numberAll[i];
                int b = i + 1;
                dfs(a, b);
            }
        }
    }
}
