import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] sequence, int k) throws IOException{
        
        int left = 0;
        int right = -1;
        int sLeft = 0;
        int sRight =0;
        int length = 1000001;
        
        int sum=0;
        
        while(right<sequence.length && left < sequence.length){            
            if(sum<k){
                right++;
                if(right<sequence.length){
                    sum+=sequence[right];
                }
            }
            else if(sum>k){
                sum-=sequence[left];
                left++;
            }
            else{
                if(right-left<length){
                    length = right-left;
                    sLeft=left;
                    sRight=right;
                }
                sum-=sequence[left++];
            }
            
        }
        return new int[] {sLeft, sRight};
        
    }
    
}