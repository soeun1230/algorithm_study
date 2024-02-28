import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int newScore = Integer.parseInt(input[1]);
        int P = Integer.parseInt(input[2]);

        if(N==0){
            System.out.println(1);
        }

        else{
            String[] scoreInput = br.readLine().split(" ");
            int[] score = new int[N];
            for(int i=0;i<N;i++){
                score[i]=Integer.parseInt(scoreInput[i]);
            }
            if(N>P){
                score= Arrays.stream(score).sorted().toArray();
                for(int j=0;j<N-P;j++){
                    score[j]=-1;
                }
            }

            int rank = -1;
            int before = -1;
            int beforeIndex = -1;


            int n=0;
            for(int i=1; rank==-1 && i<=N; i++){
                int cur = score[i-1];
                while(cur==-1){
                    n++;
                    cur=score[n];
                }
                if(cur < newScore){
                    if(before==newScore){
                        rank=beforeIndex;
                    }
                    else{
                        rank=i;
                    }
                }
                if(before!=cur){
                    before=cur;
                    beforeIndex=i;
                }
            }
            if(rank==-1 && N+1<=P){
                if(newScore==before){
                    rank=beforeIndex;
                }
                else{
                    rank=N+1;
                }
            }
            if(rank<=P){
                System.out.println(rank);
            }
            else{
                System.out.println(-1);
            }
        }
        br.close();
    }
}