import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int max=0;
        
        Arrays.sort(citations);
        int n = citations.length;
        
        int min_c = citations[0];
        int max_c = citations[n-1];
        int s = n-1;
        boolean flag=false;
        for(int i =n-1;i>0;i--){
            int now = citations[i];
            while(now>citations[i-1]){
                if(now<=n-i){
                    if(max<now) max=now;
                    flag=true;
                    break;
                }
                now--;
            }
            if(flag){
                break;
            }
        }
        
        if(max==0){
            for(int i=min_c;i>=0;i--){
                if(i<=n){
                    max=i;
                    break;
                }
            }
        }
        
        return max;
    }
}