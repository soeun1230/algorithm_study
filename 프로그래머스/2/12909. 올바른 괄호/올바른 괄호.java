import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char n = s.charAt(i);
            if(n=='('){
                st.push(n);
            }
            else{
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if(ch=='('){
                }
                else{
                    return false;
                }
            }
            
        }
        if(!st.isEmpty()) return false;
        return answer;
    }
}