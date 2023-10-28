package b1476;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int en = 0, sn=0, mn=0;
        int year =0;
        while(true){
            year++;
            en++;
            sn++;
            mn++;
            if(en==16) en=1;
            if(sn==29) sn=1;
            if(e==en &&m==mn&&s==sn) break;
        }
        System.out.println(year);

    }
}
