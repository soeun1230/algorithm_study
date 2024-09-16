import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] num;
    public int len;
    public int tar;
    public int cnt=0;
    
    public int solution(int[] numbers, int target) {
        num = numbers;
        len = numbers.length;
        tar = target;
        
        dfs(0,0);
        return cnt;
    }
    
    public void dfs(int depth, int sum){
        if(depth==len){
            if(sum==tar){
                cnt++;
            }
            return;
        }
 
        dfs(depth+1, sum+num[depth]);
        dfs(depth+1, sum-num[depth]);
        
    }
}