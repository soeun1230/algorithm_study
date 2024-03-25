import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[][]visited;
    public int[][]Maps;
    public int xl;
    public int yl;
    public int[] dx={0,0,1,-1};
    public int[] dy={1,-1,0,0};
    public int[] solution(String[] maps) {
        int land=0;
        xl=maps[0].length();
        yl=maps.length;
        Maps = new int[yl][xl];
        visited = new int[yl][xl];
        
        for(int i=0;i<yl;i++){
            String cur = maps[i];
            for(int j=0;j<xl;j++){
                if(cur.charAt(j)=='X'){
                    Maps[i][j]=0;
                }
                else{
                    String n = Character.toString(cur.charAt(j));
                    Maps[i][j]=Integer.parseInt(n);
                    land++;
                }
            }
        }
        if(land==0){
            int[] a = {-1};
            return a;
        }
     
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<yl;i++){
            for(int j=0;j<xl;j++){
                if(visited[i][j]==1)continue;
                if(Maps[i][j]!=0){
                    int l =bfs(j,i);
                    ans.add(l);
                }
            }
        }    
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    public int bfs(int startx,int starty){
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(startx,starty,Maps[starty][startx]);
        queue.offer(node);
        visited[starty][startx]=1;
        
        int sum=0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            sum+=cur.l;
            
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx>=0&&ny>=0&&nx<xl&&ny<yl){
                    if(visited[ny][nx]==1) continue;
                   
                    if(Maps[ny][nx]!=0){
                        visited[ny][nx]=1;
                        Node node1 = new Node(nx,ny,Maps[ny][nx]);
                        queue.offer(node1);
                    }
                }
            }
        }
        return sum;
    }
    public class Node{
        int x;
        int y;
        int l;
        public Node(int x, int y,int l){
            this.x=x;
            this.y=y;
            this.l=l;
        }
    }
}