import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int cnt=0;
        for(int i=0;i<data.length;i++){
            if(data[i][getindex(ext)]<val_ext){
                cnt++;
            }
        }
        
        int[][] answer = new int[cnt][4];
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[getindex(sort_by)]-o2[getindex(sort_by)]; 
            }
        });
        
        int i=0;
        int ans_i=0;
        while(i>=0){
            //System.out.print(data[i])
            if(data[i][getindex(ext)]<val_ext){
                for(int k=0;k<4;k++){
                    //System.out.print(data[i][k]+" ");
                    answer[ans_i][k]=data[i][k];
                    System.out.print(answer[ans_i][k]+" ");
                }
                System.out.println();
                ans_i++;
            }
            i++;
            if(i==data.length) break;
        }
        
        return answer;
    }
    public int getindex(String a){
        if(a.equals("code")){
            return 0;
        }
        else if(a.equals("date")){
            return 1;
        }
        else if(a.equals("maximun")){
            return 2;
        }
        else{
            return 3;
        }
    }
}