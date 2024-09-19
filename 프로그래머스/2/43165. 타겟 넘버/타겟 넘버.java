import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int answer = 0;

    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        
        dfs(0,numbers,target,0);
        
        return answer;
    }
    public void dfs(int idx, int[]num, int tar, int curSum){
        if(idx==num.length){
            if(curSum==tar){
                answer++;
            }
            return;
        }
        dfs(idx+1,num,tar,curSum+num[idx]);
        dfs(idx+1,num,tar,curSum-num[idx]);
        
    }
}