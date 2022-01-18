package baek;

import java.io.*;

public class BOJ_10871 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String x = reader.readLine().split(" ")[1];
        int X = Integer.parseInt(x);
        String[] As = reader.readLine().split(" ");
        for(String tmp:As){
            int a = Integer.parseInt(tmp);
            if(a<X){
                writer.write(a+" ");
            }
        }
        writer.flush();
    }
}
