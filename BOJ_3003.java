package baek;

import java.util.Scanner;

public class BOJ_3003 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rightNums = {1, 1, 2, 2, 2, 8};
        int tmp = 0;
        for(int i=0; i<rightNums.length; i++){
            tmp = scan.nextInt();
            System.out.print(rightNums[i]-tmp+" ");
        }
    }
}
