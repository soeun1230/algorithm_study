import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<citations.length;i++){
            arr.add(citations[i]);
        }
        
        Collections.sort(arr, Collections.reverseOrder());
        int max =0;
        boolean flag = false;
        for(int i=0;i<arr.size()-1;i++){
            int nowCi = arr.get(i);
            while(nowCi>arr.get(i+1)){
                if(nowCi<=i+1){
                    max = nowCi;
                    flag= true;
                    break;
                }
                nowCi--;
            }
            if(flag) break;
        }
        
        if(max==0){
            int k =arr.get(arr.size()-1);
            while(k>0){
                if(k==arr.size()){
                    max=k;
                }
                k--;
            }
        }
  
        return max;
    }
}