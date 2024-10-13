import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N+1][N+1];
        int[][] cloud = new int[N+1][N+1];

        ArrayList<int[]> nowCloud = new ArrayList<>();

        for(int i=1;i<=N;i++){
            String[] put = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                int now = Integer.parseInt(put[j-1]);
                map[i][j]=now;
            }
        }
        //초기 구름 위치
        cloud[N][1]=1;
        cloud[N][2]=1;
        cloud[N-1][1]=1;
        cloud[N-1][2]=1;

        nowCloud.add(new int[]{N,1});
        nowCloud.add(new int[]{N,2});
        nowCloud.add(new int[]{N-1,1});
        nowCloud.add(new int[]{N-1,2});

        int[] dr = {0,-1,-1,-1,0,1,1,1};
        int[] dc = {-1,-1,0,1,1,1,0,-1};

        for(int i=0;i<M;i++){
            String[] put = br.readLine().split(" ");
            int d = Integer.parseInt(put[0]);
            int s = Integer.parseInt(put[1]);

            //이동+바구니+1
            int size = nowCloud.size();
            for(int j=0;j<size;j++){
                int[] now = nowCloud.get(0);
                if(cloud[now[0]][now[1]]!=2){
                    cloud[now[0]][now[1]]=0;
                }
                nowCloud.remove(0);
                //System.out.print("origin "+now[0]+" "+now[1]+", ");
                int moveR = (now[0]+dr[d-1]*s);
                int moveC = (now[1]+dc[d-1]*s);
                if(moveR>N){
                    moveR=moveR%(N);
                }
                while(moveR<1){
                    moveR=N+moveR;
                }
                if(moveC>N){
                    moveC=moveC%(N);
                }
                while(moveC<1){
                    moveC=N+moveC;
                }

                //새로운 위치
                cloud[moveR][moveC]=2;
                //바구니+1
                map[moveR][moveC]++;
                //arr 업뎃
                nowCloud.add(new int[]{moveR,moveC});
                //System.out.print("!! "+moveR+" "+moveC+", ");
            }

//            for(int j=0;j<size;j++){
//                nowCloud.remove(j);
//            }

            //디버그 : nowCloud
//            for(int[]pr : nowCloud){
//                System.out.print(pr[0]+" "+pr[1]+", ");
//            }
//            System.out.println();

            //물 복사 확인
            for(int j=0;j<nowCloud.size();j++){
                int[] now = nowCloud.get(j);
                int cnt = 0;
                for(int a=1;a<=7;a+=2){
                    int chR = now[0]+dr[a];
                    int chC = now[1]+dc[a];
                    if(chR>=1&&chR<=N && chC>=1&&chC<=N && map[chR][chC]>0){
                        cnt++;
                    }
                }
                map[now[0]][now[1]]+=cnt;
            }


            //새로운 구름 설정
            for(int j=1;j<=N;j++){
                for(int l=1;l<=N;l++){
                    if(map[j][l]>=2 && cloud[j][l]==0){
                        cloud[j][l]=1;
                        map[j][l]-=2;
                    }
                }
            }
            //기존 구름 삭제
            for(int j=0;j<nowCloud.size();j++){
                int[]now = nowCloud.get(j);
                cloud[now[0]][now[1]]=0;
            }
            nowCloud.clear();
            for(int j=1;j<=N;j++){
                for(int l=1;l<=N;l++){
                    if(cloud[j][l]==1){
                        int[] putt = new int[2];
                        putt[0]=j;
                        putt[1]=l;
                        nowCloud.add(putt);

                        //System.out.print(j+" "+l+", ");
                    }
                }
            }
//            System.out.println();
//
//            for(int n=1;n<=N;n++){
//                for(int m=1;m<=N;m++){
//                    System.out.print(map[n][m]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }
        int sum=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                sum+=map[i][j];
            }
        }
        System.out.println(sum);
    }
}