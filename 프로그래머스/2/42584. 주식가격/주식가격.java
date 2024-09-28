import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        
        int n = prices.length;
        int[] answer = new int[n];
        
        st.push(0);
        for(int i=0;i<prices.length-1;i++){
            while(!st.isEmpty()){
                if(prices[st.peek()]>prices[i]){
                    answer[st.peek()]=i-st.pop();
                }
                else{
                    break;
                }
            }
            st.push(i);
        }
        for(int i : st){
            answer[i]=n-i-1;
        }
        return answer;
    }
}