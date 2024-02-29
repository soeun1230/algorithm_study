import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[]args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> que = new LinkedList<>();

        for(int i=1;i<=n;i++){
            que.add(i);
        }

        while(que.size()>1){
            que.poll();
            int back=que.poll();
            que.add(back);
        }
        System.out.println(que.poll());

    }
}