import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int N;
    public static String ini;
    public static String target;

    public static int min = Integer.MAX_VALUE;
    public static int[][] cost;
    public static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt =0;

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) return;



            cnt++;
            min = Integer.MAX_VALUE;
            cost = new int[N][N];
            visited = new int[N][N];
            test();

            for(int i=0;i<N;i++){
                String[] input = br.readLine().split(" ");
                for(int j=0;j<N;j++){
                    cost[i][j]=Integer.parseInt(input[j]);
                }
            }

            bfs();
            System.out.println("Problem "+cnt+": "+min);
        }
    }

    public static void test(){
        Random random = new Random();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cost[i][j]=random.nextInt(10);
            }
        }
    }
    public static class Status{
        int row;
        int col;
        int cost;

        public Status(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public static int[] dr = {0,1,0,-1};
    public static int[] dc = {1,0,-1,0};
    public static void bfs(){
        PriorityQueue<Status> pq = new PriorityQueue<>(new Comparator<Status>(){
            @Override
            public int compare(Status o1, Status o2){
                return o1.cost-o2.cost;
            }
        });
        Status input = new Status(0,0,cost[0][0]);
        visited[0][0]=1;

        pq.offer(input);
        while(!pq.isEmpty()){
            Status now = pq.poll();
            if(now.cost>=min) break;
            if(now.col==N-1 && now.row==N-1){
                if(now.cost<min){
                    min=now.cost;
                }
            }
            for(int i=0;i<4;i++){
                int nr = now.row+dr[i];
                int nc = now.col+dc[i];

                if(nr>=0&&nr<N && nc>=0&&nc<N && visited[nr][nc]!=1){
                    visited[nr][nc]=1;
                    Status put = new Status(nr,nc,now.cost+cost[nr][nc]);
                    pq.offer(put);
                }
            }

        }
    }
}

