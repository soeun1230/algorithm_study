import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            arr.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String order1 = o1+o2;
                String order2 = o2+o1;
                
                return Integer.parseInt(order2)-Integer.parseInt(order1);
            }
        });
        
        String ch="";
        for(int i=0;i<arr.size();i++){
            answer+=arr.get(i);
            ch+="0";
        }
        
        if(answer.equals(ch)){
            return "0";
        }
        
        return answer;
    }
}