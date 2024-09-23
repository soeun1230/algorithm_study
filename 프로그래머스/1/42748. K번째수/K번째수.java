import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int s = commands[i][0]-1;
            int e = commands[i][1]-1;
            int k = commands[i][2]-1;
            
            int[] arr = new int[e-s+1];
            int cnt=0;
            for(int j=s;j<=e;j++){
                arr[cnt]=array[j];
                cnt++;
            }
            Arrays.sort(arr);
            answer[i]=arr[k];
        }
        return answer;
    }
}