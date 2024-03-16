import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1,-1};
        int size = sequence.length;
        
        int start =0;
        int end =-1;
        int len =size;
        
        int sum=0;
        while(true){
            if(sum<k){
                end+=1;
                if(end>=size){
                    break;
                }
                sum+=sequence[end];
            }
            else{
                sum-=sequence[start];
                if(start>=size){
                    break;
                }
                start+=1;
            }
            if(sum==k){
                if(end-start<len){
                    answer[0]=start;
                    answer[1]=end;
                    len=end-start;
                }
                else if(end-start==len){
                    if(start<answer[0]){
                        answer[0]=start;
                        answer[1]=end;
                    }
                }
            }
        }

        return answer;
    }
}