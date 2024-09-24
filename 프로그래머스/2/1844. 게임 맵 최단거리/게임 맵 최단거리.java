import java.util.*;

class Solution {
    public int[][]visited;
    public int[] dx = {0,0,-1,1};
    public int[] dy = {1,-1,0,0};
    public int n,m;
    public int solution(int[][] maps) {
        n = maps[0].length;
        m = maps.length;
        visited = new int[m][n];
        int answer = bfs(maps);
        
        return answer;
    }
    public int bfs(int[][]map){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        visited[0][0]=1;
        int cnt=1;
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            if(x==n-1 && y==m-1){
                return visited[y][x];
            }
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[ny][nx]==1){
                    if(visited[ny][nx]==0){
                        visited[ny][nx]=visited[y][x]+1;
                        que.offer(new int[] {nx,ny});
                        cnt++;
                    }
                }
            }
        }
        return -1;
    }
}