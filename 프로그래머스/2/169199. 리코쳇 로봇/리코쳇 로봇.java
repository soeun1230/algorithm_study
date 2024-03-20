import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] dx={0,0,-1,1};
    public int[] dy={-1,1,0,0};
    public int[][] visited;
    public int answer = 10000000;
    //public int sum=0;
    public int xl;
    public int yl;
    public int[][]Board;
    
    public int solution(String[] board) {
        xl = board[0].length();
        yl = board.length;
        
        Board = new int[yl][xl];
        visited = new int[yl][xl];
        
        int startx=0;
        int starty=0;
        for(int i=0;i<yl;i++){
            for(int j=0;j<xl;j++){
                if(board[i].charAt(j)=='D'){
                    Board[i][j]=1;
                }
                else if(board[i].charAt(j)=='G'){
                    Board[i][j]=2;
                }
                else if(board[i].charAt(j)=='R'){
                    startx=j;
                    starty=i;
                }
            }
        }
        visited[starty][startx]=1;
        
        Queue<Node>que = new LinkedList<>();
        que.offer(new Node(startx,starty,0));
        
        while(!que.isEmpty()){
            Node cur = que.poll();
            int curs = cur.count;
            int curx = cur.x;
            int cury = cur.y;
            
            if(answer<=curs) continue;
            if(Board[cury][curx]==2){
                answer=Math.min(answer,curs);
                continue;
            }

            for(int i=0;i<4;i++){
                int nx=curx+dx[i];
                int ny=cury+dy[i];
                
                if(nx<0 || nx>=xl || ny<0 || ny>=yl){
                    continue;
                }
                if(Board[ny][nx]==1) {
                    continue;
                }
                
                while(nx>=0 && ny>=0 && nx<xl && ny<yl && Board[ny][nx]!=1){
                    nx+=dx[i];
                    ny+=dy[i];
                }
                
                nx-=dx[i];
                ny-=dy[i];
                if(visited[ny][nx]==1){
                    continue;
                } 
                
                visited[ny][nx]=1;
                
                
                
                que.offer(new Node(nx,ny,cur.count+1));
            }
        }
        
        
        if(answer==10000000){
            answer=-1;
        }
        return answer;
    }
    class Node{
        int x;
        int y;
        int count;
        public Node(int x,int y, int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
}