import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int[][]map;
    public static int[]head ={1,1}; //map 1~N까지임
    public static Queue<int[]> que;
    public static int[]tail={1,1};
    public static int[][]apple;
    public static int[][]way ={{0,-1},{1,0},{0,1},{-1,0}}; //N E S W {x,y}이동 값
    public static int N, A, L;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2];
        apple = new int[N+2][N+2];
        A = Integer.parseInt(br.readLine());
        for(int i=0;i<A;i++){
            String[] input = br.readLine().split(" ");
            apple[Integer.parseInt(input[0])][Integer.parseInt(input[1])]=1;
        }

        L = Integer.parseInt(br.readLine());
        HashMap<Integer,String> hm = new HashMap<>();
        for(int i=0;i<L;i++){
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            String w = input[1];
            hm.put(time,w);
        }

        int ini = 0;
        int direction = 1;
        map[1][1]=2;
        que =new LinkedList<>();
        que.offer(head.clone());
        tail = que.poll().clone();
        while(true){

            if(hm.containsKey(ini)){
                if(hm.get(ini).equals("L")){
                    direction--;
                    if(direction==-1){
                        direction=3;
                    }
                }
                else{
                    direction++;
                    if(direction==4) direction=0;
                }
            }
            //System.out.println(ini+" "+direction);
            if(moveSnake(direction)){
                ini++;
            }
            else{
                System.out.println(ini+1);
                break;
            }
        }
    }
    public static boolean moveSnake(int d){
        int nr = head[0]+way[d][1];
        int nc = head[1]+way[d][0];
        if(nr>N || nr<1 || nc>N || nc<1) return false;
        if(map[nr][nc]==2) return false;

        if(apple[nr][nc]==1){
            apple[nr][nc]=0;
            map[nr][nc]=2;
            head[0]=nr;
            head[1]=nc;
            que.offer(head.clone());
            return true;
        }

        map[tail[0]][tail[1]]=0;
        map[nr][nc]=2;
        head[0]=nr;
        head[1]=nc;
        que.offer(head.clone());
        tail=que.poll().clone();

//        System.out.println("head "+head[0]+" "+head[1]);
//        System.out.println("tail "+tail[0]+" "+tail[1]);
        return true;
    }
}