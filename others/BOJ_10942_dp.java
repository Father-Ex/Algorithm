package baek.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class BOJ_10942_dp {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        int[] nums = new int[N+1];
        boolean[][] palChk = new boolean[2001][2001]; // ex) palChk[123][234] = S가 123, E가 234인 경우이며
                                                      // true일 때 팰린드롬, false일 때 팰린드롬이 아님
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        palChk[1][1] = true;
        for(int i=2; i<=N; i++){
            palChk[i][i] = true; //선택한 숫자의 갯수가 1이라면 반드시 팰린드롬
            if(nums[i-1]==nums[i]){ //선택한 숫자의 갯수가 2라면 단순 비교만으로 팰린드롬 판별 가능
                palChk[i-1][i] = true;
            }
        }
        for(int i=2; i<=N-1; i++){ //j를 S로, j+i를 E로 사용
            for(int j=1; j+i<=N; j++){
                if(nums[j]==nums[j+i]){ //양 끝의 수가 같고
                    if(palChk[j+1][j+i-1]){ //양 끝을 제외한 안쪽의 수들이 팰린드롬이라면
                        palChk[j][j+i] = true; //해당 수들 또한 팰린드롬임
                    }
                }
            }
        }

        int M = Integer.parseInt(reader.readLine());
        int S = 0;
        int E = 0;

        while(M-->0){
            st = new StringTokenizer(reader.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if(palChk[S][E]){
                writer.write("1\n");
            }else{
                writer.write("0\n");
            }
        }
        writer.flush();
    }
    
}
