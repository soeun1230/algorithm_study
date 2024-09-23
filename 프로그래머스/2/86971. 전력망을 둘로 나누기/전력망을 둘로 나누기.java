import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public int[] visited;
    public int count;
    public int solution(int n, int[][] wires) {
        
        int min=100;
        for(int i=0;i<wires.length;i++){
            visited = new int[n];
            ArrayList<ArrayList<Integer>> graph = makeGraph(n,i,wires);
            count=0;
            int nodes = bfs(graph,0);
            int diff = Math.abs(nodes-(n-nodes));
            if(min>diff)min=diff;
        }
        
        return min;
    }
    public ArrayList<ArrayList<Integer>> makeGraph(int n,int skip, int[][]wir){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> ar = new ArrayList<>();
            arr.add(ar);
        }
        
        for(int i=0;i<wir.length;i++){
            if(i==skip) continue;
            int u = wir[i][0]-1;
            int v = wir[i][1]-1;
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        return arr;
    }
    public int bfs(ArrayList<ArrayList<Integer>> gr,int s){
        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        visited[s]=1;
        count=1;
        
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i=0;i<gr.get(now).size();i++){
                int ch = gr.get(now).get(i);
                if(visited[ch]==0){
                    count++;
                    visited[ch]=1;
                    que.offer(ch);
                }
            }
        }
        return count;
    }
}