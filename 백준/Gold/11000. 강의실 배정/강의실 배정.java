import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] cl = new long[n][2];

        for(int i=0;i<n;i++){
            cl[i][0]=sc.nextLong();
            cl[i][1]=sc.nextLong();
        }

        Arrays.sort(cl,new Comparator<long[]>(){
            @Override
            public int compare(long[] o1 ,long[] o2){
                return (int) (o1[0]-o2[0]);
            }
        });
        long answer=1;
        int ch = 0;
        long end =0;

        PriorityQueue<Long> que = new PriorityQueue<>();
        que.add(end);
        while(ch<cl.length){
            long[] now = cl[ch];
            long ns = now[0];
            long ne = now[1];


            if(que.peek()<=ns){
                que.poll();
                que.add(ne);
            }
            else{
                que.add(ne);
                answer++;
            }

            ch++;
        }

        System.out.println(answer);

    }
}
