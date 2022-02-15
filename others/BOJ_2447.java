package baek.others;

import java.io.*;

public class BOJ_2447 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());

        String[] stars = makeStar(length);
        
        for(String tmp:stars){
            System.out.println(tmp);
        }
    }

    public static String[] makeStar(int length){
        if(length==3){
            String[] s = {"***","* *","***"};
            return s;
        }else{
            String[] s = new String[length];
            String[] ss = makeStar(length/3);
            int idx = 0;
            
            for(String tmp:ss){
                s[idx++] = tmp+tmp+tmp;
            }
            String blank = "";
            for(int i=0; i<length/3; i++){
                blank += " ";
            }
            for(String tmp:ss){
                s[idx++] = tmp+blank+tmp;
            }
            for(String tmp:ss){
                s[idx++] = tmp+tmp+tmp;
            }

            return s;
        }
    }
}
