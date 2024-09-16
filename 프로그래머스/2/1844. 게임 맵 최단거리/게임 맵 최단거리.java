import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public int n, m;
    public int[][] map;
    public int[][] checked;

    
    public int solution(int[][] maps) {
        n = maps[0].length;
        m = maps.length;

        map = maps;
        checked = new int[m][n];
    
        
        int ans =bfs();
        
        return ans;
        
    }
    public int validCheck(int nx, int ny){
        if(nx<0 || nx>=n || ny<0 || ny>=m){
            return -1;
        }
        else{
            if(map[ny][nx]==0){
                return -1;
            }
        }
        return 1;
    }
    
    public int bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0,0});
        checked[0][0]=1;
        
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            int x=now[0];
            int y =now[1];
            
            if(x==n-1 && y==m-1){
                return checked[y][x];
            }
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(validCheck(nx,ny)==1 && checked[ny][nx]==0){
                    que.offer(new int[] {nx,ny});
                    checked[ny][nx]=checked[y][x]+1;
                }
            }
            
        }
        
        return -1;
        
        
    }
}