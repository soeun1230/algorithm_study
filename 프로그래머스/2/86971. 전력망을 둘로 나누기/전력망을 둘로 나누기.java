import java.util.*;

class Solution {
    public ArrayList<Integer> arr1;
    public int min=100;
    public int[] visited;
    
    public int solution(int n, int[][] wires) {
        visited = new int[wires.length];
        arr1=new ArrayList<>();
        //끊을 전선
        for(int i=0;i<wires.length;i++){
            int[] cut =wires[i];
            visited = new int[wires.length];
            arr1.clear();
            visited[i]=1;
            arr1.add(cut[0]);
            dfs(cut[0],wires);
            //System.out.print(arr1.size()+" ");
            int k = n-(arr1.size());
            int dif = Math.abs(arr1.size()-k);
            if(dif<min) min=dif;
        }
        
        return min;
    }
    public void dfs(int cur, int[][] wires){
        for(int i=0;i<wires.length;i++){
            if(visited[i]==0){
                if(wires[i][0]==cur){
                    visited[i]=1;
                    arr1.add(wires[i][0]);
                    dfs(wires[i][1],wires);
                    //visited[i]=0;
                    //arr1.remove(arr1.size()-1);
                }
                else if(wires[i][1]==cur){
                    visited[i]=1;
                    arr1.add(wires[i][1]);
                    dfs(wires[i][0],wires);
                    //visited[i]=0;
                    //arr1.remove(arr1.size()-1);
                }
            }
        }
    }
}