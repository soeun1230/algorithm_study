import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }

        int[][]dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            dp[i][i]=arr[i];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=(n-i);j++){
                int sum = 0;
                for(int k=j;k<=j+i;k++){
                    sum+=arr[k];
                }
                int a = dp[j][j+i-1];
                int b = dp[j+1][j+i];
                dp[j][j+i]=Math.max(a,b)+sum;

            }
        }
        System.out.println(dp[1][n]);
    }
}
