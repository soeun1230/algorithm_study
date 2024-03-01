import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[]args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = null;
       StringBuilder sb = new StringBuilder();

       String[] input1 = br.readLine().split(" ");
       int N = Integer.parseInt(input1[0]);
       int M = Integer.parseInt(input1[1]);

       TreeMap<String,Integer> tm = new TreeMap<>();
       for(int i=0;i<N;i++){
           String word = br.readLine();
           if(word.length()>=M){
               if(!tm.containsKey(word)){
                   tm.put(word,1);
               }
               else{
                   tm.put(word,tm.get(word)+1);
               }

           }
       }

       List<String> words = new ArrayList<>(tm.keySet());

       Collections.sort(words, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               if (Integer.compare(tm.get(o1), tm.get(o2)) != 0) {
                   return Integer.compare(tm.get(o2), tm.get(o1));
               }
               // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
               if (o1.length() != o2.length()) {
                   return o2.length() - o1.length();
               }
               // 등장 횟수와 길이가 같으면 사전 순으로 정렬
               return o1.compareTo(o2);
           }
       });

       for(String str : words){
           sb.append(str+'\n');
       }

       System.out.println(sb);

       br.close();
    }
}