import java.util.*;

class Solution {
    public int[] visited;
    public int cnt=0;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                bfs(i,computers);
                cnt++;
            }
        }
        
        
        return cnt;
    }
    public void bfs(int s, int[][] com){
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        visited[s]=1;
        
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i=0;i<com.length;i++){
                if(visited[i]==0){
                    if(com[i][now]==1){
                        visited[i]=1;
                        que.offer(i);
                    }
                }
            }
        }
    }
}