import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    
    public long solution(int r1, int r2) {
        long answer = 0;
 
        long ch=0;

        for(long i=0;i<=r2;i++){
           long y2 = (long)Math.sqrt((long)r2*r2-(long)i*i);
           long y1 = (long)Math.sqrt((long)r1*r1-(long)i*i);

           if(Math.sqrt((long)r1*r1-(long)i*i)%1==0){
               ch++;
           }

            answer+=(y2-y1)*4;
        }

        answer+=ch*4-4;
        
        return answer;
    }

}