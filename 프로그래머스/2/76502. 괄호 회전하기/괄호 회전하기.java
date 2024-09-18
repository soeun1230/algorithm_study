import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int cnt=0;
        
        for(int i=0;i<s.length();i++){
            String n_str = s.substring(i)+s.substring(0,i);
            if(validCheck(n_str)==1){
                cnt++;
            }
        }
        return cnt;
    }
    
    public int validCheck(String str){
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char now = str.charAt(i);
            if(now=='[' || now=='{' || now=='('){
                st.push(now);
            }
            else{
                if(st.isEmpty()) return 0;
                else{
                    char ch = st.pop();
                    if(ch=='[' && now==']');
                    else if(ch=='{' && now=='}');
                    else if(ch=='(' && now==')');
                    else return 0;
                }
            }
        }
        if(!st.isEmpty()) return 0;
        return 1;
    }
       
}