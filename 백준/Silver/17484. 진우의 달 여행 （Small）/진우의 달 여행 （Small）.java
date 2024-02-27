import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main{
    static int[] dy={-1,0,1};
    static int[][] board;
    static int[] visited;
    static int small =600;
    static int N,M;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new int[N][M];

        for(int i=0;i<N;i++){
            String[] put = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(put[j]);
            }
        }

        for(int i=0;i<M;i++){
            visited = new int[N];
            visited[0] = i;
            dfs(1,i,-1);
        }


        System.out.println(small);
        br.close();
    }
    public static void dfs(int depth, int y, int dir){
        if(depth==N){
            int sum=board[0][visited[0]];
            for(int i=1;i<N;i++){
                sum+=board[i][visited[i]];
            }
            small=Math.min(small,sum);
            return;
        }
        for(int i=0;i<3;i++){
            int nowy = y + dy[i];
            if(position(nowy) && dir!=i){
                visited[depth] = nowy;
                dfs(depth+1,nowy,i);
            }
        }
    }
    public static boolean position(int y){
        if(y<0 || y>=M){
            return false;
        }
        return true;
    }

}