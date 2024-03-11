import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[][] arr;
    public int x,y;
    public int n,m;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        n = park.length;
        m = park[0].length();
        arr = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(park[i].charAt(j)=='S'){
                    x=j;
                    y=i;
                    arr[i][j]=2;
                }
                else if(park[i].charAt(j)=='X'){
                    arr[i][j]=1;
                }
                else{
                    arr[i][j]=0;
                }
            }
        }
        
        int size = routes.length;
        for(int i=0;i<size;i++){
            String[]way = routes[i].split(" ");
            move(way[0],Integer.parseInt(way[1]));
        }
        answer[0]=y;
        answer[1]=x;
        return answer;
    }
    public void move(String w, int len){
        if(w.equals("E")){
            if(x+len<m){
               for(int i=1;i<=len;i++){
                    if(arr[y][x+i]==1) return;
                } 
                x+=len;
            }
            
        }
        else if(w.equals("S")){
            if(y+len<n){
               for(int i=1;i<=len;i++){
                    if(arr[y+i][x]==1) return;
                } 
                y+=len;
            }
        }
        else if(w.equals("W")){
            if(x-len>=0){
               for(int i=1;i<=len;i++){
                    if(arr[y][x-i]==1) return;
                } 
                x-=len;
            }
        }
        else{
            if(y-len>=0){
               for(int i=1;i<=len;i++){
                    if(arr[y-i][x]==1) return;
                } 
                y-=len;
            }
        }
    }
}