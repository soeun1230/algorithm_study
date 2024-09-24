import java.util.*;

class Solution {
    public int[][] visited;
    public int[][] map;
    public int n,m;
    public int[] dx ={0,0,-1,1};
    public int[] dy ={1,-1,0,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        int answer = 0;
        n=rectangle[0].length;
        m=rectangle.length;
        
        map= new int[102][102];
        visited = new int[102][102];
        
        for(int i=0;i<m;i++){
            int[] now = rectangle[i];
            int x1 = now[0]*2;
            int y1 = now[1]*2;
            int x2 = now[2]*2;
            int y2 = now[3]*2;
            
            for(int x=x1;x<=x2;x++){
                if(map[y1][x]!=2) map[y1][x]=1;
                if(map[y2][x]!=2) map[y2][x]=1;
            }
            for(int y=y1;y<=y2;y++){
                if(map[y][x1]!=2) map[y][x1]=1;
                if(map[y][x2]!=2) map[y][x2]=1;
            }
            for(int x=x1+1;x<x2;x++){
                for(int y=y1+1;y<y2;y++){
                    map[y][x]=2;
                }
            }
        }
        
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;
        
        return answer;
    }
    public int bfs(int sx, int sy, int tx, int ty){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sx,sy});
        visited[sy][sx]=1;
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            
            if(x==tx && y==ty){
                return visited[y][x];
            }
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=1 && nx<=map[0].length &&  ny>=1 && ny<=map.length && map[ny][nx]==1){
                    if(visited[ny][nx]==0){
                        visited[ny][nx]=visited[y][x]+1;
                        que.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return 0;
    }
}