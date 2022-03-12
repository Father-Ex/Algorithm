package baek.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class BOJ_10942 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        int[] nums = new int[N+1];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(reader.readLine());
        int S = 0;
        int E = 0;
        int sum = 0;

        while(M-->0){
            st = new StringTokenizer(reader.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            while(S<=E){
                sum += nums[S++]^nums[E--];
            }
            if(sum==0){
                writer.write("1\n");
            }else{
                writer.write("0\n");
            }
            sum = 0;
        }
        writer.flush();
    }
    
}
