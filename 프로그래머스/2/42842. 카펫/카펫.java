import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=(int)Math.ceil(brown/4.0)+1;i<=(brown-2)/2;i++){
            int height = (brown-i*2)/2;
            //System.out.println("H : "+height);
            //System.out.println("i : "+i);
            
            if(yellow%(i-2)==0 && yellow/((i-2)) == height){
                answer[0]=i;
                answer[1]=height+2;
            }
        }
        
        return answer;
    }
}