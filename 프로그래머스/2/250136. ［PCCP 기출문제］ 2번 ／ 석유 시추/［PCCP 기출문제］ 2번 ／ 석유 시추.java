import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int answer = 0;
    public int N,M;
    public int[][] visited;
    public int[] dx = {0,1,0,-1};
    public int[] dy = {1,0,-1,0};
    public int nowAns=0;
    public int[][] Land;
    public int cur = 0;
    public int[] key;
    
    public int solution(int[][] land) {
        Land = land;
        N = land.length;
        M = land[0].length;
        visited = new int[N][M];
        
        key = new int[M*N+1];
        
        
        int k = 1;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(visited[j][i]>=1) continue;
                if(land[j][i]==1){
                    findFuel(i,j,k);
                    key[k]=nowAns;
                    k++;
                    nowAns=0;
                }       
            }
        }
        
        
        TreeSet<Integer> ts = new TreeSet<>();

        for(int i=0;i<M;i++){
            ts.add(0);
            for(int j=0;j<N;j++){
                int curKey = visited[j][i];

                if(curKey>=1 && !ts.contains(curKey)) {
                    cur += key[curKey];
                    ts.add(curKey);
                }

            }
            answer=Math.max(answer,cur);
            cur=0;
            ts.clear();
        }
        
        return answer;
    }
    
    public void findFuel(int x, int y, int key){
        if(Land[y][x]==1 && visited[y][x]!=key){
            nowAns++;
            visited[y][x]=key;
            
            for(int i=0;i<4;i++){
                int nx = dx[i]+x;
                int ny = dy[i]+y;
                
                if(valid(nx,ny)&& visited[ny][nx]!=key){
                    if(Land[ny][nx]==0) continue;
                    findFuel(nx,ny,key);
                }
            }
            return;
        }
        return;
    }
    public boolean valid(int x,int y){
        if(x>=0 && x<M && y>=0 && y<N){
            return true;
        }
        return false;
    }
}