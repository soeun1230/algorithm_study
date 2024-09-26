import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && prices[i]<prices[st.peek()]){
                answer[st.peek()]=i-st.pop();
            }
            st.push(i);
        }
        int l = st.size();
        for(int i=0;i<l;i++){
            answer[st.peek()]=n-1-st.pop();
        }
        
        return answer;
    }
}