package baek.others.PGMS;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int sum = 0;
        int end = 0; //각 요청이 종료되는 시점
        int count = 0; //작업의 수행 횟수
        int idx = 0; //jobs 반복 인덱스
        
        Arrays.sort(jobs, (x, y)->x[0]-y[0]); //요청시간 기준 오름차순 정렬
        
        PriorityQueue<int[]> que = new PriorityQueue<int[]>((x, y)->x[1]-y[1]);
        
        while(count<jobs.length){
            while(idx<jobs.length && jobs[idx][0]<=end){
                que.add(jobs[idx++]);
            }
            
            if(que.isEmpty()){
                //이 부분이 실행되었다는 것은 작업이 남아 있으나
                //가장 마지막에 수행한 작업이 끝나는 순간까지 새 작업이 오지 않았음을 의미함
                end = jobs[idx][0];
            }else{
                int[] next = que.poll();
                sum += end+next[1]-next[0];
                end += next[1];
                count++;
            }
        }
        
        return sum/count;
    }
}
