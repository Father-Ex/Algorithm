package baek.others.PGMS;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {    
        String answer = "";
        int[] times = new int[timetable.length];
        for(int i=0; i<times.length; i++){
            String[] hm = timetable[i].split(":");
            times[i] = Integer.parseInt(hm[0])*60+Integer.parseInt(hm[1]);
        }
        Arrays.sort(times);
        
        int lastTime = 540+(n-1)*t;
        int idx = 0;
        int cnt = 0;
        for(int i=540; i<=lastTime; i+=t){
            while(idx<times.length && times[idx]<=i && cnt<m){
                cnt++;
                idx++;
            }
            if(i<lastTime){
                cnt = 0;
            }
        }
        if(cnt==m){
            answer = String.format("%02d:%02d", (times[idx-1]-1)/60, (times[idx-1]-1)%60);
        }else{
            answer = String.format("%02d:%02d", lastTime/60, lastTime%60);
        }
        
        return answer;
    }
}
