import java.util.*;
import java.io.*;

public class Main {
    public static int[] people;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visited, visited2;
    public static int N, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N];

        total = 0;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(input[i]);
            total += people[i];
        }

        visited = new int[N];
        visited2 = new int[N];
        for (int i = 0; i < N; i++) {
            String[] put = br.readLine().split(" ");
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 1; j <= Integer.parseInt(put[0]); j++) {
                arr.add(Integer.parseInt(put[j]) - 1);
            }
            graph.add(arr);
        }

        for (int len = 1; len <= N / 2; len++) {
            visited2 = new int[N];
            ArrayList<Integer> nowG1 = new ArrayList<>();
            dfs(0, len, nowG1);
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    public static void dfs(int dep, int tar, ArrayList<Integer> nowG1){
        if(dep==tar){
            ArrayList<Integer> nowG2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!nowG1.contains(i)) {
                    nowG2.add(i);
                    visited[i]=5;
                }
                else{
                    visited[i]=4;
                }
            }


            L = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]==4){
                    L++;
                    bfs(i,4);
                }
            }
            if (L >1) {
                return;
            }

            L = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]==5){
                    L++;
                    bfs(i,5);
                }
            }
            if (L > 1) {
                return;
            }

            int com = 0;
            for (int i = 0; i < nowG1.size(); i++) {
                com += people[nowG1.get(i)];
            }
            int ccom = total-com;
            if(min>Math.abs(com-ccom)){
                min = Math.abs(com-ccom);
            }

            return;
        }
        for(int i=0;i<N;i++){
            if(visited2[i]==1) continue;
            visited2[i]=1;
            nowG1.add(i);
            dfs(dep+1,tar,nowG1);
            nowG1.remove(nowG1.size()-1);
            visited2[i]=0;
        }
    }

    public static int min = Integer.MAX_VALUE;
    public static int L = 0;

    public static void bfs(int start,int type) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int link = graph.get(now).get(i);
                if (visited[link] ==type){
                    visited[link] = 1;
                    que.offer(link);
                }
            }
        }
    }

}
