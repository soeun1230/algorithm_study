import java.util.*;

class Solution {
    public int[][] visited;
    public int[][] map;
    public int[] dx = {0,0,1,-1};
    public int[] dy = {1,-1,0,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        visited = new int[102][102];
        
        int n = rectangle.length;
        
        for(int i=0;i<n;i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int x=x1;x<=x2;x++){
                if(map[x][y1]!=1){
                    map[x][y1]=2;
                }
                if(map[x][y2]!=1){
                    map[x][y2]=2;
                }
            }
            for(int y=y1;y<=y2;y++){
                if(map[x1][y]!=1){
                    map[x1][y]=2;
                }
                if(map[x2][y]!=1){
                    map[x2][y]=2;
                }
            }
            
            for(int x=x1+1;x<x2;x++){
                for(int y=y1+1;y<y2;y++){
                    map[x][y]=1;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int ch =bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        if(min>ch) min = ch;
        return min/2;
    }
    public int bfs(int sx,int sy, int ex, int ey){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sx,sy});
        visited[sx][sy]=1;
        
        while(!que.isEmpty()){
            int[] now =que.poll();
            int x = now[0];
            int y = now[1];
            if(x==ex && y==ey) return visited[x][y];
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>0 && nx<102 &&ny>0&&ny<102 && visited[nx][ny]==0 && map[nx][ny]==2){
                    visited[nx][ny]=visited[x][y]+1;
                    que.offer(new int[]{nx,ny});
                }
            }
        }
        return 0;
    }
}