import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public boolean[] visited;
    public ArrayList<String> arr = new ArrayList<>();
    public ArrayList<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        
        arr.add("ICN");  
        dfs("ICN", tickets, 0);
        
        String[] result = new String[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
    public boolean dfs(String from, String[][] tickets, int count) {
        if (count == tickets.length) {
            answer = new ArrayList<>(arr);
            return true; 
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(from)) {
                visited[i] = true;
                arr.add(tickets[i][1]);
                if (dfs(tickets[i][1], tickets, count + 1)) {
                    return true;
                }
                arr.remove(arr.size() - 1); 
                visited[i] = false; 
            }
        }
        return false;
    }
}