import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private static List<List<Integer>> graph;

    private static boolean[] visited;

    private static int startVer;

    private static int maxVer;
    private static int graphNum;

    private static int[] incoming;

    private void initGraph(int[][] edges) {
        maxVer = 0;

        for (int[] edge : edges) {
            maxVer = Math.max(maxVer, Math.max(edge[0], edge[1]));
        }

        visited = new boolean[maxVer + 1];
        incoming = new int[maxVer + 1];
        graph = new ArrayList<>(maxVer + 1);

        for (int i = 0; i <= maxVer; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            incoming[edges[i][1]]++;
        }
    }
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
       
        initGraph(edges);

        startVer = findCreatedVer();
        graphNum = graph.get(startVer).size();
        answer[0] = startVer;

        removeEdgesFromCreatedVer(startVer);

        answer[2] = countBarGraphs();

        answer[3] = countEightShape();
        answer[1] = graphNum - (answer[2] + answer[3]);

        return answer;
    }



    private int countBarGraphs() {
        int count = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (i == startVer) {
                continue;
            }
            if (graph.get(i).isEmpty()) {
                count++;
                visited[i] = true;
            }
        }
        return count;
    }

    private int countEightShape() {
        int count = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                if (graph.get(i).size() == 2 && countIncoming(i) == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private int findCreatedVer() {
        int createdVer = -1;
        for (int i = 1; i < graph.size(); i++) {
            if (graph.get(i).size() >= 2 && countIncoming(i) == 0) {
                createdVer = i;
                break;
            }
        }
        visited[createdVer] = true;
        return createdVer;
    }

    private int countIncoming(int ver) {
        return incoming[ver];
    }

    private void removeEdgesFromCreatedVer(int ver) {
        for(int end:graph.get(ver)){
            incoming[end]--;
        }
        graph.set(ver, new LinkedList<>());
    }
}