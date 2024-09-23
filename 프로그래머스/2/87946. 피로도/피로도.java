import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int n;
    public int[] visited;
    public int maxDun=0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        back(k,dungeons,0);
        
        return maxDun;
    }
    public void back(int cur, int[][] dun, int count){
        if(count > maxDun){
            maxDun = count;
        }
        for(int i=0;i<dun.length;i++){
            if(visited[i]==0 && cur>=dun[i][0]){
                visited[i]=1;
                back(cur-dun[i][1],dun,count+1);
                visited[i]=0;
            }
        }
    }
}