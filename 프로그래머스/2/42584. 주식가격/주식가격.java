import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] result=new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[i]<prices[stack.peek()]){
                int topIndex = stack.pop();
                result[topIndex]=i-topIndex;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int topIndex = stack.pop();
            result[topIndex] = n-topIndex-1;
        }
        
        return result;
    }
}