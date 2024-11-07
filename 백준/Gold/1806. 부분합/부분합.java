import java.io.*;
import java.lang.*;

public class Main {
    public static int N;
    public static long S;
    public static int[] arr;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //test();
        String[] put = br.readLine().split(" ");
        N = Integer.parseInt(put[0]);
        S = Long.parseLong(put[1]);
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        long[] cost = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            cost[i] = cost[i - 1] + arr[i - 1];
        }

        if(cost[N]<S){
            System.out.println(0);
            return;
        }
        
        int[] result = new int[N+1];

        int right_in = 1;
        for(int i=1;i<=N;i++){
            for(int j=right_in;j<=N;j++){
                if(cost[j]-cost[i-1]>=S){
                    result[i]=j-i+1;
                    right_in=j;
                    break;
                }
            }
        }

        for(int i=0;i<=N;i++){
            //System.out.print(result[i]);
            if(result[i]==0) continue;
            if(min>result[i]) min=result[i];
        }
        //System.out.println();


        if(min==Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }

        System.out.print(min);
    }
//    public static void test(){
//        Random random = new Random();
//        N = 100000;
//        S = 1000000000;
//        arr = new long[N];
//        for(int i=0;i<N;i++){
//            arr[i]=(long)(random.nextDouble() * 100000);
//            //System.out.print(arr[i]+" ");
//        }
//    }
}