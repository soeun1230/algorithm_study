import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static Queue<Integer>t1;
    public static int[][] c;
    public static Queue<Integer>[] t;
    public static int[]c1;
    public static Queue<Integer>t2;
    public static int[]c2;
    public static Queue<Integer>t3;
    public static int[]c3;
    public static Queue<Integer>t4;
    public static int[]c4;
    public static int[] moved = {0,0,0,0};
    public static int[][] check = {{6,2},{6,2},{6,2},{6,2}}; //idx 저장
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t1 = new LinkedList<>();
        c1 = new int[8];
        t2 = new LinkedList<>();
        c2 = new int[8];
        t3 = new LinkedList<>();
        c3 = new int[8];
        t4 = new LinkedList<>();
        c4 = new int[8];
        c=new int[4][8];
        t=new Queue[4];

        for(int i=0;i<4;i++){
            String input = br.readLine();
            for(int j=0;j<8;j++){
                String now = Character.toString(input.charAt(j));
                if(i==0){
                    t1.offer(Integer.parseInt(now));
                    c1[j]=Integer.parseInt(now);
                }
                else if(i==1){
                    t2.offer(Integer.parseInt(now));
                    c2[j]=Integer.parseInt(now);
                }
                else if(i==2){
                    t3.offer(Integer.parseInt(now));
                    c3[j]=Integer.parseInt(now);
                }
                else {
                    t4.offer(Integer.parseInt(now));
                    c4[j]=Integer.parseInt(now);
                }
            }
        }
        c[0]=c1;
        c[1]=c2;
        c[2]=c3;
        c[3]=c4;
        t[0]=t1;
        t[1]=t2;
        t[2]=t3;
        t[3]=t4;

        int num=0;
        int p=0;
        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            String[] in = br.readLine().split(" ");
            for(int j=0;j<2;j++){
                num = Integer.parseInt(in[0]);
                p = Integer.parseInt(in[1]);
            }
            setRound(num-1, p);
            for(int m=0;m<4;m++){
                moved[m]=0;
            }
        }


        int sum=0;
        for(int i=0;i<4;i++){
            if(i==0){
                if(t[i].poll()==1) sum+=1;
            }
            else if(i==1){
                if(t[i].poll()==1) sum+=2;
            }
            else if(i==2){
                if(t[i].poll()==1) sum+=4;
            }
            else if(i==3) {
                if(t[i].poll()==1) sum+=8;
            }
        }
        System.out.println(sum);
    }
    public static void setRound(int num, int p){
        int curL = c[num][check[num][0]];
        int curR = c[num][check[num][1]];

        for(int i=num;i<3;i++){
            int nextL = c[i+1][check[i+1][0]];
            if(curR!=nextL){
                moved[i]=1;
                moved[i+1]=1;
            }
            else{
                break;
            }
            curR=c[i+1][check[i+1][1]];
        }
        for(int i=num;i>0;i--){
            int beforeR = c[i-1][check[i-1][1]];
            if(curL!=beforeR){
                moved[i]=1;
                moved[i-1]=1;
            }
            else{
                break;
            }
            curL=c[i-1][check[i-1][0]];
        }
        
        spin(num,p);

        for(int i=num+1;i<4;i++){
            if(moved[i]==1){
                if((i-num)%2==1){
                    spin(i,p*(-1));
                }
                else{
                    spin(i,p);
                }
            }
            else{
                break;
            }
        }
        for(int i=num-1;i>=0;i--){
            if(moved[i]==1){
                if((num-i)%2==1){
                    spin(i,p*(-1));
                }
                else{
                    spin(i,p);
                }
            }
            else{
                break;
            }
        }
    }
    public static void spin(int n,int p){
        if(p==1){
            for(int i=0;i<7;i++){
                int k = t[n].poll();
                t[n].offer(k);
            }
            check[n][0]-=1;
            if(check[n][0]==-1){
                check[n][0]=7;
            }
            check[n][1]-=1;
            if(check[n][1]==-1){
                check[n][1]=7;
            }
        }
        else{
            int k=t[n].poll();
            t[n].offer(k);
            check[n][0]+=1;
            if(check[n][0]==8){
                check[n][0]=0;
            }
            check[n][1]+=1;
            if(check[n][1]==8){
                check[n][1]=0;
            }
        }
    }
}