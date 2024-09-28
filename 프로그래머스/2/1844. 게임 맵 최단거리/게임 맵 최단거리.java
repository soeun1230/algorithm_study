import java.util.*;


class Solution {
    public int[][] visited;
    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};
    public int n,m;
    
    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        visited= new int[n][m];
        return bfs(0,maps);
    }
    public int bfs(int s,int[][]map){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        visited[0][0]=1;
        
        while(!que.isEmpty()){
            int[] now =que.poll();
            int x = now[0];
            int y = now[1];
            if(x==n-1 && y==m-1){
                return visited[x][y];
            }
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0&&nx<n && ny>=0&&ny<m && map[nx][ny]==1 && visited[nx][ny]==0){
                    visited[nx][ny]=visited[x][y]+1;
                    int[] put = {nx,ny};
                    que.offer(put);
                }
            }
        }
        return -1;
    }
}