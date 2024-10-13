import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int cnt = 0;

        int[] belt = new int[2*N];
        int[] robot = new int[2*N];

        String[] put = br.readLine().split(" ");
        for(int i=0;i<2*N;i++){
            int now = Integer.parseInt(put[i]);
            belt[i]=now;
        }

        int L =1;
        int nowIn=0;
        int nowOut=N-1;
        Deque<Integer> dq = new LinkedList<>();

        while(cnt<K){
            if(robot[nowOut]==1) {
                robot[nowOut]=0; //내릴거
                dq.remove(nowOut);
            }
            //돌리기
            nowIn--;
            if(nowIn==-1) nowIn=N*2-1;
            nowOut--;
            if(nowOut==-1) nowOut=N*2-1;

            //내리기
            if(robot[nowOut]==1) {
                robot[nowOut]=0; //내릴거
                dq.remove(nowOut);
            }


            int si = dq.size();
            for(int g=0;g<si;g++){
                int nn = dq.pollFirst();
                if(nn==2*N-1){
                    if(robot[nn]==1 && robot[0]==0 && belt[0]>=1){
                        belt[0]--;
                        robot[nn]=0;
                        robot[0]=1;
                        if(nowOut!=0){
                            dq.addLast(0);
                        }
                    }
                    else{
                        dq.addLast(nn);
                    }

                }
                else{
                    if(robot[nn]==1 && robot[nn+1]==0 && belt[nn+1]>=1){
                        belt[nn+1]--;
                        robot[nn]=0;
                        robot[nn+1]=1;
                        if(nowOut!=nn+1) {
                            dq.addLast(nn + 1);
                        }
                    }
                    else{
                        dq.addLast(nn);
                    }
                }
            }


            //올리기
            if(belt[nowIn]>0 && robot[nowIn]==0){
                belt[nowIn]--;
                robot[nowIn]=1;
                dq.addLast(nowIn);
            }

            cnt = zeroCnt(belt);
            if(cnt>=K){
//                System.out.println(nowIn+" "+nowOut);
//                for(int l=0;l<belt.length;l++){
//                    System.out.print(belt[l]+" ");
//                }
//                System.out.println();
//                for(int l=0;l<belt.length;l++){
//                    System.out.print(robot[l]+" ");
//                }
                System.out.println(L);
                return;
            }

            L++;
        }

        System.out.println(L);

    }
    public static int zeroCnt(int[] arr){
        int n = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                n++;
            }
        }
        return n;
    }
}