import java.util.*;

class Solution {
    public int[] visited;
    public int n;
    public int solution(String begin, String target, String[] words) {
        n=words.length;
        visited = new int[n];
        int min=50;
        
        for(int i=0;i<words.length;i++){
            String now = words[i];
            if(valid(begin,now)){
                visited = new int[n];
                int cnt = bfs(i,target,words);
                if(cnt<min && cnt!=0)min=cnt;
            }
        }
        if(min==50) min=0;
        return min;
    }
    public boolean valid(String a, String b){
        int cnt = 0;
        for(int i =0; i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1) return true;
        return false;
    }
    public int bfs(int b, String t, String[]w){
        Queue<Integer> que = new LinkedList<>();
        que.offer(b);
        visited[b]=1;
        
        while(!que.isEmpty()){
            int nowIn = que.poll();
            String now = w[nowIn];
            if(now.equals(t)){
                return visited[nowIn];
            }
            for(int i=0;i<w.length;i++){
                if(visited[i]==0 && valid(now,w[i])){
                    visited[i]=visited[nowIn]+1;
                    que.offer(i);
                }
            }
        }
        return 0;
    }
}