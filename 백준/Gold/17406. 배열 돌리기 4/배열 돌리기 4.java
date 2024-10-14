import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map;
    public static int[][] mapCopy;
    public static int N,M;
    public static ArrayList<int[]> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        map = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            String[] put = br.readLine().split(" ");
            for(int j=1;j<=M;j++){
                map[i][j]=Integer.parseInt(put[j-1]);
            }
        }
        for(int i=0;i<K;i++){
            String[] put = br.readLine().split(" ");
            int r = Integer.parseInt(put[0]);
            int c = Integer.parseInt(put[1]);
            int s = Integer.parseInt(put[2]);
            int[] pp = {r,c,s};
            arr.add(pp);
        }
        order = new int[K];
        visited = new int[K];
        dfs(0, K);

        System.out.println(ans);

    }
    public static int[] order;
    public static int[] visited;

    public static int ans = Integer.MAX_VALUE;
    public static void dfs(int dep, int tar){
        if(dep==tar){
            mapCopy=new int[N+1][M+1];
            for(int t=1;t<=N;t++){
                for(int j=1;j<=M;j++){
                    mapCopy[t][j]=map[t][j];
                }
            }

//            System.out.println("start :");
//            for(int t=1;t<=N;t++){
//                for(int j=1;j<=M;j++){
//                    System.out.print(mapCopy[t][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("change");

            int now =CalScore();
            if(ans>now) ans = now;
            return;
        }
        for(int i=0;i<tar;i++){
            if(visited[i]==1) continue;
            visited[i]=1;
            order[dep]=i;
            dfs(dep+1,tar);
            visited[i]=0;
        }
    }
    public static int CalScore(){
        Rotate();
        //debug
//        for(int t=1;t<=N;t++){
//            for(int j=1;j<=M;j++){
//                System.out.print(mapCopy[t][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("_---------------------------");

        int min = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++){
            int sum = 0;
            for(int j=1;j<=M;j++){
                sum+=mapCopy[i][j];
            }
            if(min>sum) min=sum;
        }

        return min;
    }

    public static int[] dr = {0,1,0,-1};
    public static int[] dc = {1,0,-1,0};
    public static void Rotate(){
        for(int i=0;i<order.length;i++){
//            System.out.println(i+" th time");
//            for(int t=1;t<=N;t++){
//                for(int j=1;j<=M;j++){
//                    System.out.print(mapCopy[t][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();


            int[] now = arr.get(order[i]);
            int[] start = new int[]{now[0]-now[2],now[1]-now[2]};
            int[] end = new int[]{now[0]+now[2], now[1]+now[2]};
            //System.out.println(start[0]+","+start[1] + " "+end[0]+","+end[1]);

            int startRow=start[0];
            int startCol=start[1];
            int endRow=end[0];
            int endCol=end[1];

            int num = (endCol-startCol)/2;
            for(int j=0;j<num;j++){
                int nowRow=startRow;
                int nowCol=startCol;
                int ind =0;
                int pp2 = mapCopy[nowRow][nowCol];
                int ini = mapCopy[startRow+1][startCol];
                while(!(nowRow==startRow-1 && nowCol==startCol)){
                    int nextRow = nowRow+dr[ind];
                    int nextCol = nowCol+dc[ind];
                    if(nextRow>endRow||nextRow<startRow || nextCol>endCol||nextCol<startCol){
                        ind++;
                        if(ind==4) {
                            break;
                        }
                        continue;
                    }
                    int pp = mapCopy[nextRow][nextCol];
                    mapCopy[nextRow][nextCol] = pp2;
                    pp2=pp;

                    nowRow=nextRow;
                    nowCol=nextCol;
                }
                mapCopy[startRow][startCol]=ini;
                startRow++;
                startCol++;
                endRow--;
                endCol--;
            }
        }
    }
}
