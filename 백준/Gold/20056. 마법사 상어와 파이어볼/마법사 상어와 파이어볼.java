import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] Heavy = new int[N+1][N+1];
        int[][] Speed = new int[N+1][N+1];
        int[][] DirReal = new int[N+1][N+1];
        //0: 기본 -> 같은 애들만 들어옴 1:다른 애 들어옴 -> real과 비교해서 표시하기
        int[][] DirCh = new int[N+1][N+1];
        int[][] Num = new int[N+1][N+1];


        int[][] SettedHeavy = new int[N+1][N+1];
        int[][] SettedSpeed = new int[N+1][N+1];
        int[][] SettedDirReal = new int[N+1][N+1];
        //0: 기본 -> 같은 애들만 들어옴 1:다른 애 들어옴 -> real과 비교해서 표시하기
        int[][] SettedDirCh = new int[N+1][N+1];
        int[][] SettedNum = new int[N+1][N+1];

        Deque<int[]> exist = new LinkedList<>();

        for(int i=0;i<M;i++){
            String[] put = br.readLine().split(" ");
            int r = Integer.parseInt(put[0]);
            int c = Integer.parseInt(put[1]);
            int m = Integer.parseInt(put[2]);
            int s = Integer.parseInt(put[3]);
            int d = Integer.parseInt(put[4]);

            SettedHeavy[r][c]=m;
            SettedSpeed[r][c]=s;
            SettedDirReal[r][c]=d;
            SettedDirCh[r][c]=0;
            SettedNum[r][c]=1;
            exist.push(new int[]{r,c});
        }

        int[] dr = {-1,-1,0,1,1,1,0,-1};
        int[] dc = {0,1,1,1,0,-1,-1,-1};

        for(int i=0;i<K;i++){

            //이동
            int size = exist.size();
            for(int j=0;j<size;j++){
                int[] nowIdx = exist.poll();
                int row = nowIdx[0];
                int col = nowIdx[1];

                //num>1 이면 4개로 무조건 나뉨 -> 4번 반복

                //num==1 이면 한 번 만

                int numb = SettedNum[row][col];
                //System.out.println(numb);
                if(numb==1){
                    int nowM = SettedHeavy[row][col];
                    int nowS = SettedSpeed[row][col];
                    int nowDirReal = SettedDirReal[row][col];

                    int moveR = row + SettedSpeed[row][col]*dr[SettedDirReal[row][col]];
                    int moveC = col + SettedSpeed[row][col]*dc[SettedDirReal[row][col]];
                    //System.out.println(row+" "+ col+" : "+nowDirReal+" ");

                    if(moveR>N){
                        moveR=moveR%N;
                    }
                    while(moveR<1){
                        moveR=moveR+N;
                    }
                    if(moveC>N){
                        moveC=moveC%N;
                    }
                    while(moveC<1){
                        moveC=moveC+N;
                    }
                    Heavy[moveR][moveC]+=nowM;
                    Speed[moveR][moveC]+=nowS;
                    if(Num[moveR][moveC]>=1 && nowDirReal%2 != DirReal[moveR][moveC]%2){
                        DirCh[moveR][moveC]=1;
                    }
                    else if(Num[moveR][moveC]==0){
                        DirReal[moveR][moveC]=nowDirReal;
                    }

                    Num[moveR][moveC]++;
                    SettedHeavy[row][col] =0;
                    SettedNum[row][col]=0;
                    //exist.push(new int[]{moveR,moveC});
                }
                else if(numb==4){
                    for(int k =0;k<=7;k=k+2){
                        //1 3 5 7
                        if(SettedDirCh[row][col]==1){
                            int nowM = SettedHeavy[row][col];
                            int nowS = SettedSpeed[row][col];
                            int nowDirReal = k+1;
                            int moveR = row + SettedSpeed[row][col]*dr[nowDirReal];
                            int moveC = col + SettedSpeed[row][col]*dc[nowDirReal];

                            //System.out.println(row+" "+ col+" : "+nowDirReal+" ");

                            if(moveR>N){
                                moveR=moveR%N;
                            }
                            while(moveR<1){
                                moveR=moveR+N;
                            }
                            if(moveC>N){
                                moveC=moveC%N;
                            }
                            while(moveC<1){
                                moveC=moveC+N;
                            }
                            Heavy[moveR][moveC]+=nowM;
                            Speed[moveR][moveC]+=nowS;
                            if(Num[moveR][moveC]>=1 && nowDirReal%2 != DirReal[moveR][moveC]%2){
                                DirCh[moveR][moveC]=1;
                            }
                            else if(Num[moveR][moveC]==0){
                                DirReal[moveR][moveC]=nowDirReal;
                            }

                            Num[moveR][moveC]++;
                            //exist.push(new int[]{moveR,moveC});
                        }
                        //0 2 4 6
                        else{
                            int nowM = SettedHeavy[row][col];
                            int nowS = SettedSpeed[row][col];
                            int nowDirReal = k;
                            int moveR = row + SettedSpeed[row][col]*dr[nowDirReal];
                            int moveC = col + SettedSpeed[row][col]*dc[nowDirReal];

                            //System.out.println(row+" "+ col+" : "+nowDirReal+" ");

                            if(moveR>N){
                                moveR=moveR%N;
                            }
                            while(moveR<1){
                                moveR=moveR+N;
                            }
                            if(moveC>N){
                                moveC=moveC%N;
                            }
                            while(moveC<1){
                                moveC=moveC+N;
                            }
                            //System.out.println(moveR+" "+ moveC+" : "+nowDirReal+" "+Num[moveR][moveC]);

                            Heavy[moveR][moveC]+=nowM;
                            Speed[moveR][moveC]+=nowS;
                            if(Num[moveR][moveC]>=1 && nowDirReal%2 != DirReal[moveR][moveC]%2){
                                DirCh[moveR][moveC]=1;
                            }

                            else if(Num[moveR][moveC]==0){
                                DirReal[moveR][moveC]=nowDirReal;
                            }

                            Num[moveR][moveC]++;
                            //exist.push(new int[]{moveR,moveC});
                        }
                    }
                }
                SettedHeavy[row][col] =0;
                SettedSpeed[row][col]=0;
                SettedNum[row][col]=0;
            }
            exist.clear();
            //칸 상태 업데이트
            //size = exist.size();
            for(int j=1;j<=N;j++){
                for(int l=1;l<=N;l++){
                    if(Num[j][l]>=2){
                        SettedNum[j][l]=4;
                        SettedHeavy[j][l]=(Heavy[j][l]/5);
                        Heavy[j][l]=0;
                        SettedSpeed[j][l]=(Speed[j][l]/Num[j][l]);
                        Speed[j][l]=0;
                        SettedDirCh[j][l]=DirCh[j][l];
                        DirCh[j][l]=0;
                        Num[j][l]=0;
                        SettedDirReal[j][l]=DirReal[j][l];
                        DirReal[j][l]=0;

                        if(SettedHeavy[j][l]!=0){
                            exist.push(new int[]{j,l});
                        }
                    }
                    else if(Num[j][l]==1){
                        SettedNum[j][l]=1;
                        Num[j][l]=0;
                        exist.push(new int[]{j,l});
                        SettedHeavy[j][l]=Heavy[j][l];
                        Heavy[j][l]=0;
                        SettedSpeed[j][l]=Speed[j][l];
                        Speed[j][l]=0;
                        SettedDirCh[j][l]=DirCh[j][l];
                        DirCh[j][l]=0;
                        SettedDirReal[j][l]=DirReal[j][l];
                        DirReal[j][l]=0;
                        //DirReal[j][l]=0;
                    }
                    else{
                        SettedNum[j][l]=0;
                    }
                }
            }
//            for(int j=1;j<=N;j++) {
//                for (int l = 1; l <= N; l++) {
//                    System.out.print(SettedHeavy[j][l]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("--------------");
//            for(int j=1;j<=N;j++) {
//                for (int l = 1; l <= N; l++) {
//                    System.out.print(SettedNum[j][l]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }
        int sum=0;
        int size = exist.size();
        for(int i=0;i<size;i++){
            int[] get = exist.poll();
            int r = get[0];
            int c = get[1];
            sum+= (SettedHeavy[r][c] * SettedNum[r][c]);
        }
        System.out.println(sum);
    }
}
