package baek.others.PGMS;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long)times[times.length-1]*n;
        long answer = n<=times.length ? times[n-1] : right;
        
        while(left<=right){
            long center = (left+right)/2;
            long cnt = 0;
            
            for(long t:times){
                cnt += center/t;
            }
            if(cnt>=n){
                answer = center;
                right = center-1;
            }else{
                left = center+1;
            }
        }
        return answer;
    }
}
