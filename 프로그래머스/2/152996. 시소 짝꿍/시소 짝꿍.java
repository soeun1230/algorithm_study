import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public long solution(int[] weights) {
        long answer=0;
        int size=weights.length;
        int[]Weights = new int[4001];
        int[]ch = new int[100001];
        
        Weights[weights[0]*2]+=1;
        Weights[weights[0]*3]+=1;
        Weights[weights[0]*4]+=1;
        
        ch[weights[0]]=1;
        
        for(int i=1;i<size;i++){
            for(int j=2;j<=4;j++){
                if(Weights[weights[i]*j]>0){
                    answer+=Weights[weights[i]*j];
                }
                Weights[weights[i]*j]+=1;
            }
            if(ch[weights[i]]>0){
                answer-=ch[weights[i]]*3;
                answer+=ch[weights[i]];
            }
            ch[weights[i]]+=1;
        }
        
        return answer;
    } 
}