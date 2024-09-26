import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<numbers.length;i++){
            arr.add(numbers[i]);
        }
        
        Collections.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                String com1 = String.valueOf(o1)+String.valueOf(o2);
                String com2 = String.valueOf(o2)+String.valueOf(o1);
                
                return Integer.parseInt(com2)-Integer.parseInt(com1);
            }
        });
        
        String answer = "";
        String ch ="";
        for(int i=0;i<numbers.length;i++){
            answer+=String.valueOf(arr.get(i));
            ch+="0";
        }
        if(answer.equals(ch)){
            answer="0";
        }
        return answer;
    }
}