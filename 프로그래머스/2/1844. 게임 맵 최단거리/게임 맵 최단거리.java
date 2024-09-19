import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] dx ={1,-1,0,0};
    public int[] dy ={0,0,1,-1};
    public int n,m;
    public int[][] visited;
    
    public int solution(int[][] maps) {
        n = maps[0].length;
        m = maps.length;
        
        visited = new int[m][n];
        
        return bfs(0,maps);
    }
    public int bfs(int start, int[][]maps){
        Queue<int[]>que = new LinkedList<>();
        que.offer(new int[]{0,0});
        visited[0][0]=1;
        
        while(!que.isEmpty()){        
            int[] now = que.poll();
            int nx = now[0];
            int ny = now[1];
            
            if(nx==n-1 && ny==m-1){
                return visited[ny][nx];
            }
            
            for(int i=0;i<4;i++){
                int x = nx+dx[i];
                int y = ny+dy[i];
                if(x>=0 && x<n && y>=0 && y<m && maps[y][x]==1){
                    if(visited[y][x]==0){
                        que.offer(new int[]{x,y});
                        visited[y][x]=visited[ny][nx]+1;
                    }
                }
            }
            
        }
        return -1;
    }
}