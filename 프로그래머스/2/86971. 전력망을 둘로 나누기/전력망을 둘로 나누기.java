import java.util.*;

class Solution {
    public ArrayList<Integer> arr = new ArrayList<>();
    public int[] visited;
    public int num;
    public int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        num=n-1;
        
        for(int i=0;i<num;i++){
            visited = new int[n];
            visited[i]=1;
            arr.add(wires[i][0]);
            dfs(i,wires[i][0],wires);
            
            // for(int j=0;j<arr.size();j++){
            //     System.out.print(arr.get(j)+" ");
            // }
            // System.out.println();
            
            int now = Math.abs((n-arr.size())-arr.size());
            if(min>now) min=now;
            arr.clear();
        }
        
        return min;
    }
    public void dfs(int ind, int next, int[][] wire){
        for(int i=0;i<num;i++){
            if(visited[i]==0){
                if(wire[i][0]==next){
                    visited[i]=1;
                    arr.add(wire[i][1]);
                    dfs(i,wire[i][1],wire);
                }
                else if(wire[i][1]==next){
                    visited[i]=1;
                    arr.add(wire[i][0]);
                    dfs(i,wire[i][0],wire);
                }
            }
        }
    }
}