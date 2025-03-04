package kakao.level2;

public class Prime {
    class Solution {
        public int solution(int n, int k) {
            String str = Long.toString(n, k);

            String[] nums = str.split("0");
            int cnt = 0;
            for(String num : nums){
                if(num.equals("")) continue;
                if(isPrime(Long.parseLong(num))) cnt++;
            }

            return cnt;
        }
        private static boolean isPrime(long num){
            if(num == 1) return false;
            else if(num == 2 || num == 3) return true;
            else if(num % 2 == 0) return false;
            for(int i =2; i<= Math.sqrt(num); i++){
                if(num % i == 0) return false;
            }
            return true;
        }
    }
}
