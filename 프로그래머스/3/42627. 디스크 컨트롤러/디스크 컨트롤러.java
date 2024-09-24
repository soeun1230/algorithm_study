import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparing(a->a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[1]));
        
        int curTime =0;
        int jobIdx =0;
        int totalWait =0;
        int complete =0;
        
        while(complete<jobs.length){
            while(jobIdx<jobs.length && jobs[jobIdx][0]<=curTime){
                pq.add(jobs[jobIdx]);
                jobIdx++;
            }
            if(!pq.isEmpty()){
                int[] curJob = pq.poll();
                curTime += curJob[1];
                totalWait += (curTime-curJob[0]);
                complete++;
            }
            else{
                if(jobIdx < jobs.length){
                    curTime = jobs[jobIdx][0];
                }
            }
        }
        
        return totalWait/jobs.length;
    }
}