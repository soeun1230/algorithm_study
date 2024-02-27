import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        if(n>3){
            int k=0;
            while(n>0){
                k++;
                if(n>3){
                    n-=3;
                }
                else if(n==3){
                    break;
                }
                else{
                    n-=1;
                }
            }
            if(k%2!=0){
                sb.append("SK");
            }
            else{
                sb.append("CY");
            }
        }
        else if(n==3 || n==1){
            sb.append("SK");
        }
        else if(n==2){
            sb.append("CY");
        }

        System.out.println(sb.toString());
        br.close();
    }
}