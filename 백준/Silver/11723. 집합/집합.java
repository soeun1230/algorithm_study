import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int arr =0;

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int t=0;


        for(int j=0;j<n;j++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(st.hasMoreTokens()){
                t = Integer.parseInt(st.nextToken());
            }

            if(input.equals("add")){
                arr = arr | (1<<(t-1));
            }
            else if(input.equals("check")){
                if((arr&(1<<(t-1)))!=0){
                    sb.append(1);
                    sb.append('\n');
                }
                else{
                    sb.append(0);
                    sb.append('\n');
                }
            }
            else if(input.equals("remove")){
                arr = arr & (~(1 << (t-1)));
            }
            else if(input.equals("toggle")){
                arr ^= (1<<(t-1));
            }
            else if(input.equals("all")){
                arr |= (~0);
            }
            else if(input.equals("empty")){
                arr &= 0;
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}