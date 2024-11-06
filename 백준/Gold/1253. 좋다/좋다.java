import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int N;
    public static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        test();
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(input[i]);
        }

        int cnt =0;

        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            long target = arr[i];
            int st = 0;
            int en = N-1;

            while(st<en){
                if(st==i) st++;
                if(en==i) en--;

                if(st>=en) break;
                if(arr[st]+arr[en]==target) {
                    cnt++;
                    break;
                }
                else if(arr[st]+arr[en]<target){
                    st++;
                }
                else{
                    en--;
                }
            }

        }

        System.out.println(cnt);
    }
    public static void test(){
        Random random = new Random();
        N = 2000;
        arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i]=(long)(random.nextDouble() * 1000000000);
            //System.out.print(arr[i]+" ");
        }
    }
}
