import java.util.*;

class Solution {
    public int[] visited;
    public int n;
    public int cnt=1;
    public int max=0;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new int[n];
        dfs(dungeons,k,0);
        
        return max;
    }
    public void dfs(int[][] dun, int cur,int cnt){
        if(cnt>max){
            max=cnt;
        }
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(cur>=dun[i][0]){
                    visited[i]=1;
                    dfs(dun,cur-dun[i][1],cnt+1);
                    visited[i]=0;
                }
            }
        }
    }
}