import java.util.*;
import java.io.*;

public class Main{
    //N
    static int N;
    //T,P
    static int[] T,P;
    //sum
    static int sum=0;
    //DP
    static int DP[];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N=Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];

        DP = new int[N+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        findPossible(0,0);
        System.out.println(sum);
        
//        //DP 사용버전 
//        dynamicProgramming();
//        System.out.println(DP[0]);
        br.close();
    }
    //최댓값 찾기 (dfs - 백트래킹)
    static void findPossible(int ch, int pay){
        if(ch>=N){  //dfs 탈툴 조건
            sum = Math.max(pay,sum);
            return;
        }
        if(ch+T[ch]<=N){  //상담 끝낼 수 있을 때
            findPossible(ch+T[ch],pay+P[ch]);
        }
        else{  //상담 못 끝낼 때, 돈 안더해줌
            findPossible(ch+T[ch],pay);
        }
        //마지막 검사 후 바로 다음 날짜 검사
        findPossible(ch+1,pay);

    }
    //최댓값 찾기 by DP - 뒤에서 부터 하면 편함
    static void dynamicProgramming(){
        for(int i=N-1;i>=0;i--){
            int next = i+T[i];

            if(next>N){
                DP[i] = DP[i+1];
            }
            else{
                DP[i] = Math.max(DP[i+1],DP[next]+P[i]);
            }
        }
    }
}