import java.util.*;
import java.io.*;

public class Main {
    public static int max = Integer.MIN_VALUE;
    public static int[] visited;
    public static int min=Integer.MAX_VALUE;
    public static int[] vi;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }

        ArrayList<Integer> di = new ArrayList<>();
        for(int i=0;i<4;i++){
            int k = sc.nextInt();
            for(int j=0;j<k;j++){
                di.add(i); //0=+ 1=- 2=* 3=/
            }
        }

        visited = new int[n];
        vi = new int[n];

        vi[0]=1;
        dfs(1,n,arr.get(0),arr,di);
        System.out.println(max);
        System.out.println(min);

    }
    public static void dfs(int dep, int n, int cur, ArrayList<Integer>num, ArrayList<Integer>pp){
        if(dep == n){
            if(cur>max) max=cur;
            if(cur<min) min=cur;
            //System.out.println("="+cur);
            return;
        }

            int now = num.get(dep);
            if(vi[dep]==0) {
                vi[dep] = 1;

                for (int j = 0; j < n - 1; j++) {
                    if (visited[j] == 0) {
                        visited[j] = 1;
                        int ch = pp.get(j);
                        if (ch == 0) {
                            dfs(dep + 1, n, cur + now, num, pp);
                            //System.out.print("+"+now);
                        } else if (ch == 1) {
                            dfs(dep + 1, n, cur - now, num, pp);
                            //System.out.print("-"+now);
                        } else if (ch == 2) {
                            dfs(dep + 1, n, cur * now, num, pp);
                            //System.out.print("*"+now);
                        } else {
                            dfs(dep + 1, n, cur / now, num, pp);
                            //System.out.print("/"+now);
                        }
                        visited[j] = 0;
                        vi[dep] = 0;
                    }
                }
            }
    }

}
