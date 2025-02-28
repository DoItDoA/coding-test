package kakao.level3;

import java.util.*;

public class Study {
    private static void main(String[] args) {
//        int alp = 10;
//        int cop = 10;
//        int[][] problems = {
//                {10, 15, 2, 1, 2},
//                {20, 20, 3, 3, 4},
//                {15, 10, 1, 2, 2}
//        };
//
//        int result = solution(alp, cop, problems);
//        System.out.println("최소 학습 시간: " + result);
        int alp2 = 0;
        int cop2 = 0;
        int[][] problems2 = {
                {0, 0, 2, 1, 2},
                {4, 5, 3, 1, 2},
                {4, 11, 4, 0, 2},
                {10, 4, 0, 4, 2}
        };

        int result2 = solution(alp2, cop2, problems2);
        System.out.println("최소 학습 시간: " + result2);
    }

    public static int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;

        // 1️⃣ 문제들을 순회하면서 필요한 최대 알고력과 최대 코딩력 찾기
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        // 현재 능력이 목표보다 크다면, 목표값으로 조정
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        // 2️⃣ DP 테이블 초기화 (INF 값으로 설정)
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for(int i=alp; i<=maxAlp; i++){
            int a = i-alp;
            for(int j=cop; j<=maxCop; j++){
                int b= j-cop;
                dp[i][j] = a+b;
            }
        }
        dp[alp][cop] = 0;

        // 3️⃣ DP 갱신 (작은 상태부터 큰 상태로 확장)
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                // 3) "문제 풀이" 선택
                for (int[] problem : problems) {
                    int reqAlp = problem[0], reqCop = problem[1];
                    int rewardAlp = problem[2], rewardCop = problem[3];
                    int cost = problem[4];

                    // 현재 알고력 & 코딩력으로 문제를 풀 수 있는 경우
                    if (i >= reqAlp && j >= reqCop) {
                        int newAlp = Math.min(maxAlp, i + rewardAlp);
                        int newCop = Math.min(maxCop, j + rewardCop);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + cost);
                    }
                }
            }
        }

        // 4️⃣ 목표 알고력과 코딩력에 도달하는 최소 시간 반환
        return dp[maxAlp][maxCop];
    }
}
