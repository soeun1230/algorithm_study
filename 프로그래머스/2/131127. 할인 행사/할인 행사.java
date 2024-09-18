import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> hm = new HashMap<>();
        int ans=0;
        
        for(int i=0;i<want.length;i++){
            hm.put(want[i],number[i]);
        }
        
        for(int i=0;i<discount.length;i++){
            for(int j=0;j<10;j++){
                if((j+i)>=discount.length) break;
                String now = discount[i+j];
                if(hm.containsKey(now)){
                    if(hm.get(now)>0){
                        hm.put(now,hm.get(now)-1);
                    }
                }
            }
            Collection<Integer>list = hm.values();
            int sum=0;
            for(int k : list){
                sum+=k;
            }
            if(sum==0){
                ans++;
            }
            for(int t=0;t<want.length;t++){
                hm.put(want[t],number[t]);
            }
        }
        
        return ans;
    }
}