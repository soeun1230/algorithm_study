import java.util.*;

class Solution {
    public int[] visited;
    public int n;
    public int len;
    public int min=Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        n=words.length;
        len = words[0].length();
        
        for(int i=0;i<n;i++){
            if(isValid(begin,words[i])){
                visited = new int[n];
                int now =bfs(i,words, target);
                if(min>now) min=now;
            }
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }
    public int bfs(int s, String[] word, String tar){
        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        visited[s]=1;
        
        while(!que.isEmpty()){
            int now = que.poll();
            if(word[now].equals(tar)){
                return visited[now];
            }
            for(int i=0;i<n;i++){
                if(visited[i]==0 && isValid(word[now],word[i])){
                    visited[i]=visited[now]+1;
                    que.offer(i);
                }
            }
        }
        return Integer.MAX_VALUE;     
    }
    public boolean isValid(String a, String b){
        int cnt =0;
        for(int i=0;i<len;i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
                if(cnt>1) return false;
            }
        }
        return true;
    }
}