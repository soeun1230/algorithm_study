import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] wallpaper) {

        int sx=wallpaper[0].length();
        int sy=wallpaper.length;
        int ex=0;
        int ey=0;
        
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    sx = Math.min(sx,j);
                    ex = Math.max(ex,j+1);
                    sy = Math.min(sy,i);
                    ey = Math.max(ey,i+1);
                }
            }
        }
        
        int[] answer = {sy,sx,ey,ex};
        return answer;
    }
}