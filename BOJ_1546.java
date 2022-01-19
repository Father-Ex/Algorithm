package baek;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1546 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine()); //총 과목 수
        int M = 0;
        StringTokenizer st = new StringTokenizer(reader.readLine()); //과목별 점수
        int[] scores = new int[N];

        for(int i=0; i<N; i++){
            scores[i] = Integer.parseInt(st.nextToken()); //입력받은 점수를 int로 형변환
            if(M<scores[i]){
                M = scores[i]; //기존 최댓값보다 큰 값이 나오면 그 값을 최댓값으로 지정
            }
        }
        
        double sum = 0;

        //조작 후 점수의 총합 구하기
        for(int tmp:scores){
            sum += (double)tmp/M*100;
        }

        writer.write(sum/N+"");
        writer.close();
    }
}
