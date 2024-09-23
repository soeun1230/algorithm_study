import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> que = new LinkedList<>();
        
        int now =-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=now){
                que.offer(arr[i]);
                now=arr[i];
            }
        }
        int a = que.size();
        int[] answer = new int[a];
        for(int i=0;i<a;i++){
            answer[i]=que.poll();
        }
        

        return answer;
    }
}