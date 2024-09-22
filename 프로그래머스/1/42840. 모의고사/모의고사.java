import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] n1 = {1,2,3,4,5};
    public int[] n2 = {2,1,2,3,2,4,2,5};
    public int[] n3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int a1=0,a2=0,a3=0;
    
    public int[] solution(int[] answers) {
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==n1[i%5]) a1++;
            if(answers[i]==n2[i%8]) a2++;
            if(answers[i]==n3[i%10]) a3++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int max =0;
        if(a1>a2){
            max=a1;
            ans.add(1);
        }
        else if(a1==a2){
            ans.add(1);
            ans.add(2);
            max=a1;
        }
        else{
            ans.add(2);
            max=a2;
        }
        
        if(max<a3){
            ans.clear();
            ans.add(3);
        }
        else if(max==a3){
            ans.add(3);
        }

        int k = ans.size();
        int[] answer = new int[k];
        for(int i=0;i<k;i++){
            answer[i]=ans.get(i);
        }
        
        
        
        return answer;
    }
}