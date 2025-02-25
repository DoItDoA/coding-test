package kakao.level3;
import java.util.*;

public class NPlusOne {
    private static int solution(int coin, int[] cards) {
        int n = cards.length;
        Set<Integer> initialCards = new HashSet<>();
        Queue<Integer> remainingCards = new LinkedList<>();
        Set<Integer> candidateCards = new HashSet<>();

        // 초기 카드 분배 (n/3개의 카드를 소유 카드로 설정)
        for (int i = 0; i < n / 3; i++) {
            initialCards.add(cards[i]);
        }
        for (int i = n / 3; i < n; i++) {
            remainingCards.offer(cards[i]);
        }

        int roundCount = 1;

        while (true) {
            // 후보 카드 추가 (라운드마다 2장씩 추가)
            if (!remainingCards.isEmpty()) candidateCards.add(remainingCards.poll());
            if (!remainingCards.isEmpty()) candidateCards.add(remainingCards.poll());

            // 1. 소유한 카드 중에서 합이 n+1이 되는 조합이 있는지 찾기
            if (findAndRemovePair(initialCards, initialCards, n + 1)) {
                roundCount++;
                continue;
            }

            // 2. 소유한 카드 + 후보 카드에서 조합 찾기 (코인 1개 소모)
            if (coin >= 1 && findAndRemovePair(initialCards, candidateCards, n + 1)) {
                coin--;
                roundCount++;
                continue;
            }

            // 3. 후보 카드 두 장으로 조합 찾기 (코인 2개 소모)
            if (coin >= 2 && findAndRemovePair(candidateCards, candidateCards, n + 1)) {
                coin -= 2;
                roundCount++;
                continue;
            }

            // 위의 모든 경우가 실패하면 종료
            break;
        }

        return roundCount;
    }

    private static boolean findAndRemovePair(Set<Integer> setA, Set<Integer> setB, int target) {
        for (int card : new HashSet<>(setA)) {
            if (setB.contains(target - card)) {
                setA.remove(card);
                setB.remove(target - card);
                return true;
            }
        }
        return false;
    }
}
