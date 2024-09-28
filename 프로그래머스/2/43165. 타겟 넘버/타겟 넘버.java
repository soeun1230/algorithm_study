import java.util.*;

class Solution {
    public int n;
    public int[] visited;
    public int[] num;
    public int cnt=0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        n = numbers.length;
        visited = new int[n];
        num = numbers;
        
        int cnt =dfs(0,0,target);
        
        return cnt;
    }
    public int dfs(int dep, int cur, int tar){
        if(dep==n){
            if(cur==tar){
                return 1;
            }
            return 0;
        }

        return dfs(dep+1,cur+num[dep],tar) + dfs(dep+1, cur-num[dep],tar);
    }
}