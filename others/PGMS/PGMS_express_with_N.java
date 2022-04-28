package baek.others.PGMS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        if(N==number) return 1;
        int answer = -1;
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();
        for(int i=0; i<8; i++){
            list.add(new HashSet<Integer>());
        }
        list.get(0).add(N);
        for(int i=1; i<=7; i++){
            int n = N;
            for(int j=0; j<i; j++){
                n = n*10+N;
            }
            list.get(i).add(n);
            for(int j=0; j<i; j++){
                for(int a:list.get(j)){
                    for(int b:list.get(i-j-1)){
                        if(a+b>0) list.get(i).add(a+b);
                        if(a-b>0) list.get(i).add(a-b);
                        if(a*b>0) list.get(i).add(a*b);
                        if(a/b>0) list.get(i).add(a/b);
                    }
                }
            }
            if(list.get(i).contains(number)){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
