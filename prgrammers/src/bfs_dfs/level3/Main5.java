package bfs_dfs.level3;
// 어려움
import java.util.*;

// N으로 표현
public class Main5 {
    public static void main(String[] args) {
        int solution = Solution.solution(5, 12);
        System.out.println(solution);
    }

    static class Solution {
        public static int solution(int n, int number) {
            List<Set<Integer>> dp = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                dp.add(new HashSet<>());
            }
            if (n == number) return 1;

            String nn = String.valueOf(n);
            for (int i = 0; i < 8; i++) {
                int val = Integer.parseInt(nn);
                dp.get(i).add(val);
                nn += n;
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < i; j++) {
                    for (int a : dp.get(j)) {
                        int i1 = i - j - 1;
                        for (int b : dp.get(i - j - 1)) {
                            dp.get(i).add(a + b);
                            dp.get(i).add(a - b);
                            dp.get(i).add(a * b);
                            if (b != 0) dp.get(i).add(a / b);
                        }
                    }
                }
                if (dp.get(i).contains(number)) {
                    return i + 1;
                }
            }

            return -1;
        }
    }
}

