import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int n = sizes.length;
        int xmax = 0;
        int ymax = 0;
        
        for(int i=0;i<n;i++){
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int y = Math.min(sizes[i][0], sizes[i][1]);
            
            if(x>xmax) xmax=x;
            if(y>ymax) ymax=y;
        }
        
        int min = xmax*ymax;
        return min;
    }
    
    
}