import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> st = new Stack<>();
        
        Stack<Integer> days = new Stack<>();
        
        // progresses= new int[] {20};
        // speeds = new int[] {10};
        
        for(int i=progresses.length-1;i>=0;i--){
            st.push((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(!st.isEmpty()){
            int nowDay = st.pop();
            int cnt=1;
            
            while(!st.isEmpty() && st.peek()<=nowDay){
                st.pop();
                cnt++;
            }
            
            arr.add(cnt);
            
        }
        int[] ans = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}