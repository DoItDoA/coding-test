package kakao.level3;
import java.util.*;

public class NPlusOne2 {

    class Solution {
        private static boolean[] chk;
        private static List<Integer> hand = new ArrayList<>();
        private static int n, coin;

        public int solution(int coin, int[] cards) {
            n = cards.length;
            this.coin = coin;
            chk = new boolean[n+1];

            for(int i =0; i<n/3; i++) hand.add(cards[i]);

            int round = 1;
            for(int i=n/3; i<n; i+=2){
                hand.add(cards[i]);
                hand.add(cards[i+1]);

                if(handChk(cards)) {
                    round++;
                    continue;
                }
                if(coin > 0 && allChk(hand)){
                    round++;
                    continue;
                }

                break;
            }

            return round;
        }

        private static boolean allChk(List<Integer> hand){
            for(int i =0 ;i<hand.size(); i++){
                for(int j =i+1; j<hand.size(); j++){
                    if(hand.get(i)+hand.get(j) == n+1 && !chk[hand.get(i)] && !chk[hand.get(j)]){
                        if(i>=n/3) coin--;
                        if(j>=n/3) coin--;
                        if(coin < 0) return false;


                        chk[hand.get(i)] = true;
                        chk[hand.get(j)] = true;
                        return true;
                    }
                }
            }
            return false;
        }


        private static boolean handChk(int[] hand){
            for(int i =0; i<n/3; i++){
                for(int j =i+1; j<n/3; j++){
                    if(hand[i]+hand[j] == n+1 && !chk[hand[i]] && !chk[hand[j]]){
                        chk[hand[i]] = true;
                        chk[hand[j]] = true;
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
