import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int size = numbers.length;
        answer = new int[size];
        Arrays.fill(answer,-1);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=size-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=numbers[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                answer[i]=st.peek();
            }
            st.push(numbers[i]);
        }
       
        
        return answer;
    }
}