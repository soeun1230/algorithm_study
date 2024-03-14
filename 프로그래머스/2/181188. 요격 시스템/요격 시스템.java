import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int size;
    public int[] visited;
    public int solution(int[][] targets) {
        int answer = 0;
        int start=targets[0][0];
        int end=targets[0][1];
        size = targets.length;
        
        visited = new int[size];
       
        Arrays.sort(targets,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1]-o1[1];
            }
        });
        
        for(int i=0;i<size;i++){
            if(visited[i]==1)continue;
            
            int curFirst = targets[i][0];
            answer++;
          
            visited[i]=1;
            int now = findLines(curFirst,i,targets);
            
            i=now-1;
            
        }
        
        // for(int[] n:targets){
        //     System.out.print(n[0]+" ");
        //     System.out.println(n[1]);
        // }
        
        return answer;
    }
    public int findLines(int curFirst, int now, int[][]targets){
        for(int i=now+1;i<size;i++){
            int curCh = targets[i][1];
            //System.out.println(curCh);
            if(curCh>curFirst){
                visited[i]=1;
                curFirst=Math.max(curFirst,targets[i][0]);
            }
            else{
                return i;
            }
        }
        return size;
    }
}