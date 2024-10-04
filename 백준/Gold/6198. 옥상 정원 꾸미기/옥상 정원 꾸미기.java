import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        if(n==1){
            System.out.println(0);
            return;
        }


        Stack<int[]> st = new Stack<>();
        int[] answer = new int[n];

        answer[n-1]=0;
        st.push(new int[]{arr[n-1],n-1});


        if(arr[n-1]<arr[n-2]){
            answer[n-2]=1;
            st.pop();
            st.push(new int[]{arr[n-2],n-2});
        }
        else{
            answer[n-2]=0;
            st.push(new int[]{arr[n-2],n-2});
        }

        for(int i=n-3;i>=0;i--){
            int now = arr[i];
            while(!st.isEmpty()){
                if(now>st.peek()[0]){
                    st.pop();
                }
                else{
                    answer[i]=st.peek()[1]-i-1;
                    st.push(new int[]{arr[i],i});
                    break;
                }
            }
            if(st.isEmpty()){
                answer[i]=n-1-i;
                st.push(new int[]{arr[i],i});
            }
        }

        long sum=0;
        for(int i : answer){
            //System.out.print(i+" ");
            sum+=i;
        }
        System.out.println(sum);
    }
}