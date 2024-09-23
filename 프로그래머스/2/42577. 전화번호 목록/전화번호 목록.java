import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        
        // Arrays.sort(phone_book, new Comparator<String>(){
        //     @Override
        //     public int compare(String o1, String o2){
        //         return o2.length()-o1.length();
        //     }
        // });
        
        HashSet<Integer> len = new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            len.add(phone_book[i].length());
        }

        
        HashSet<String> ch = new HashSet<>();
        for(int i:len){
            int cnt=0;
            for(int j=0;j<phone_book.length;j++){
                if(i<phone_book[j].length()){
                    hs.add(phone_book[j].substring(0,i));
                    ch.add(phone_book[j].substring(0,i));
                    cnt++;
                }
                else{
                    hs.add(phone_book[j].substring(0));
                }
            }
            if(phone_book.length-(hs.size()+(cnt-ch.size()))!=0) return false;
            hs.clear();
            ch.clear();
        }
        
        
        
        return answer;
    }
}