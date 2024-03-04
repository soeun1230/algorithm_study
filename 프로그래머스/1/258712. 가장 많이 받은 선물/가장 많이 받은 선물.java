import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(String[] friends, String[] gifts)throws IOException {
        int answer = 0;
        int friendsNum=friends.length;
        
        HashMap<String,Integer> peopId = new HashMap<>();
        int[][] table = new int[friendsNum][friendsNum];
        
        HashMap<String,Integer> score = new HashMap<>();
        
        for(int i=0;i<friendsNum;i++){
            peopId.put(friends[i],i);
            score.put(friends[i],0);
            table[i][i]=-1;
        }
        
        
            
        for(int i=0;i<gifts.length;i++){
            String[] input=gifts[i].split(" ");
            String give = input[0];
            String rv = input[1];
            
            score.put(give,score.get(give)+1);
            score.put(rv,score.get(rv)-1);
            
            table[peopId.get(give)][peopId.get(rv)]+=1;
        }
        
        int[]ans=new int[friendsNum];
        int[][]visited = new int[friendsNum][friendsNum];
        for(int i=0;i<friendsNum;i++){
            for(int j=0;j<friendsNum;j++){
                if(visited[i][j]==1 || visited[j][i]==1) continue;
                visited[i][j]=1;
                visited[j][i]=1;
                if(table[i][j]==0 && table[j][i]==0){
                    if(score.get(friends[i])>score.get(friends[j])){
                        ans[i] += 1;
                    }
                    else if(score.get(friends[i])<score.get(friends[j])){
                        ans[j] += 1;
                    }
                    
                }
                else if(table[i][j]>0 || table[j][i]>0){
                    if(table[i][j]>table[j][i]){
                        ans[i] += 1;
                    }
                    else if(table[i][j]<table[j][i]){
                        ans[j] += 1;
                    }
                    else{
                        if(score.get(friends[i])>score.get(friends[j])){
                            ans[i] += 1;
                        }
                        else if(score.get(friends[i])<score.get(friends[j])){
                            ans[j] += 1;
                        }
                    }
                }
            }
            
        }
        for(int i=0;i<friendsNum;i++){
            answer=Math.max(answer,ans[i]);
        }
        
        return answer;
    }
}