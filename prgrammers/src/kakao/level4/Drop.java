package kakao.level4;

import kakao.level3.DisappearWithDp;

import java.util.*;

public class Drop {
    private static class Solution {
        // 각 노드의 자식 노드를 저장할 배열.
        // tree[i]는 노드 i의 자식 노드 리스트를 의미합니다.
        private static List<Integer>[] tree;

        // 숫자(블록) 떨어뜨리기가 진행된 순서를 기록하는 리스트.
        // order 리스트의 각 요소는 해당 드롭 이벤트가 발생한 리프 노드의 인덱스를 저장합니다.
        private static List<Integer> order;

        // 각 리프 노드에서 숫자 드롭 이벤트가 몇 번 발생했는지 기록하는 배열.
        private static int[] count;

        public static int[] solution(int[][] edges, int[] target) {
            // 노드의 총 개수는 target 배열의 길이와 동일.
            int n = target.length;
            tree = new ArrayList[n];
            count = new int[n];
            order = new ArrayList<>();

            // 각 노드마다 자식 노드 리스트를 생성하여 초기화.
            for (int i = 0; i < n; i++) {
                tree[i] = new ArrayList<>();
            }

            // edges 배열을 이용해 트리 구조를 구성.
            // edge 배열의 값은 1부터 시작하므로, 인덱스 0부터 사용하기 위해 -1을 해줍니다.
            for (int[] edge : edges) {
                tree[edge[0] - 1].add(edge[1] - 1);
            }

            // 각 노드의 자식 리스트를 사전순으로 정렬합니다.
            // 이는 리프 노드 찾기 시 우선순위를 일정하게 유지하기 위함입니다.
            for (int i = 0; i < n; i++) {
                Collections.sort(tree[i]);
            }

            // status 변수:
            // 0 -> 계속 진행, 1 -> 모든 노드에서 목표 달성이 가능한 경우, -1 -> 불가능한 경우.
            int status = 0;
            // status가 0인 동안(아직 목표 달성 여부가 확정되지 않은 동안) 드롭 이벤트를 계속 진행.
            while (status == 0) {
                // 루트 노드(인덱스 0)부터 시작해 리프 노드를 찾음.
                int leafNode = findLeaf();
                // 해당 리프 노드에 숫자가 떨어졌으므로 카운트를 증가시킴.
                count[leafNode]++;
                // 드롭 이벤트가 발생한 리프 노드의 인덱스를 순서대로 기록.
                order.add(leafNode);
                // 현재 드롭 이벤트 상태를 바탕으로 목표 달성이 가능한지, 아니면 불가능한지 판단.
                status = checkPossibility(target);
            }

            // 만약 status가 -1이면, 주어진 목표를 만족시킬 수 없는 경우이므로 [-1] 배열을 반환.
            if (status == -1) {
                return new int[]{-1};
            }

            // 각 리프 노드에서 발생한 드롭 이벤트의 인덱스를 저장할 리스트 배열.
            // orderIndex[i]는 노드 i에 대해 드롭 이벤트가 발생한 순서(인덱스)를 저장합니다.
            List<Integer>[] orderIndex = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                orderIndex[i] = new ArrayList<>();
            }

            // order 리스트를 순회하며, 각 드롭 이벤트가 어떤 리프 노드에서 발생했는지 기록.
            for (int i = 0; i < order.size(); i++) {
                int leafNode = order.get(i);
                orderIndex[leafNode].add(i);
            }

            // 최종적으로 리턴할 드롭 이벤트 순서에 따른 숫자 배열.
            int[] answer = new int[order.size()];

            // 각 노드별로 목표(target)와 해당 노드에 떨어진 드롭 횟수(count)를 바탕으로
            // 각 드롭 이벤트에 할당할 숫자를 결정.
            for (int i = 0; i < n; i++) {
                // calculateBlocks 메서드에서 기본값 1부터 시작해 목표에 맞게 추가 숫자를 배분.
                int[] blocks = calculateBlocks(target[i], count[i]);
                // 저장해둔 이벤트 인덱스를 이용하여 answer 배열에 각 이벤트의 숫자를 할당.
                for (int j = 0; j < blocks.length; j++) {
                    answer[orderIndex[i].get(j)] = blocks[j];
                }
            }

            // 최종 드롭 이벤트 순서에 따른 숫자 배열 반환.
            return answer;
        }

        /**
         * findLeaf 메서드
         * 루트(인덱스 0)부터 시작하여 자식이 없는 리프 노드를 찾는 함수.
         *
         * @return 도달한 리프 노드의 인덱스.
         */
        private static int findLeaf() {
            int node = 0; // 루트 노드부터 시작.
            // 현재 노드가 자식 노드를 가지고 있다면 계속해서 첫 번째 자식으로 이동.
            while (!tree[node].isEmpty()) {
                // 첫 번째 자식을 임시로 꺼냄.
                int next = tree[node].remove(0);
                // 꺼낸 자식을 다시 추가하여 리스트 순서를 유지함.
                tree[node].add(next);
                // 다음 노드로 이동.
                node = next;
            }
            // 더 이상 자식이 없으므로 리프 노드 반환.
            return node;
        }

        /**
         * checkPossibility 메서드
         * 현재까지 각 리프 노드에 떨어진 숫자 횟수(count)와 목표값(target)을 비교하여
         * 목표 달성이 가능한지 여부를 판단합니다.
         * <p>
         * 조건:
         * - 만약 목표가 0인데 숫자가 떨어졌다면 불가능.
         * - 드롭 횟수가 목표보다 많으면 불가능.
         * - 남은 드롭 이벤트에 최대 3(1,2,3 중 최대값)을 할당해도 목표에 미치지 못하면 계속 진행.
         *
         * @param target 각 노드의 목표값 배열.
         * @return -1: 불가능, 0: 계속 진행, 1: 목표 달성이 가능한 상태.
         */
        private static int checkPossibility(int[] target) {
            for (int i = 0; i < count.length; i++) {
                int t = target[i];
                int c = count[i];
                // 목표가 0인데 이미 숫자가 떨어졌다면 불가능.
                if (t == 0 && c > 0) {
                    return -1;
                }
                // 드롭 횟수가 목표보다 많으면 불가능.
                if (t != 0 && t < c) {
                    return -1;
                }
                // 남은 드롭 이벤트에 최대로 3씩 할당해도 목표에 못 미치면 아직 진행해야 함.
                if (t > 0 && t > c * 3) {
                    return 0;
                }
            }
            // 모든 조건을 만족하면 목표 달성이 가능하다고 판단.
            return 1;
        }

        /**
         * calculateBlocks 메서드
         * 각 리프 노드에서 발생한 드롭 이벤트(count)와 목표값(target)을 바탕으로
         * 각 드롭 이벤트에 할당할 숫자를 계산하는 함수.
         * <p>
         * 기본적으로 각 드롭 이벤트에 1씩 할당한 후,
         * 목표에 도달하기 위해 남은 숫자(remain)를 적절하게 분배합니다.
         * 단, 각 드롭 이벤트에 할당 가능한 최대 숫자는 3입니다.
         *
         * @param target 목표값.
         * @param count  해당 노드에서 드롭 이벤트가 발생한 횟수.
         * @return 각 이벤트에 할당할 숫자가 저장된 배열.
         */
        private static int[] calculateBlocks(int target, int count) {
            // 각 드롭 이벤트에 기본적으로 1을 할당.
            int[] blocks = new int[count];
            Arrays.fill(blocks, 1);

            // 남은 할당 값: 목표값에서 이미 할당된 기본값(1 * count)을 뺀 값.
            int remain = target - count;
            // 사전순 결과를 위해 마지막 이벤트부터 숫자를 배분.
            // 남은 값이 0이 될 때까지 반복하며 배분.
            int idx = count - 1;

            for (int i = idx; i >= 0; i--) {
                if (remain >= 2) {
                    blocks[i] += 2;
                    remain -= 2;
                } else if (remain >= 1) {
                    blocks[i] += 1;
                    remain -= 1;
                }
            }

            return blocks;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}};
        int[] target = {0, 0, 0, 3, 0, 0, 5, 1, 2, 3};

        System.out.println(Arrays.toString(Solution.solution(edges, target)));
    }
}
