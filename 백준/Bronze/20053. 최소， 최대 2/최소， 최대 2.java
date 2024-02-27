import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine());
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int small = 1000000000;
            int big = -1000000000;

            for(int j=0;j<k;j++){
                if(!st.hasMoreTokens()){
                    break;
                }
                int put = Integer.parseInt(st.nextToken());
                if(put>big){
                    big=put;
                }
                if(put<small){
                    small=put;
                }
            }
            System.out.println(small+" "+big);
        }
        br.close();
    }
}