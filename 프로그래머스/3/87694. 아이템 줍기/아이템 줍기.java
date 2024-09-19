import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[][] map;
    public int n;
    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,1,-1};
    public int[][] visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        n = rectangle.length;
        map = new int[102][102];
        visited = new int[102][102];
        
        for(int[]rect : rectangle){
            int x1 = rect[0]*2;
            int y1 = rect[1]*2;
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;
            
            for(int x=x1;x<=x2;x++){
                if(map[y1][x]!=2) map[y1][x]=1;
                if(map[y2][x]!=2) map[y2][x]=1;
            }
            for(int y=y1;y<y2;y++){
                if(map[y][x1]!=2) map[y][x1]=1;
                if(map[y][x2]!=2) map[y][x2]=1;
            }
            
            for(int i=x1+1;i<x2;i++){
                for(int j=y1+1;j<y2;j++){
                    map[j][i]=2;
                }
            }
        }
        
        
        return bfs(characterX*2, characterY*2, itemX*2,itemY*2)/2;
    }
    public int bfs(int sx, int sy, int endx, int endy){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sx,sy});
        visited[sy][sx]=1;
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            
            if(x==endx && y==endy){
                return visited[endy][endx];
            }
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx>=1 && nx<=102 && ny>=1 && ny<=102 && map[ny][nx]==1){
                    if(visited[ny][nx]==0){
                        visited[ny][nx]=visited[y][x]+1;
                        que.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return -1;
    }
}