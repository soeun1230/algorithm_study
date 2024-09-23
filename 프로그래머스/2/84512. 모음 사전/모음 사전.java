import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<String> arr = new ArrayList<>();
    public char[] alpha = {'A','E','I','O','U'};
    
    public int solution(String word) {
        dfs(0,"");
        int cnt = arr.indexOf(word)+1;
        return cnt;
    }
    public void dfs(int depth, String cur){
        if(depth==5){
            return;
        }
        for(char c : alpha){
            String nw = cur+c;
            arr.add(nw);
            dfs(depth+1,nw);
        }
    }
}