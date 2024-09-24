import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> que = new LinkedList<>();
        int n = priorities.length;
        int cnt=0;
        
        for(int i=0;i<n;i++){
            int[] put = new int[] {priorities[i],i};
            que.offer(put);
        }
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            int size = que.size();
            boolean biggest = true;
            for(int i=0;i<size;i++){
                int[] ch =que.poll();
                if(now[0]<ch[0]){
                    biggest=false;
                }
                que.offer(ch);
            }
            
            if(!biggest){
                que.offer(now);
            }
            else{
                cnt++;
                if(now[1]==location){
                    break;
                }
            }
        }
        
        return cnt;
    }
}