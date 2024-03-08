import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,1,-1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String pick = board[h][w];
        int size = board.length;
        
        for(int i=0;i<4;i++){
            int nx=dx[i]+w;
            int ny=dy[i]+h;
            
            
            if(nx>=0 && nx<size && ny>=0 && ny<size){
                String ch = board[ny][nx];
                if(ch.equals(pick)){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}