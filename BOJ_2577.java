package baek;

import java.io.*;

public class BOJ_2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        int C = Integer.parseInt(reader.readLine());
        int total = A*B*C;
        int[] each = new int[10];
        
        while(total!=0){
            each[total%10]++;
            total /= 10;
        }
        for(int n:each){
            writer.write(n+"\n");
        }
        writer.close();
    }
}
