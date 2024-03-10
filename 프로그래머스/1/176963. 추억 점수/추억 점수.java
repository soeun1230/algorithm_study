import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i=0;i<name.length;i++){
            hm.put(name[i],yearning[i]);
        }
        
        for(int i=0;i<photo.length;i++){
            int result=0;
            for(int j=0;j<photo[i].length;j++){
                String cur = photo[i][j];
                if(hm.containsKey(cur)){
                    result+=hm.get(cur);
                }
            }
            answer[i]=result;
        }
        return answer;
    }
}