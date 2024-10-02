import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int h=triangle.length;
        int w=triangle[h-1].length;
        
        int[][] dp = new int[h][w+1];
        dp[0][0]=triangle[0][0];
        
        if(h==1){
            return triangle[0][0];
        }
        
        int max = 0;
        for(int i=1;i<h;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){
                    dp[i][j]=triangle[i][j]+dp[i-1][j];
                    max=Math.max(dp[i][j],max);
                }
                else if(j==triangle[i].length-1){
                    dp[i][j]=triangle[i][j]+dp[i-1][j-1];
                    max=Math.max(dp[i][j],max);
                }
                else{
                    int a = dp[i-1][j-1];
                    int b = dp[i-1][j];
                    dp[i][j]=triangle[i][j]+Math.max(a,b);
                    max=Math.max(dp[i][j],max);
                }
            }
        }

        
        return max;
    }
}