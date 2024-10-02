import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] score = new int[n+1];

        for(int i=1;i<=n;i++){
            score[i]=sc.nextInt();
        }

        if(n==1){
            System.out.println(score[1]);
            return;
        }
        if(n==2){
            System.out.println(score[1]+score[2]);
            return;
        }
        int[]dp=new int[n+1];
        dp[1]=score[1];
        dp[2]=score[1]+score[2];

        for(int i=3;i<=n;i++){
            int a = score[i]+dp[i-2];
            int b = score[i]+score[i-1]+dp[i-3];
            dp[i]=Math.max(a,b);
        }
        System.out.println(dp[n]);
    }
}
