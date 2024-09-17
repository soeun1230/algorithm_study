import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] visited;
    public int[] peop;
    public int cnt=0;
    public int w;
    public int n;
    public int min = 50000;
    
    
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left =0;
        int right =people.length-1;
        int sum =people[0];
        int iniLeft=0;
        
        
        while (left <= right) {
            // 두 사람의 몸무게 합이 limit 이하인 경우, 두 사람을 함께 태웁니다.
            if (people[left] + people[right] <= limit) {
                left++; // 가장 가벼운 사람을 다음으로 이동
            }
            // 항상 가장 무거운 사람을 태우므로, right 포인터는 감소
            right--;
            cnt++; // 보트 사용 횟수 증가
        }

            
        
        
        return cnt;
    }
}