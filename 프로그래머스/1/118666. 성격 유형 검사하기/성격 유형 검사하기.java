import java.util.*;

class Solution {
    public HashMap<String, Integer> hm = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        hm.put("R",0);
        hm.put("T",0);
        hm.put("C",0);
        hm.put("F",0);
        hm.put("J",0);
        hm.put("M",0);
        hm.put("A",0);
        hm.put("N",0);
    
        int n= survey.length;
        
        for(int i=0;i<n;i++){
            String now = survey[i];
            int ch = choices[i];
            
            if(ch<4){
                String win = now.substring(0,1);
                int p = 4-ch;
                hm.put(win,hm.get(win)+p);
            }
            else if(ch>4){
                String win = now.substring(1,2);
                int p = ch-4;
                hm.put(win,hm.get(win)+p);
            }
        }
        
        
        if(hm.get("R")<hm.get("T")){
            answer+="T";
        }
        else{
            answer+="R";
        }
        if(hm.get("C")<hm.get("F")){
            answer+="F";
        }
        else{
            answer+="C";
        }
        if(hm.get("J")<hm.get("M")){
            answer+="M";
        }
        else{
            answer+="J";
        }
        if(hm.get("A")<hm.get("N")){
            answer+="N";
        }
        else{
            answer+="A";
        }
        
        
        return answer;
    }
}