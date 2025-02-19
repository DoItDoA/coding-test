package kakao.level3;

public class Delivery {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long d = 0, p = 0;

        // 뒤쪽 집부터 순회하며 남은 배달량과 수거량 누적
        for (int i = n - 1; i >= 0; i--) {
            d += deliveries[i];
            p += pickups[i];

            // 현재 집(i번째 집까지 왕복해야 하는 상황이면 반복적으로 처리
            while (d > 0 || p > 0) {
                answer += (i + 1) * 2L; // (i+1): 집까지의 거리, 왕복이므로 *2
                d -= cap; // 배달 가능 용량만큼 차감
                p -= cap; // 수거 가능 용량만큼 차감
            }
        }
        return answer;
    }
}
