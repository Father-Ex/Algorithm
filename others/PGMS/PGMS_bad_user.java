package baek.others.PGMS;

import java.util.*;
import java.util.regex.Pattern;

class Solution {
    int size;
    String[] arr;
    Set<Set<String>> answerSet;
    List<List<String>> jjList;
    
    public int solution(String[] user_id, String[] banned_id) {
        size = banned_id.length;
        
        arr = new String[size];
        for(int i=0; i<size; i++){
            banned_id[i] = banned_id[i].replaceAll("\\*", "\\\\w");
        }
        jjList = new ArrayList<List<String>>();
        for(int i=0; i<size; i++){
            jjList.add(new ArrayList<String>());
            for(String userId:user_id){
                if(Pattern.matches(banned_id[i], userId)){
                    jjList.get(i).add(userId);
                }
            }
        }
        
        answerSet = new HashSet<Set<String>>();
        make(0);
        
        return answerSet.size();
    }
    public void make(int idx){
        if(idx==size){
            Set<String> as = new HashSet<String>();
            for(String tmp:arr){
                as.add(tmp);
            }
            if(as.size()==size){
                answerSet.add(as);
            }
            return;
        }
        List<String> each = jjList.get(idx);
        for(int i=0; i<each.size(); i++){
            arr[idx] = each.get(i);
            make(idx+1);
        }
    }
}