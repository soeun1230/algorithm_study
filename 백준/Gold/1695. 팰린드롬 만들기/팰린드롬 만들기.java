import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
        }

        int[][]dp = new int[n+1][n+1];


        for(int i=1;i<n;i++){
            for(int j=1;j<=(n-i);j++){
                if(arr[j]==arr[i+j]){
                    dp[j][i+j]=dp[j+1][i+j-1];
                }
                else{
                    int a = dp[j][i+j-1]+1;
                    int b = dp[j+1][i+j]+1;

                    dp[j][j+i]=Math.min(a,b);
                }
            }
        }


        System.out.println(dp[1][n]);
    }
}
