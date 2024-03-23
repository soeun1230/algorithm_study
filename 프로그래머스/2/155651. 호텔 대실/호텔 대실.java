import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[][]Book;
    public int size;
    public int solution(String[][] book_time) {
        int answer = 0;
        size=book_time.length;
        Book=new int[size][2];
        
        for(int i=0;i<size;i++){
            String[]cur=book_time[i];
            String[] start=cur[0].split(":");
            String[] end=cur[1].split(":");
            int s = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
            int e = Integer.parseInt(end[0])*60+Integer.parseInt(end[1]);
            Book[i][0]=s;
            Book[i][1]=e;
        }
        
        Arrays.sort(Book,new Comparator<int[]>(){
            @Override
            public int compare(int[]o1,int[] o2){
                return o2[1]-o1[1];
            }
        });
        
        // for(int i=0;i<size;i++){
        //     System.out.print(Book[i][0]+" ");
        //     System.out.println(Book[i][1]);
        // }
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int i=0;i<size;i++){
            int[]cur=Book[i];
            int curStart=cur[0];
            int curEnd=cur[1];
            int ch = leftRoom(arr, curEnd);
            if(ch>=0){
                arr.get(ch)[0]=curStart;
                arr.get(ch)[1]=curEnd;
            }
            else{
                int[] put = new int[2];
                put[0]=curStart;
                put[1]=curEnd;
                arr.add(put);
                answer++;
            }
        }
        return answer;
    }
    public int leftRoom(ArrayList<int[]>arr, int curEnd){
        int n=arr.size();
        for(int j=0;j<n;j++){
            if(arr.get(j)[0]-10>=curEnd) return j;
        }
        return -1;
    }
}