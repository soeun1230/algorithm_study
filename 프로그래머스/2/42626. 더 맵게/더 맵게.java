import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    
        int n= scoville.length;
        
        for(int i=0;i<n;i++){
            pq.add(scoville[i]);
        }
        int cnt =0;
        while(!pq.isEmpty()){
            int fir = pq.poll();
            if(fir>=K){
                return cnt;
            }
            else{
                if(pq.isEmpty()) break;
                int sec = pq.poll();
                int newK = fir+sec*2;
                cnt++;
                pq.add(newK);
            }
        }
        
        return -1;
    }
}