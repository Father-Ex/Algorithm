package baek.march_28_dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class PGMS_maximize {
    static char[] ocs = {'*', '+', '-'};
    static char[] arr = new char[3];
    static boolean[] visited = new boolean[3];
    static List<Long> answers = new ArrayList<>();
    static String[] numStr;
    static String operators;
    public static void main(String[] args) throws Exception {
        System.out.println(solution("100-200*300-500+20"));
    }
    static long solution(String expression) {
        long answer = 0;
        String reg = "[\\+\\-\\*]";
        numStr = expression.split(reg);
        operators = expression.replaceAll("[0-9]", "");  
        make(0);
        for(long tmp:answers){
            if(tmp>answer){
                answer = tmp;
            }
        }
        return answer;
    }
    static void make(int idx){
        if(idx>=3){
            List<Long> nums = new ArrayList<>(numStr.length); //분리한 숫자들
            String otmp = operators;
            for(String tmp:numStr){
                nums.add(Long.parseLong(tmp));
            }
            for(char oc:arr){
                for(int i=0; i<otmp.length(); i++){
                    if(otmp.charAt(i)==oc){
                        if(oc=='+'){
                            nums.set(i, nums.get(i)+nums.get(i+1));
                        }else if(oc=='-'){
                            nums.set(i, nums.get(i)-nums.get(i+1));
                        }else if(oc=='*'){
                            nums.set(i, nums.get(i)*nums.get(i+1));
                        }
                        nums.remove(i+1);
                        otmp = otmp.substring(0, i)+otmp.substring(i+1);
                        i--;
                    }
                }
            }
            answers.add(Math.abs(nums.get(0)));
        }else{
            for(int i=0; i<3; i++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[idx] = ocs[i];
                    make(idx+1);
                    visited[i] = false;
                }
            }
        }
    }
}