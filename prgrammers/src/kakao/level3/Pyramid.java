package kakao.level3;

import java.util.*;

public class Pyramid {
    class Solution {
        private static class Node {
            String name;
            int ammount = 0;

            public Node(String name) {
                this.name = name;
            }
        }

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int n = enroll.length;
            int m = seller.length;
            Map<String, Integer> idx = new HashMap<>();
            idx.put("-", 0);
            for (int i = 0; i < n; i++) idx.put(enroll[i], i + 1);

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int child = idx.get(enroll[i]);
                int parent = idx.get(referral[i]);
                map.put(child, parent);
            }

            int[] total = new int[n];

            for (int i = 0; i < m; i++) {
                int index = idx.get(seller[i]);
                int sum = amount[i] * 100;
                while (true) {
                    int diff = sum / 10;
                    total[index - 1] += sum - diff;
                    if (diff == 0) break;
                    index = map.get(index);
                    sum = diff;
                    if (index == 0) break;
                }
            }

            return total;
        }
    }
}
