import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    static HashMap<Integer,Integer> city;
    static int[] fuel;
    static int N;
    static int fuelSum=0;
    static int[] visited;
    static int Ans = 0;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        city = new HashMap<>();
        fuel=new int[N+1];
        fuel[0]=0;
        StringTokenizer f = new StringTokenizer(br.readLine());
        for(int i=1;i<=N-1;i++){
            int cur=Integer.parseInt(f.nextToken());
            fuel[i]=cur;
            fuelSum+=cur;
        }
        StringTokenizer c = new StringTokenizer(br.readLine());
        for(int i=1;i<=N-1;i++){
            int cur=Integer.parseInt(c.nextToken());
            city.put(i,cur);
        }

        List<Integer> citys = new ArrayList<>(city.keySet());

        citys.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return city.get(o1).compareTo(city.get(o2));
            }
        });

        visited = new int[N+1];
        int n=0;
        int totalSum=0;
        while(fuelSum>0){
            int sum=0;
            int start = citys.get(n);
            for(int i=start;i<=N-1;i++){
                if(visited[i]==1)continue;
                sum+=fuel[i];
                visited[i]=1;
            }
            totalSum+=sum;
            Ans+= sum*(city.get(start));
            n++;
            if(totalSum==fuelSum) break;
        }

        System.out.println(Ans);
        br.close();
    }
}