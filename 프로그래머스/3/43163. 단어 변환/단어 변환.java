import java.util.*;
import java.lang.*;
import java.io.*;

public class arr{
    int idx;
    String w;
    public arr(int idx, String w){
        this.idx= idx;
        this.w=w;
    }
}

class Solution {
    public int[] visited;
    public String[] word;
    public int n,m;
    public String tar;
    public String beg;
    
    public int solution(String begin, String target, String[] words) {
        m=words.length;
        n=words[0].length();
        
        word = words;
        visited = new int[m+1];
        tar=target;
        beg = begin;
        
        return bfs();
        
    }
    
    public int validCheck(String w, String t){
        int cnt=0;
        for(int i=0;i<n;i++){
            if(w.charAt(i)!=t.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1){
            return 1;
        }
        return 0;
    }
    public int bfs(){
        Queue<arr> que = new LinkedList<>();
        arr arr1 = new arr(0, beg);
        que.offer(arr1);
        visited[0]=0;
   
        
        while(!que.isEmpty()){
            arr now = que.poll();
            int idx = now.idx;
            String w = now.w;
            
            if(tar.equals(w)){
                return visited[idx];
            }
            
            for(int i=1;i<=m;i++){                
                if(validCheck(w,word[i-1])==1 && visited[i]==0){
                    //System.out.println(word[i-1]);
                    visited[i]=visited[idx]+1;
                    arr arr2 = new arr(i,word[i-1]);
                    que.offer(arr2);
                }
            }
        }
        return 0;
    }
}