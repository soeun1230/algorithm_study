import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int[]leftDel;
    public int[]leftPick;
    public long distance=0;
    public int N;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        leftDel=deliveries;
        leftPick=pickups;
        
        int i=n-1;
        while(i>=0){
        // for(int i=n-1;i>=0;i--){
            int left = cap;
            int take = 0;
            
            // System.out.print(i+" : ");
            // System.out.print(leftDel[i]+" ");
            // System.out.println(leftPick[i]);
            
            if(leftDel[i]==0 && leftPick[i]==0){
                i--;
                continue;
            }
            distance+=(i+1)*2;
            
            int ch=i;
            while(left>0){
                if(ch<0) break;
                int cur = leftDel[ch];
                if(cur>=left){
                    cur=cur-left;
                    left=0;
                    leftDel[ch]=cur;
                    break;
                }
                else{
                    left=left-cur;
                    cur=0;
                    leftDel[ch]=cur;
                    ch--;
                }
            }
            int ch2=i;
            while(take<cap){
                if(ch2<0) break;
                int cur = leftPick[ch2];
                int canTake = cap-take;
                if(cur>=canTake){
                    cur=cur-canTake;
                    leftPick[ch2]=cur;
                    take=cap;
                    break;
                }
                else{
                    take+=cur;
                    cur=0;
                    leftPick[ch2]=cur;
                    ch2--;
                }
            }
            // System.out.print(i+" : ");
            // System.out.print(leftDel[i]+" ");
            // System.out.println(leftPick[i]);
        }
        
        answer=distance;
        return answer;
    }
   
}