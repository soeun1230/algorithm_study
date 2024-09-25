import java.util.*;

class Solution {
    public HashSet<Integer> hs = new HashSet<>();
    public int n;
    public int[] visited;
    public int cnt=0;
    
    public int solution(String numbers) {
        //가능한 수 만들기 
        n=numbers.length();
        visited = new int[n];
        dfs(0,numbers,"");
    
        
        //소수인지 점검 
        isPrime();
        return cnt;
    }
    public void dfs(int len, String num, String cur){
        if(len==n){
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                String now = cur+num.substring(i,i+1);
                visited[i]=1;
                hs.add(Integer.parseInt(now));
                dfs(len+1,num,now);
                visited[i]=0;
            }
        }
    }
    public void isPrime(){
        boolean flag = true;
        for(int i : hs){
            flag=true;
            if(i==1 || i==0) {
                continue;
            }
            if(i==2) {
                cnt++;
                continue;
            }
            if(i==3) {
                cnt++;
                continue;
            }
            
            for(int d=2;d<=Math.sqrt(i);d++){
                if(i%d==0){
                    flag=false;
                    break;
                }
            }
            if(flag) {
                cnt++;
            }
        }
    }
}