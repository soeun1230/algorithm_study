import java.util.*;
import java.io.*;

public class Main {
    public static int N, M,D;
    public static int[] visited;
    public static int[][] map;
    public static int[] bow;
    public static int max = Integer.MIN_VALUE;
    public static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        D = Integer.parseInt(input[2]);

        map = new int[N][M];
        visited = new int[M];

        for(int i=0;i<N;i++){
            String[] put = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(put[j]);
                if(map[i][j]==1) cnt++;
            }
        }

        bow = new int[3];

        dfs(0);
        System.out.println(max);
    }
    public static int[][] mapCopy;
    public static void dfs(int dep){
        if(dep==3){
            mapCopy = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    mapCopy[i][j]=map[i][j];
                }
            }
            int kill = simul();
            if(kill>max) max=kill;
            return;
        }
        for(int i=0;i<M;i++){
            if(visited[i]==1) continue;
            visited[i]=1;
            bow[dep]=i;
            dfs(dep+1);
            visited[i]=0;
        }
    }

    public static int[][] smallVisit;
    public static int[] dr = {0,-1,0};
    public static int[] dc = {-1,0,1};
    public static Queue<int[]> die = new LinkedList<>();
    public static int simul() {
//        System.out.println("original");
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(mapCopy[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("___________________");
        int total = cnt;
        int kilNum=0;
        while (total > 0) {

            for (int i = 0; i < 3; i++) {
                int bowRow = N;
                int bowCol = bow[i];
                smallVisit = new int[N][M];

                Queue<int[]> que = new LinkedList<>();
                que.offer(new int[]{bowRow - 1, bowCol});
                smallVisit[bowRow - 1][bowCol] = 1;

                while (!que.isEmpty()) {
                    int[] now = que.poll();
                    int nowRow = now[0];
                    int nowCol = now[1];
                    if (mapCopy[nowRow][nowCol] == 1) {
                        die.offer(new int[]{nowRow, nowCol});
                        break;
                    }

                    for (int t = 0; t < 3; t++) {
                        int nr = nowRow + dr[t];
                        int nc = nowCol + dc[t];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        if (smallVisit[nr][nc] == 1) continue;
                        if (Math.abs(bowRow - nr) + Math.abs(bowCol - nc) > D) continue;

                        smallVisit[nr][nc] = 1;
                        que.offer(new int[]{nr, nc});
                    }
                }
            }

            while (!die.isEmpty()) {
                int[] ddie = die.poll();
                //System.out.print(ddie[0]+" "+ddie[1]+", ");
                if(mapCopy[ddie[0]][ddie[1]]==1){
                    mapCopy[ddie[0]][ddie[1]] = 0;
                    total--;
                    kilNum++;
                }
            }
            //System.out.println();

            for(int i=N-1;i>=0;i--){
                for(int j=0;j<M;j++){
                    if(i!=N-1){
                        if(mapCopy[i][j]==1){
                            mapCopy[i+1][j]=1;
                            mapCopy[i][j]=0;
                        }
                    }
                    else{
                        if(mapCopy[i][j]==1){
                            total--;
                            mapCopy[i][j]=0;
                        }
                    }
                }
            }

//            for(int i=0;i<N;i++){
//                for(int j=0;j<M;j++){
//                    System.out.print(mapCopy[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("___________________");

        }
        return kilNum;
    }

}