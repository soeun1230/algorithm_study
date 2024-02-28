import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[] visited;
    static int[][] arr;
    static int linked=0;
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new int[N+1];

       for(int i=0;i<M;i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           arr[a][b] = arr[b][a] = 1;
       }

       for(int i=1;i<N+1;i++){
           if(visited[i]!=1){
               dfs(i);
               linked++;
           }
       }

        System.out.println(linked);
        br.close();
    }
    public static void dfs(int num) {
        visited[num]=1;
        for(int i=1;i<N+1;i++){
            if(visited[i]!=1 && arr[num][i]==1){
                dfs(i);
            }
        }
    }
}