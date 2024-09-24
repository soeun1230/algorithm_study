import java.util.*;

class Solution {
    public int[] visited;
    public int[] dx = {0,0,-1,1};
    public int[] dy = {1,-1,0,0};
    public int net=0;;
    
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                bfs(i,n,computers);
                net++;
            }
        }
        
        return net;
    }
    public void bfs(int s,int n, int[][]com){
        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        visited[s]=1;
        
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