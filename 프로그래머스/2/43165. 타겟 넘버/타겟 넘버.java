import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return dfs(0,0,numbers,target);
    }
    public int dfs(int depth,int cur, int[] num, int tar){
        if(depth==num.length){
            if(cur==tar) return 1;
            return 0;
        }
        return dfs(depth+1,cur+num[depth],num,tar)+dfs(depth+1,cur-num[depth],num,tar);
    }
}