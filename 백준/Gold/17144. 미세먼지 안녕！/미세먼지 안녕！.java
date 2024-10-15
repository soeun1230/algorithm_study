import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, T;
    public static int[][] map;
    public static int[][] mapCopy;
    public static int cnt = 0;
    public static int[] updr = {-1,0,1,0};
    public static int[] updc = {0,1,0,-1};
    public static int[] downdr = {1,0,-1,0};
    public static int[] downdc = {0,1,0,-1};
    public static int baseCol1, baseCol2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        map = new int[N][M];

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==-1){
                    arr.add(i);
                }
            }
        }

        baseCol1 = Math.min(arr.get(0),arr.get(1));
        baseCol2 = Math.max(arr.get(0),arr.get(1));



        int time =0;
        while(time<T){
            spread();
            rotate();
            time++;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]>0) cnt+=map[i][j];
            }
        }
        System.out.println(cnt);
    }

    public static void spread(){
        map[baseCol2][0]=-1;
        map[baseCol1][0]=-1;
        mapCopy = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int now = map[i][j];
                if(now>4){
                    int sp = now/5;
                    int num =0;
                    for(int k=0;k<4;k++){
                        int r = i+downdr[k];
                        int c = j+downdc[k];
                        if(r>=0&&r<N && c>=0&&c<M && map[r][c]!=-1){
                            num++;
                            mapCopy[r][c]+=sp;
                        }
                    }
                    map[i][j]=map[i][j]-sp*num;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]+=mapCopy[i][j];
                //System.out.print(map[i][j]+" ");
            }
            //System.out.println();
        }

    }
    public static void rotate(){
        int nowRow = baseCol1-1;
        int nowCol =0;
        map[baseCol1][0]=0;
        int dir=0;
        while(dir<4){
            int nextRow = nowRow+updr[dir];
            int nextCol = nowCol+updc[dir];
            if(nextRow<=baseCol1&&nextRow>=0 && nextCol>=0&&nextCol<M){
                map[nowRow][nowCol]=map[nextRow][nextCol];
                nowRow=nextRow;
                nowCol=nextCol;
            }
            else{
                dir++;
            }

        }
        map[baseCol1][0]=0;

        nowRow = baseCol2+1;
        nowCol =0;
        map[baseCol2][0]=0;
        dir=0;
        while(dir<4){
            int nextRow = nowRow+downdr[dir];
            int nextCol = nowCol+downdc[dir];
            if(nextRow>=baseCol2&&nextRow<N && nextCol>=0&&nextCol<M){
                map[nowRow][nowCol]=map[nextRow][nextCol];
                nowRow=nextRow;
                nowCol=nextCol;
            }
            else{
                dir++;
            }

        }
        map[baseCol2][0]=0;

//        System.out.println("--------------");
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("------------------");
    }

}
