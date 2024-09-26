import java.util.*;

class Solution {
    public String[] al= {"A","E","I","O","U"};
    public int n;
    public ArrayList<String> arr;
    public boolean flag;
    
    public int solution(String word) {
        n = word.length();
        arr = new ArrayList<>();
        flag=false;
        dfs("",word);
        
        return arr.size();
    }
    public void dfs(String cur, String w){
        if(cur.equals(w)){
            flag=true;
            return;
        }
        for(int i=0;i<5;i++){
            if(flag==true) return;
            if((cur+al[i]).length()<=5){
                arr.add(cur+al[i]);
                dfs(cur+al[i],w);
            }
        }
    }
}