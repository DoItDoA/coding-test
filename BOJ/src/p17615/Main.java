package p17615;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        int redCount = 0;
        int blueCount = 0;

        // 전체 빨간 공과 파란 공의 개수 세기
        for (char c : balls.toCharArray()) {
            if (c == 'R') redCount++;
            else blueCount++;
        }

        // 왼쪽에서부터 연속된 같은 색 공의 개수 세기
        int leftRed = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'R') leftRed++;
            else break;
        }

        int leftBlue = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'B') leftBlue++;
            else break;
        }

        // 오른쪽에서부터 연속된 같은 색 공의 개수 세기
        int rightRed = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') rightRed++;
            else break;
        }

        int rightBlue = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') rightBlue++;
            else break;
        }

        // 각 경우의 이동 횟수 계산
        int moveRedLeft = redCount - leftRed;
        int moveRedRight = redCount - rightRed;
        int moveBlueLeft = blueCount - leftBlue;
        int moveBlueRight = blueCount - rightBlue;

        // 최소 이동 횟수 출력
        int result = Math.min(Math.min(moveRedLeft, moveRedRight), Math.min(moveBlueLeft, moveBlueRight));
        System.out.println(result);
    }
}
