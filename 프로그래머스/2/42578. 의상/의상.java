import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    public int cnt=1;
    public int[] visited;
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(!hm.containsKey(clothes[i][1])){
                hm.put(clothes[i][1],1);
            }
            else{
                hm.put(clothes[i][1],hm.get(clothes[i][1])+1);
            }
        }
        ArrayList<Integer>arr = new ArrayList<>();
        int kind =0;
        for(int i : hm.values()){
            cnt*=(i+1);
        }

        
        
        return cnt-1;
    }
}