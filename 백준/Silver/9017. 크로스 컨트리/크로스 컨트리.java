import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] team = new int[num+1];   //각 팀의 인원수가 몇개
            HashMap<Integer,Integer> hm = new HashMap<>(num+1);
            int[] five = new int[num+1];
            int[] six = new int[num+1];
            int teamNum=0;  //팀이 몇개
            int[] teamName = new int[num+1];  //팀 이름 저장

            ArrayList<Integer> teamLess = new ArrayList<>();
            HashMap<Integer,Integer> test = new HashMap<>();

            for(int l=0;l<num;l++){
                int cur=Integer.parseInt(st.nextToken());
                //team[cur]=team[cur]+1;
                if(!test.containsKey(cur)){
                    test.put(cur,1);
                    teamName[teamNum]=cur;
                    teamNum++;
                }
                else{
                    test.put(cur,test.get(cur)+1);
                }
                teamLess.add(cur);
            }
            for(int h=0;h<teamNum;h++){
                if(test.get(teamName[h])!=6){
                    while(teamLess.remove(Integer.valueOf(teamName[h])));
                }
            }

            for(int j=1;j<=teamLess.size();j++){
                int cur=teamLess.get(j-1);
                team[cur]=team[cur]+1;
                if(team[cur]<=4){
                    if(!hm.containsKey(cur)){
                        hm.put(cur,j);
                    }
                    else{
                        hm.put(cur,hm.get(cur)+j);
                    }
                }
                else if(team[cur]==5){
                    five[cur]=j;
                }
                else{
                    six[cur]=j;
                }
            }

            int small=1000000000;
            int winner=1;
            for(int k=0;k<teamNum;k++){
                int ch = teamName[k];
                if(team[ch]!=6){
                    continue;
                }
                else{
                     int cur = hm.get(ch);
                     if(cur<small){
                         small=cur;
                         winner=ch;
                     }
                     else if(cur==small){
                         if(five[winner]>five[ch]){
                             winner=ch;
                         }
                     }
                }
            }
            System.out.println(winner);
        }
    }
}