import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int answer = Integer.MAX_VALUE;
    public int[]visited;
    public int solution(int x, int y, int n) {
        visited = new int[y+1];
        bfs(x,y,n);
        
        if(answer==Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }
    public void bfs(int x, int y, int n){
        Node node = new Node(x,0);
        visited[x]=1;
        Queue<Node>que = new LinkedList<>();
        que.offer(node);
        
        while(!que.isEmpty()){
            Node cur = que.poll();

            if(cur.s>=answer) continue;
            if(cur.x==y){
                answer = Math.min(cur.s,answer);
            }
            if(cur.x>y) continue;

            int now = cur.x;
            
            if(now+n<=y && visited[now+n]!=1){
                node = new Node(now+n,cur.s+1);
                que.offer(node);
                visited[now+n]=1;
            }
            if(now*2<=y && visited[now*2]!=1){
                node = new Node(now*2,cur.s+1);
                que.offer(node);
                visited[now*2]=1;
            }
            if(now*3<=y && visited[now*3]!=1){
                node = new Node(now*3,cur.s+1);
                que.offer(node);
                visited[now*3]=1;
            }
            
        }
    }
    public class Node{
        int x;
        int s;
        public Node(int x, int s){
            this.x=x;
            this.s=s;
        }
    }
}