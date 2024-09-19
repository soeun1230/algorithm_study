import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int n;
    public int answer=0;
    public int[] visited;
    public int[] num;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        visited = new int[n];
        num = numbers;
        for(int i=0;i<n;i++){
            visited[i]=1;
        }
        dfs(0,0,target);
        return answer;
    }
    public void dfs(int idx, int sum,int tar){
        if(idx==n){
            if(sum==tar){
                answer++;
            }
            return;
        }
        
        dfs(idx+1,sum+num[idx],tar);
        dfs(idx+1,sum-num[idx],tar);
        
    }
    
}