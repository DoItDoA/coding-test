package bfs_dfs.level2;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println("solution = " + solution);
    }
}

class Solution {
    private static int[] numbers;
    private static int target;
    private static int count;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);
        int answer = count;
        return answer;
    }

    static void dfs(int num, int i) {
        if (i == numbers.length) {
            if (target == num) count++;
            return;
        }
        int[] method = {1, -1};
        for (int m : method) {
            int a = num + m * numbers[i];
            int b = i + 1;
            dfs(a, b);
        }
    }
}