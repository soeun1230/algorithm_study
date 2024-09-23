import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        
        Stack<Character>st = new Stack<>();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                st.push('(');
                char now = '(';
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        
        return true;
    }
}