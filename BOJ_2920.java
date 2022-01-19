package baek;

import java.io.*;

public class BOJ_2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = reader.readLine().replaceAll(" ", ""); //입력받은 숫자에서 공백을 제거
        String result = ""; //판별 결과를 저장할 변수
        
        if(numStr.charAt(0)==49||numStr.charAt(0)==56){ //첫 숫자가 1 또는 8인지 확인(다른 숫자라면 반드시 mixed이므로 판별 불필요)
            int n = numStr.charAt(0)-numStr.charAt(1); //만약 8개의 수가 asc 또는 desc라면 등차수열이므로
                                                       //판별을 위해 첫 두 수의 차이를 기준으로 삼음
            for(int i=2; i<numStr.length(); i++){ //마지막 수까지 한 칸씩 이동하며 차이를 비교함

                //위에서 구한 기준에 새로 계산한 차이를 비교
                if(n!=numStr.charAt(i-1)-numStr.charAt(i)){ //두 쌍의 차이가 다르다면
                    result = "mixed"; //등차수열이 아님 -> mixed
                    break; //판정이 끝났으므로 비교 종료
                }else if(i==numStr.length()-1){ //끝까지 차이가 동일할 경우
                    result = numStr.charAt(0)==49 ? "ascending" : "descending"; //첫 숫자가 1이라면 asc, 8이라면 desc
                }
            }
        }else{ //첫 숫자가 1 또는 8이 아니라면
            result = "mixed"; //결과는 반드시 mixed
        }
        writer.write(result);
        writer.close();
    }
}
