package baek;

public class BOJ_4673 {
	
	public static void main(String[] args) {
		boolean[] self = new boolean[10002]; //false=셀프넘버 , true=셀프넘버 아님. d(n)임
        int start = 1; //d(n)의 시작점.
                       //self[start]는 반드시 false여야 함(true라면 이전 루프에서 이미 지나갔기 때문)
        int moving = start; //루프중 새로운 d(n)을 담음. 시작은 셀프넘버
        while(start<10000){
            moving = start;
            while (moving <= 10000) { //셀프넘버에서 시작해 10000이하인 d(n)을 모두 구함
                int tmp = moving;
                int next = tmp; // 새로운 moving이 될 변수
                for(;tmp > 0; tmp /= 10) { //다음 d(n) 계산
                    next += tmp % 10;
                }
                moving = next;
                if(moving <= 10000){
                    self[moving] = true;
                }
            }
            //다음 시작점을 찾음(false인 지점)
            while(start<=10000&&self[start+1]==true){
                start++;
            }
            start++;
        }
        for(int i=1; i<=10000; i++){
            if(self[i]==false){
                System.out.println(i);
            }
        }
	}

}

