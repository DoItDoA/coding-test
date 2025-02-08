package kakao.level2;

import java.util.*;

public class Dice {
    class Solution {
        private static int len;
        private static int[][] dices;
        private static boolean[] chk;
        private static int[] answer;
        private static int max = 0;

        public int[] solution(int[][] dice) {
            len = dice.length;
            dices = dice;
            chk = new boolean[len];
            answer = new int[len / 2];

            recur(0, 0);
            return answer;
        }

        private static void recur(int start, int depth) {
            if (depth == len / 2) {
                int rs = fight();
                if (rs > max) {
                    max = rs;
                    int idx = 0;
                    for (int i = 0; i < len; i++) {
                        if (chk[i]) {
                            answer[idx++] = i + 1;
                        }
                    }
                }

                return;
            }

            for (int i = start; i < len; i++) {
                chk[i] = true;
                recur(i + 1, depth + 1);
                chk[i] = false;
            }
        }

        private static int fight() {
            List<int[]> dice1 = new ArrayList<>();
            List<int[]> dice2 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (chk[i]) dice1.add(dices[i]);
                else dice2.add(dices[i]);
            }
            List<Integer> sumList1 = new ArrayList<>();
            recur2(dice1, 0, 0, sumList1);

            List<Integer> sumList2 = new ArrayList<>();
            recur2(dice2, 0, 0, sumList2);
            Collections.sort(sumList2);

            int total = 0;
            for (int sum : sumList1) {
                total += binarySearch(sum, sumList2);
            }

            return total;
        }

        private static int binarySearch(int target, List<Integer> list) {
            int left = 0;
            int right = list.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }


        private static void recur2(List<int[]> dice, int sum, int depth, List<Integer> sumList) {
            if (depth == len / 2) {
                sumList.add(sum);
                return;
            }

            for (int j = 0; j < 6; j++) {
                sum += dice.get(depth)[j];
                recur2(dice, sum, depth + 1, sumList);
                sum -= dice.get(depth)[j];
            }
        }
    }
}
