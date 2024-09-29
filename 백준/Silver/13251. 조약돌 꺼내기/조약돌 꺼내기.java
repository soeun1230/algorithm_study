import java.util.*;
import java.io.*;

public class Main {
    public static int M,K;
    public static int[] stone;
    public static ArrayList<Double> arr =new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M= sc.nextInt();

        stone = new int[M];

        for(int i=0;i<M;i++){
            stone[i]=sc.nextInt();
        }

        K=sc.nextInt();

        double[][] dp = new double[K+1][M];

        int left=0;
        for(int st :stone){
            left+=st;
        }

        for(int i=0;i<M;i++){
            dp[0][i]=stone[i]/(double)left;
            stone[i]--;
        }
        //left--;

        double[][] Nextdp = new double[K+1][M];
        for(int k=0;k<K-1;k++){
            left--;
            for(int j=0;j<M;j++){
                //현재 돌과 같은 색 돌 뽑았을 때
                if(stone[j]>0){
                    Nextdp[k+1][j] = dp[k][j]*(stone[j]/(double)left);
                    stone[j]--;
                }
                else{
                    Nextdp[k+1][j] = 0;
                }
            }
            dp=Nextdp;
        }
        double ans = 0;
        for(int i=0;i<M;i++){
            ans+=dp[K-1][i];
        }
        System.out.println(ans);
    }


}
