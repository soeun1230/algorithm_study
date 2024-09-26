import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int i=0;i<n;i++){
            int s = commands[i][0]-1;
            int e = commands[i][1]-1;
            
            int len = e-s+1;
            int[] ch = new int[len];
            for(int j=0;j<len;j++){
                ch[j]=array[s+j];
            }
            Arrays.sort(ch);
            answer[i]=ch[commands[i][2]-1];
        }
        
        return answer;
    }
}