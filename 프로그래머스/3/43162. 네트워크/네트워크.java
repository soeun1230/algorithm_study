import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] visited;
    public int[][] com;
    public int network=0;
    
    public int solution(int n, int[][] computers) {
        com = computers;
        visited= new int[n];
        
    
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,n);
                network++;
            }
        }
        
        return network;
    }
    
    public void dfs(int cur, int n){
        visited[cur]=1;
        for(int i=0;i<n;i++){
            if(com[cur][i]==1 && visited[i]==0){
                dfs(i,n);
            }
        }
    }
}