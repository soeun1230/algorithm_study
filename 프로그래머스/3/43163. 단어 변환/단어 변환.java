import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] visited;
    public int n;
    public int answer;
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        visited = new int[n];
        
        int min = 50;
        for(int i=0;i<n;i++){
            int ans = bfs(i,begin, target, words);
            if(ans>0 && min>ans) min=ans;
        }
        if(min!=50) return min;
        return 0;
    }
    public boolean checkValid(String a, String b){
        int len = a.length();
        int k =0;
        for(int i=0;i<len;i++){
            if(a.charAt(i)!=b.charAt(i)){
                k++;
            }
            if(k>1) return false;
        }
        return true;
    }
    public int bfs(int idx, String begin, String target, String[] words){
        Queue<Integer> que = new LinkedList<>();
        
        if(checkValid(begin,words[idx])){
            que.offer(idx);
            visited[idx]=1;
        }
        
        
        while(!que.isEmpty()){
            int now = que.poll();
            if(words[now].equals(target)){
                return visited[now];
            }
            
            for(int i=0;i<n;i++){
                if(visited[i]==0 && checkValid(words[now],words[i])){
                    visited[i]=visited[now]+1;
                    que.offer(i);
                }
            }
        }
        return 0;
    }
}