import java.util.*;

class Solution {
    public HashMap<String,Integer> hm = new HashMap<>();
    public TreeMap<String,Integer> ans = new TreeMap<>();
    public int basic, basicFee, plus, plusFee;
    
    public int[] solution(int[] fees, String[] records) {
        
        basic=fees[0];
        basicFee=fees[1];
        plus=fees[2];
        plusFee=fees[3];
        
        for(int i=0;i<records.length;i++){
            String[] now = records[i].split(" ");
            String[] time = now[0].split(":");
            int totalTime = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            String num = now[1];
            String status = now[2];
            
            if(!hm.containsKey(num)){
               hm.put(num,totalTime);
            }
            else{
                int start =hm.get(num);
                int diff = totalTime-start;
                if(ans.containsKey(num)){
                    ans.put(num,ans.get(num)+diff);
                }
                else{
                    ans.put(num,diff);
                }
                hm.remove(num);
            }
            
        }
        for(String car : hm.keySet()){
            int c = 60*23+59;
            if(ans.containsKey(car)){
                ans.put(car,ans.get(car)+c-hm.get(car));
            }
            else{
                ans.put(car,c-hm.get(car));
            }
            
        }
        
        int[] answer = new int[ans.size()];
        // Collections.sort(ans, new Comparator<HashMap<String,Integer>>(){
        //     @Override
        //     public int compare(HashMap<String,Integer>)
        // });
            
        int ind = 0;
        for(String car : ans.keySet()){
            //System.out.println(car+" "+ans.get(car));
            int t = ans.get(car);
            if(t<=basic){
                answer[ind]=basicFee;
            }
            else{
                int over = (t-basic)/plus;
                if((t-basic)%plus!=0){
                    over+=1;
                }
                
                answer[ind]=basicFee+plusFee*over;
            }
            ind++;
        }
        
        return answer;
    }
}