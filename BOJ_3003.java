package baek;

import java.util.Scanner;

public class BOJ_3003 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rightNums = {1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<rightNums.length; i++){
            sb.append(rightNums[i]-scan.nextInt()+" ");
        }
        System.out.println(sb.toString());
    }
}
