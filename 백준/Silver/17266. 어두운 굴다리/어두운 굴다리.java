import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int length = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int left;
        int right;
        int between =0;

        st = new StringTokenizer(br.readLine());
        left =right = Integer.parseInt(st.nextToken());

        int leftCur=left;
        for(int i=1;i<num;i++){
            right = Integer.parseInt(st.nextToken());
            between = Math.max(between,right-leftCur);
            leftCur=right;
        }

        int cost = Math.max(left,length-right);
        if(between%2==0){
            between=between/2;
        }
        else{
            between=between/2 +1;
        }
        cost = Math.max(cost,between);

        System.out.println(cost);
    }
}