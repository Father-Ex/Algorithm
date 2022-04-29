package baek.others.PGMS;

class Solution {
    public int solution(int n) {
        int a = 1;
        int b = 2;
        for(int i=3; i<=n; i++){
            int c = a+b;
            if(c>=1_000_000_007){
                c -= 1_000_000_007;
            }
            a = b;
            b = c;
        }
        return b;
    }
}
