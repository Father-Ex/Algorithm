package baek;

import java.io.*;
import java.math.BigInteger;

public class BOJ_1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        BigInteger n = new BigInteger(s[0]);
        BigInteger m = new BigInteger(s[1]);

        writer.write(n.divide(m).toString()+"\n"+n.remainder(m).toString());
        writer.flush();
    }
}
