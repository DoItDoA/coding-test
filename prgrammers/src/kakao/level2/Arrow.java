package kakao.level2;

import java.util.*;

public class Arrow {
    class Solution {
        private static int n, max = 0;
        private static int[] info;
        private static int[] point = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        private static int[] answer = {};

        public int[] solution(int n, int[] info) {
            this.n = n;
            this.info = info;
            recur(0, 0, new int[info.length]);

            return answer.length == 0 ? new int[]{-1} : answer;
        }

        private static void recur(int start, int depth, int[] lp) {
            if (depth > n) return;
            if (depth == n) {
                int lSum = 0;
                int aSum = 0;
                for (int i = 0; i <= 10; i++) {
                    if (info[i] != 0 || lp[i] != 0) {
                        if (info[i] >= lp[i]) aSum += point[i];
                        else lSum += point[i];
                    }
                }
                int total = lSum - aSum;
                if (total == 0) return;
                if (total > max) {
                    max = total;
                    answer = lp.clone();
                } else if (total == max) {
                    int[] clone = lp.clone();
                    for (int i = 10; i >= 0; i--) {
                        if (answer[i] == clone[i]) continue;
                        else if (answer[i] < clone[i]) {
                            answer = clone;
                            break;
                        } else {
                            break;
                        }
                    }

                }
                return;
            }


            for (int i = start; i <= 10; i++) {
                int plus = info[i] + 1;
                if (n - depth <= info[i]) {
                    plus = n - depth;
                }

                lp[i] = plus;
                recur(i + 1, depth + plus, lp);
                lp[i] = 0;
            }
        }
    }
}
