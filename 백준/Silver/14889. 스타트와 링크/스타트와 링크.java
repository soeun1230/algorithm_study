import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] S;
    static int result=1000000;
    static int diff=0,sum1=0,sum2=0;
    static int[] visited, visitedCal, cal1, cal2;
    static int[] start;
    static ArrayList<Integer> link;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N=Integer.parseInt(br.readLine());

        S=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                S[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N+1];
        visitedCal = new int[N/2+1];
        cal1 = new int[2];
        cal2 = new int[2];

        start = new int[N/2];
        link = new ArrayList<>();

        dfs_team(0,1);
        System.out.println(result);

        br.close();
    }
    //팀 나누기
    static void dfs_team(int ch,int at){
        if(ch==N/2){
            for(int i=1;i<=N;i++){
                if(visited[i]==0){
                    link.add(i);
                }
            }
            //계산하기
            differentCal(0);

            if(sum1>sum2){
                diff=sum1-sum2;
            }
            else{
                diff=sum2-sum1;
            }
            result=Math.min(result,diff);
            link.clear();
            sum1=0;
            sum2=0;
            return;
        }
        else{
            for(int i=at;i<=N;i++){
                if(visited[i]==1){
                    continue;
                }
                else{
                    visited[i]=1;
                    start[ch]=i;
                    dfs_team(ch+1,i+1);
                    visited[i]=0;
                }
            }

        }
    }
    //diff cal
    static void differentCal(int n){
        if(n==2){
            sum1 = sum1+S[cal1[0]][cal1[1]];
            sum2 = sum2+S[cal2[0]][cal2[1]];
            return;
        }
        else{
            for(int i=0;i<N/2;i++){
                if(visitedCal[i]==1) {
                    continue;
                }
                else{
                    visitedCal[i]=1;
                    cal1[n]=start[i];
                    cal2[n]=link.get(i);
                    differentCal(n+1);
                    visitedCal[i]=0;
                }
            }
        }
    }
}