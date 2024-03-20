import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[]dx={0,0,-1,1};
    public int[]dy={-1,1,0,0};
    public int solution(String[] maps) {
        int answer = Integer.MAX_VALUE;
        int yl=maps.length;
        int xl=maps[0].length();
        
        int[][]Maps = new int[yl][xl];
        int stx=0;
        int sty=0;
        int[][]visited = new int[yl][xl];
        
        for(int i=0;i<yl;i++){
            for(int j=0;j<xl;j++){
                if(maps[i].charAt(j)=='S'){
                    Maps[i][j]=4;
                    stx=j;
                    sty=i;
                }
                else if(maps[i].charAt(j)=='X'){
                    Maps[i][j]=1;
                }
                else if(maps[i].charAt(j)=='L'){
                    Maps[i][j]=2;
                }
                else if(maps[i].charAt(j)=='E'){
                    Maps[i][j]=3;
                }
            }
        }
        
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(stx,sty,0));
        visited[sty][stx]=1;
        
        int label=Integer.MAX_VALUE;
        int lbx=0;
        int lby=0;
        
        while(!que.isEmpty()){
            Node cur = que.poll();
            if(Maps[cur.y][cur.x]==2){
                label = Math.min(label,cur.time);
                lbx=cur.x;
                lby=cur.y;
            }
            if(cur.time>=label) continue;
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx>=0&&ny>=0&&nx<xl&&ny<yl){
                    if(Maps[ny][nx]==1)continue;
                    if(visited[ny][nx]==1) continue;
                    visited[ny][nx]=1;
                    que.offer(new Node(nx,ny,cur.time+1));
                }
                
            }
        }
        if(label==Integer.MAX_VALUE){
            return -1;
        }
        
        visited[lby][lbx]=2;
        que.offer(new Node(lbx,lby,label));
        while(!que.isEmpty()){
            Node cur = que.poll();
            if(Maps[cur.y][cur.x]==3){
                answer = Math.min(answer,cur.time);
            }
            if(cur.time>=answer) continue;
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx>=0&&ny>=0&&nx<xl&&ny<yl){
                    if(Maps[ny][nx]==1)continue;
                    if(visited[ny][nx]==2) continue;
                    visited[ny][nx]=2;
                    que.offer(new Node(nx,ny,cur.time+1));
                }
                
            }
        }
        if(answer==Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }
}
class Node{
    int x;
    int y;
    int time;
    public Node(int x,int y, int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}