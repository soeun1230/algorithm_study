import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public ArrayList<String> change;
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
    
        
        change = new ArrayList<>(players.length+1);
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        
        for(int i=0;i<players.length;i++){
            change.add(players[i]);
            hm.put(players[i],i);
        }
        
        
        for(int i=0;i<callings.length;i++){
            String find = callings[i];
            int ind = hm.get(find);
            hm.put(change.get(ind-1),hm.get(change.get(ind-1))+1);
            hm.put(find,hm.get(find)-1);
            //int ind = change.indexOf(find);
            Collections.swap(change,ind,ind-1);
            
            
        }
        for(int i=0;i<players.length;i++){
            answer[i]=change.get(i);
        }
        
        return answer;
    }

}