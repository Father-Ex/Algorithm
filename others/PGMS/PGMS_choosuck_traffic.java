package baek.others.PGMS;

class Solution {
    public int solution(String[] lines) {
        int answer = 1;
        int[][] se = new int[lines.length][2]; //시작시간과 완료시간을 ms로 저장
        for(int i=0; i<lines.length; i++){
            String[] ST = lines[i].split(" ");
            
            //완료시간 S를 ms로 변환
            String[] S = ST[1].split("[:.]");
            int h = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int end = h*3600000+m*60000+s*1000+Integer.parseInt(S[3]);
            
            //처리시간 T와 완료시간 S를 이용하여 시작시간을 ms로 구함
            String Ts = ST[2].substring(0, ST[2].length()-1);
            int T = 0;
            if(Ts.indexOf(".")==-1){
                T = Integer.parseInt(Ts)*1000;
            }else{
                int cnt = 3-(Ts.length()-1)+Ts.indexOf(".");
                while(cnt-->0){
                    Ts += "0";
                }
                T = Integer.parseInt(Ts.replace(".", ""));
            }
            int start = end-T+1;
            se[i][0] = start;
            se[i][1] = end;
        }
        int point = 0;
        int cnt = 1;
        for(int i=0; i<se.length-1; i++){
            point = se[i][1];
            for(int j=i+1; j<se.length; j++){
                if(se[j][0]<point+1000){
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
            cnt = 1;
        }
        return answer;
    }
}
