import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] stu = new int[n+1];
        Arrays.fill(stu,1);
        for(int i=0;i<reserve.length;i++){
            stu[reserve[i]]++;
        }
        for(int i=0;i<lost.length;i++){
            stu[lost[i]]--;
        }
        
        
        for(int i=1;i<=n-1;i++){
            if(stu[i]==0){
                if(stu[i-1]==2){
                    stu[i-1]--;
                    stu[i]++;
                }
                else if(stu[i+1]==2){
                    stu[i]++;
                    stu[i+1]--;
                }
            }
        }
        if(stu[n]==0){
            if(stu[n-1]==2){
                stu[n-1]--;
                stu[n]++;
            }
        }
        
        int sum=0;
        for(int i=1;i<=n;i++){
            if(stu[i]!=0){
                sum+=1;
            }
        }
        
        return sum;
    }
}