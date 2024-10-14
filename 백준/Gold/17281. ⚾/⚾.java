import java.io.*;

public class Main {
    public static int[][] power;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);

        power = new int[N][9];
        for(int i=0;i<N;i++){
            String[] put = br.readLine().split(" ");
            for(int j=0;j<9;j++){
                power[i][j]=Integer.parseInt(put[j]);
            }
        }

        DFS(0);


        System.out.println(max);

    }
    public static int ans;
    public static int max = 0;
    public static int start;


//    public static void calScore(int[] order, int[][]power, int N){
//
//        for(int i=0;i<N;i++){
//            Deque<Integer> dq = new LinkedList<>();
//            dq.addLast(0);
//            dq.addLast(0);
//            dq.addLast(0);
//
//            int out=0;
//
//            int ind = start;
//            while(out<3){
//                ind = ind%9;
//                int s = power[i][order[ind]];
//                if(s==0){
//                    out++;
//                }
//                else{
//                    if(dq.pollFirst()==1) ans++;
//                    dq.addLast(1);
//                    s--;
//                    for(int l=0;l<s;l++){
//                        if(dq.pollFirst()==1) ans++;
//                        dq.addLast(0);
//                    }
//                }
//                ind++;
//            }
//            //System.out.print("Now End: "+ind+" ");
//            start = ind;
//            //System.out.println("Next Start: "+start);
//        }
//    }
public static void calScore(int[] order, int[][] power, int N) {
    for (int i = 0; i < N; i++) {
        int[] base = new int[3];
        int out = 0;
        int ind = start;

        while (out < 3) {
            ind = ind % 9;
            int s = power[i][order[ind]];

            if (s == 0) {
                out++;
            } else {
                int one = base[0];
                int two = base[1];
                int thi = base[2];
                ans+=thi;
                base[2] = two;
                base[1] = one;
                base[0] = 1;

                for (int j = 0; j < s - 1; j++) {
                    one = base[0];
                    two = base[1];
                    thi = base[2];
                    ans += thi;
                    base[2] = two;
                    base[1] = one;
                    base[0]=0;
                }
            }
            ind++;
        }
        start = ind; // 다음 시작 인덱스 업데이트
    }
}




    public static int[] visited = new int[9];
    public static int[] put = new int[9];
    public static void DFS(int dep){
        if(dep==9){
            if (put[3] == 0) {
                start=0;
                ans=0;
                calScore(put,power, N);
                if(max<ans)max=ans;
            }
            return;
        }
        if(dep==3){
            visited[0]=1;
            put[dep]=0;
            DFS(dep+1);
        }
        for(int i=1;i<9;i++){
            if(visited[i]==1) continue;
            visited[i]=1;
            put[dep]=i;
            DFS(dep+1);
            visited[i]=0;
        }
    }
}
