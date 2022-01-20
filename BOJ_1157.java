package baek;

import java.io.*;

public class BOJ_1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] word = reader.readLine().toUpperCase().toCharArray(); //대소문자 구분이 없으니 편의상 대문자로.
        int[] cntOfEach = new int[26]; //각 글자별 사용횟수 배열. 영어 알파벳은 총 26자(대소문자 구분X).

        for(char tmp:word){
            cntOfEach[tmp-65]++; //각 글자별 사용 횟수를 기록. 
        }

        int bigCount = 0; //최다 사용 글자의 사용 횟수.
        int bigIdx = 0; //최다 사용된 글자. 각 글자는 인덱스로 관리됨.
        boolean twoOrMore = false; //bigIdx가 여러개 있을 경우 true

        for(int a=0; a<26; a++){
            if(bigCount<cntOfEach[a]){ //사용횟수가 더 많은 글자가 나올 경우
                bigCount = cntOfEach[a]; //최다사용 수 갱신
                bigIdx = a; //최다사용 글자 갱신
                twoOrMore = false;
            }else if(bigCount==cntOfEach[a]){ //사용횟수가 같은 글자가 나올 경우
                twoOrMore = true;
            }
        }

        char result = twoOrMore ? '?' : (char)(bigIdx+65);
        writer.write(result);
        writer.close();
    }
}
