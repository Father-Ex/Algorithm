package baek;

import java.util.Scanner;

public class BOJ_5554 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = 4;
        int sum = 0;
        while(times-->0){
            sum += scan.nextInt();
        }
        System.out.printf("%d%n%d",sum/60,sum%60);
    }
}
