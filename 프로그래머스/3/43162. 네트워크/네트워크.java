import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] visited;
    public int answer=0;
    
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                answer++;
                bfs(i,computers,n);
            }
        }
        
        return answer;
    }
    public void bfs(int idx, int[][]com, int n){
        Queue<Integer> que = new LinkedList<>();
        que.offer(idx);
        visited[idx]=1;
        
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i=0;i<n;i++){
                if(com[now][i]==1 && visited[i]==0){
                    visited[i]=1;
                    que.offer(i);
                }
            }
        }
        
    }
}