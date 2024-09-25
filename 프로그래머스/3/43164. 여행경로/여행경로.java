import java.util.*;

class Solution {
    public boolean[] visited;
    public int n;
    public ArrayList<String> route;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }     
                return o1[0].compareTo(o2[0]);
            }
        });
        
        n=tickets.length;
        visited = new boolean[n];
        route = new ArrayList<>();
        
        route.add("ICN");
        dfs("ICN", tickets);
        
        return route.toArray(new String[0]);
    }
    
     private boolean dfs(String current, String[][] tickets) {
        if (route.size() == n + 1) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets)) {
                    return true;
                }
                
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
        
        return false;
    }
}