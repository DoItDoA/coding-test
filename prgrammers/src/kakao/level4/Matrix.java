package kakao.level4;
import java.util.*;

public class Matrix {
    class Solution {
        public int[][] solution(int[][] rc, String[] operations) {
            int n = rc.length;
            int m = rc[0].length;

            Deque<Integer> left = new LinkedList<>();
            Deque<Integer> right = new LinkedList<>();
            Deque<Deque<Integer>> mid = new LinkedList<>();

            for(int i=0; i<n; i++){
                left.addLast(rc[i][0]);
                right.addLast(rc[i][m-1]);
                Deque<Integer> midLine = new LinkedList<>();
                for(int j= 1; j<m-1; j++){
                    midLine.addLast(rc[i][j]);
                }
                mid.addLast(midLine);
            }

            for(String op : operations){
                if(op.equals("Rotate")){
                    Deque<Integer> midUp = mid.peekFirst();
                    Deque<Integer> midDw = mid.peekLast();

                    midUp.addFirst(left.pollFirst());
                    right.addFirst(midUp.pollLast());
                    midDw.addLast(right.pollLast());
                    left.addLast(midDw.pollFirst());

                }else{
                    left.addFirst(left.pollLast());
                    right.addFirst(right.pollLast());
                    mid.addFirst(mid.pollLast());
                }
            }

            int[][] answer = new int[n][m];
            for(int i=0; i<n; i++){
                answer[i][0] = left.pollFirst();
                answer[i][m-1] = right.pollFirst();

                Deque<Integer> midLine = mid.pollFirst();
                for(int j=1; j<m-1; j++){
                    answer[i][j] = midLine.pollFirst();
                }
            }

            return answer;
        }
    }
}
