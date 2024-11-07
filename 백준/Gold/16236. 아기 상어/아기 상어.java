import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int N;
    public static long S;
    public static int[] arr;
    public static int min = Integer.MAX_VALUE;
    public static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //test();
        N = Integer.parseInt(br.readLine());
        graph=new int[N][N];

        boolean iniCh = false;
        int iniRow=0;
        int iniCol=0;
        int iniSize=2;
        for(int i=0;i<N;i++){
            String[]input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                graph[i][j]=Integer.parseInt(input[j]);
                if(graph[i][j]<2 && graph[i][j]!=0) iniCh=true;
                if(graph[i][j]==9){
                    iniRow=i;
                    iniCol=j;
                    graph[i][j]=0;
                }
            }
        }

        if(iniCh==false){
            System.out.println(0);
            return;
        }

        nowSize=iniSize;
        nowRow=iniRow;
        nowCOl=iniCol;
        totalTime=0;
        curEat=0;

        int chRow = iniRow;
        int chCol = iniCol;
        while(true){
            findWay();
            //System.out.println(chRow+" "+chCol+" : "+nowRow+" "+nowCOl);
            if(nowRow==chRow && nowCOl==chCol) break;
            chRow=nowRow;
            chCol=nowCOl;

        }

        System.out.println(totalTime);

    }
    public static int curEat;
//    public static boolean findPossibleEat(){
//        boolean ch = false;
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                if(graph[i][j]>0 && graph[i][j]<nowSize){
//                    ch=true;
//                    break;
//                }
//            }
//        }
//        return ch;
//    }
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,-1,0,1};
    public static int nowRow;
    public static int nowCOl;
    public static int nowSize;
    public static class Fish{
        int row;
        int col;
        int distance;
        public Fish(int r, int c, int d){
            this.row=r;
            this.col=c;
            this.distance=d;
        }
    }
    public static int[][] visited;
    public static void findWay(){
        visited = new int[N][N];
        int minD = N*N;
        PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.distance==o2.distance){
                    if(o1.row==o2.row){
                        return o1.col-o2.col;
                    }
                    return o1.row-o2.row;
                }
                return o1.distance-o2.distance;
            }
        });
        Fish ini = new Fish(nowRow,nowCOl,0);
        pq.offer(ini);
        visited[nowRow][nowCOl]=1;

        while(!pq.isEmpty()){
            Fish now = pq.poll();
            if(now.distance>=minD) break;
            if(graph[now.row][now.col]<nowSize && graph[now.row][now.col]>0){
                changeGraph(now.row,now.col,now.distance);
//                minD=now.distance;
//                for(int i=0;i<N;i++){
//                    for(int j=0;j<N;j++){
//                        System.out.print(graph[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                break;
            }
            for(int i=0;i<4;i++){
                int nr = now.row+dr[i];
                int nc = now.col+dc[i];

                if(nr>=0&&nr<N && nc>=0&&nc<N && visited[nr][nc]!=1){
                    if(graph[nr][nc]>nowSize) continue;
                    visited[nr][nc]=1;
                    Fish put = new Fish(nr,nc,now.distance+1);
                    pq.offer(put);
                }
            }
        }
    }
    public static int totalTime;
    public static void changeGraph(int fr, int fc, int fd){
        nowRow=fr;
        nowCOl=fc;
        totalTime+=fd;

        graph[fr][fc]=0;
        curEat++;
        if(curEat==nowSize){
            nowSize++;
            curEat=0;
        }
    }
    public static void test(){
        Random random = new Random();
        N = 20;
        graph=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                graph[i][j]=random.nextInt(2);
            }
        }
        graph[0][0]=9;
    }
}
