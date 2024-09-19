import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int[] visited;
    public int nat=0;
    
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                nat++;
                bfs(computers,i,n);
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(visited[i]+" ");
        }
        
        return nat;
    }
    
    public void bfs(int[][]com,int start, int n){
        Queue<Integer>que = new LinkedList<>();
        que.offer(start);
        visited[start]=nat;
        
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i=0;i<n;i++){
                if(com[now][i]==1){
                    if(visited[i]==0){
                        visited[i]=visited[now];
                        que.offer(i);
                    }
                }
                
            }
        }
 
    }
}