import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] threeStu;
    public int answer=0;
    public int[] visited;
    public int student;
    public int[] stuNum;
    public int solution(int[] number) {
        student = number.length;
        stuNum = number;
        threeStu = new int[student];
        visited = new int[student+1];
        
        dfs(0,0);
        
        return answer;
    }
    
    public void dfs(int depth, int start){
        if(depth==3){
            int sum=0;
            for(int i=0;i<3;i++){
                System.out.print(threeStu[i]+" ");
                sum+=threeStu[i];
            }
            System.out.println();
            if(sum==0){
                answer++;
            }
            return;
        }
        for(int i=start;i<student;i++){
            if(visited[i]==1) continue;
            int curStu = stuNum[i];
            visited[i]=1;
            threeStu[depth]=curStu;
            dfs(depth+1,i+1);
            visited[i]=0;
        }
    }
}