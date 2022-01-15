package baek;

import java.io.*;

public class BOJ_17496 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = reader.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int T = Integer.parseInt(st[1]);
        int C = Integer.parseInt(st[2]);
        int P = Integer.parseInt(st[3]);

        writer.write((N-1)/T*C*P+"");
        writer.close();
    }
}
