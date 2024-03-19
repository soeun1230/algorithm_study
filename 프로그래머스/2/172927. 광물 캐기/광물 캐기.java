import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int answer=0;
    public int sum=0;
    
    public int solution(int[] picks, String[] minerals) {

        int minNum=minerals.length;
        int pickNum=picks[0]+picks[1]+picks[2];
      
        
        String[][] Minerals = new String[minNum/5+1][5];
        
        int idx=0;
        int count=0;
        int group=0;
        for(int i=0;i<minNum;i++){
            Minerals[group][idx]=minerals[i];
            idx++;
            count++;
            if(idx==5){
                idx=0;
                group++;
            } 
            if(count==pickNum*5) break; 
        }
        
        Arrays.sort(Minerals,new Comparator<String[]>(){
            @Override
            public int compare(String[]o1, String[]o2){
                int sum1=0;
                for(int i=0;i<o1.length;i++){
                    if(o1[i]==null)break;
                    if(o1[i].charAt(0)=='d'){
                        sum1+=50;
                    }
                    else if(o1[i].charAt(0)=='i'){
                        sum1+=10;
                    }
                    else{
                        sum1+=1;
                    }
                }
                int sum2=0;
                for(int i=0;i<o2.length;i++){
                    if(o2[i]==null)break;
                    if(o2[i].charAt(0)=='d'){
                        sum2+=50;
                    }
                    else if(o2[i].charAt(0)=='i'){
                        sum2+=10;
                    }
                    else{
                        sum2+=1;
                    }
                }
                return sum2-sum1;
            }
        });
        
        for(int i=0;i<Minerals.length;i++){
            for(int j=0;j<Minerals[i].length;j++){
                System.out.print(Minerals[i][j]+" ");
            }
            System.out.println();
        }
        
        int setNum = Minerals.length;
        int cur=0;
        for(int i=0;i<picks[0];i++){
            String[]now = Minerals[cur];
            for(int j=0;j<5;j++){
                if(now[j]==null) {
                    break;
                }
                answer++;
            }
            cur++;
            if(cur==setNum) return answer;
        }
        for(int i=0;i<picks[1];i++){
            String[]now = Minerals[cur];
            for(int j=0;j<5;j++){
                if(now[j]==null) {
                    break;
                }
                if(now[j].charAt(0)=='d'){
                    answer+=5;
                }
                else{
                    answer++;
                }
            }
            cur++;
            if(cur==setNum) return answer;
        }
        for(int i=0;i<picks[2];i++){
            String[]now = Minerals[cur];
            for(int j=0;j<5;j++){
                if(now[j]==null) {
                    break;
                }
                if(now[j].charAt(0)=='d'){
                    answer+=25;
                }
                else if(now[j].charAt(0)=='i'){
                    answer+=5;
                }
                else{
                    answer++;
                }
            }
            cur++;
            if(cur==setNum) return answer;
        }
        return answer;
    }
}