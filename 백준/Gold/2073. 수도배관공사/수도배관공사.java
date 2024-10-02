import java.util.*;
import java.io.*;

public class Main {
    public static int[] visited;
    public static int[] idx;
    public static int max =0;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int P = sc.nextInt();

        int[]dp = new int[D+1];
        for(int i=0;i<P;i++){
            int nowL = sc.nextInt();
            int nowC = sc.nextInt();

            for(int j=D;j>nowL;j--){
                if(dp[j-nowL]==0) continue;
                int next = Math.min(dp[j-nowL],nowC);
                dp[j]=Math.max(next,dp[j]);
            }
            dp[nowL]=Math.max(nowC,dp[nowL]);
        }
        System.out.println(dp[D]);
    }
}