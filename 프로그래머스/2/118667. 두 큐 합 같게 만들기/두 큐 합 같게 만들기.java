import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        int iniSize =queue1.length;
        
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long totalSum = 0;
        for(int i=0;i<iniSize;i++){
            que1.add(queue1[i]);
            totalSum+=queue1[i];
            
            que2.add(queue2[i]);
            totalSum+=queue2[i];
        }
        //System.out.println(totalSum);
        if(totalSum%2!=0){
            answer=-1;
        }
        else{
            long sum = totalSum/2;
             //System.out.println(sum);
            int ch=0;
            long nowSum = getSum(que1);
            while(true){
                if(nowSum>sum){
                    //System.out.println(getSum(que1));
                    int now = que1.poll();
                    nowSum-=now;
                    que2.add(now);
                    ch++;
                }
                else if(nowSum<sum){
                    int now = que2.poll();
                    nowSum+=now;
                    que1.add(now);
                    ch++;
                }
                else{
                    answer=ch;
                    break;
                }
                if(ch>iniSize*4){
                    answer=-1;
                    break;
                }
            }
        }
        
        return answer;
    }
    public long getSum(Queue<Integer>que){
        Queue<Integer>q = new LinkedList<>(que);
        
        long sum=0;
        while(!q.isEmpty()){
            sum+=q.poll();
        }
        return sum;
    }
}