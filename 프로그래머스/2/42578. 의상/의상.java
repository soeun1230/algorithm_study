import java.util.*;

class Solution {
    public HashMap<String, Integer> hm = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for(int i=0;i<clothes.length;i++){
            String k = clothes[i][1];
            if(hm.containsKey(k)){
                hm.put(k,hm.get(k)+1);
            }
            else{
                hm.put(k,1);
            }
        }
        
        for(int i : hm.values()){
            int[] visited = new int[i];
            answer*=(i+1);
        }
        
        return answer-1;
    }

}