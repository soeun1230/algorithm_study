import java.util.*;

class Solution {
    public String[] w = {"A","E","I","O","U"};
    public ArrayList<String> arr = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("",word);
        answer = arr.size();
        
        return answer;
    }
    public boolean dfs(String cur, String tar){
        if(cur.equals(tar)){
            return true;
        }
        for(int i=0;i<5;i++){
            
            if((cur+w[i]).length()<=5){
                arr.add(cur+w[i]);
                if(dfs(cur+w[i],tar)){
                    return true;
                }
            }
            
        }
        return false;
    }
}